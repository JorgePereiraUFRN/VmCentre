package br.ufrn.consiste.CloudMonitor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Random;

import br.ufrn.consiste.model.ResourcesUsage;
import br.ufrn.consiste.model.Thresholds;

public class TestClient {

	public static void main(String[] args) {
		try {

			String hostName = "localhost";

			String portNum = "2000";

			int time = 60;
			String regURL = "rmi://" + hostName + ":" + portNum
					+ "/CloudMonitor";
			CloudMonitor h = (CloudMonitor) Naming.lookup(regURL);
			System.out.println("Lookup completed ");

			ClientCloudMonitor callbackObj = new ClientImpl();
			long idclient = h.register(register());

			System.out.println("Registered for callback.");

			Thresholds thresholds = new Thresholds();
			thresholds.setCpuMaxThreshold(0.5);
			thresholds.setCpuMinThreshold(0.4);
			thresholds.setMemoryMaxThreshold(0.5);
			thresholds.setMemoryMinThreshold(0.4);
			thresholds.setStorageMaxThreshold(0.7);

			 long m1 = h.monitoreVM(idclient, "127.0.0.1", 8080, "tomcat",
			 "tomcat", thresholds);
			 
			//long m2 = h.monitoreVM(idclient, "54.211.141.9", 8080, "tomcat",
		//		"tomcat", thresholds);
			

			System.out.println("id da vm monitorada "+m1);
			
			try {
				Thread.sleep(time * 1000);
				// h.unregister(id);
				// System.out.println("Unregistered for callback.");
			} catch (InterruptedException ex) { /* sleep over */
			}

			for (;;) {

				System.out.println("\n\n buscando map de metricas\n\n");
				Map<Long, ResourcesUsage> reUsages = h.getMestricsVMs(idclient,
						new Long[] { m1 });

				for (ResourcesUsage r : reUsages.values()) {
					System.out.println("cpuUsage: " + r.getCpuUsage()
							+ " MemoryUsage: " + r.getMemoryUsage()
							+ "\n storageUsage: " + r.getStorageUsage()
							+ " Send bytes: " + r.getTxBytes()
							+ "\n Recieve bytes: " + r.getRxBytes());
				}

				Thread.sleep(1000 * 30);
			}
			
			
			
		} // try
		catch (Exception e) {
			System.out.println("Exception in CallbackClient : " + e);
		}
	} // main

	public static String  register() {
		String portNum, registryURL = null;

		try {

			int RMIPortNum = new Random().nextInt(50000)+2000;
			startRegistry(RMIPortNum);
			ClientCloudMonitor exportedObj = new ClientImpl();
			registryURL = "rmi://localhost:" + RMIPortNum + "/Client";
			Naming.rebind(registryURL, exportedObj);
		} catch (Exception re) {
			re.printStackTrace();
			System.out.println("Exception: " + re);
		}
		
		return registryURL;

	}

	private static void startRegistry(int RMIPortNum) throws RemoteException {
		try {
			Registry registry = LocateRegistry.getRegistry(RMIPortNum);
			registry.list();
		} catch (RemoteException e) {
			// No valid registry at that port.
			Registry registry = LocateRegistry.createRegistry(RMIPortNum);
		}
	}

}
