package br.ufrn.consiste.CloudMonitor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Random;

import br.ufrn.consiste.exceptions.CloudMonitorException;
import br.ufrn.consiste.exceptions.RegisterRMIException;
import br.ufrn.consiste.model.InformationsVM;
import br.ufrn.consiste.model.ResourcesUsage;
import br.ufrn.consiste.model.Thresholds;

public class CloudMonitorFacade {

	private static Long idClientCloudMonitor = null;
	private static CloudMonitor cloudMonitor = null;
	private static CloudMonitorFacade cloudMonitorFacade = null;

	private CloudMonitorFacade() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized CloudMonitorFacade getInstance() {
		if (cloudMonitorFacade == null) {
			cloudMonitorFacade = new CloudMonitorFacade();
		}

		return cloudMonitorFacade;
	}

	private static String createRMIRegister() throws RegisterRMIException {

		try {

			int RMIPortNum = new Random().nextInt(50000) + 2000;
			startRegistry(RMIPortNum);
			ClientCloudMonitor exportedObj = new ClientImpl();
			String registryURL = "rmi://localhost:" + RMIPortNum + "/Client";
			Naming.rebind(registryURL, exportedObj);

			return registryURL;
		} catch (Exception re) {
			throw new RegisterRMIException("Erro ao criar registro RMI");
		}

	}

	private static void startRegistry(int RMIPortNum) throws RemoteException {
		try {
			Registry registry = LocateRegistry.getRegistry(RMIPortNum);
			registry.list();
		} catch (RemoteException e) {
			Registry registry = LocateRegistry.createRegistry(RMIPortNum);
		}
	}

	public void registerInCloudMonitor() throws RegisterRMIException {

		String cloudMonitorURL = "rmi://" + "localhost" + ":" + "2000"
				+ "/CloudMonitor";
		try {
			cloudMonitor = (CloudMonitor) Naming.lookup(cloudMonitorURL);

			String registerClient = createRMIRegister();

			idClientCloudMonitor = cloudMonitor.register(registerClient);

		} catch (MalformedURLException | RemoteException | NotBoundException
				| RegisterRMIException e) {
			e.printStackTrace();

			throw new RegisterRMIException(
					"Erro ao recuperar interface do Cloud Monitor. "
							+ e.getMessage());

		}

	}

	public void monitoreVM(InformationsVM informations)
			throws CloudMonitorException {

		try {
			if (cloudMonitor == null) {
				registerInCloudMonitor();
			}

			cloudMonitor.monitoreVM(idClientCloudMonitor,
					informations.getVmIp(), informations.getTomcatPort(),
					informations.getTomcatUser(),
					informations.getTomcatPassword(),
					informations.getThresholds());

		} catch (RegisterRMIException | RemoteException e) {
			throw new CloudMonitorException("Erro ao moitorar VM. "
					+ e.getMessage());
		}

	}

	public void cancelMonitoringVM(String ipVM) throws CloudMonitorException {

		try {
			if (cloudMonitor == null) {
				registerInCloudMonitor();
			}

			cloudMonitor.monitoringVMCancel(idClientCloudMonitor, ipVM);

		} catch (RegisterRMIException | RemoteException e) {
			throw new CloudMonitorException(
					"Erro ao cancelar o monitoramento da VM.");
		}
	}

	public void updatThresholds(String ipVM, Thresholds thresholds)
			throws CloudMonitorException {
		try {
			if (cloudMonitor == null) {
				registerInCloudMonitor();
			}

			cloudMonitor
					.updatThresholds(idClientCloudMonitor, ipVM, thresholds);

		} catch (RegisterRMIException | RemoteException e) {
			throw new CloudMonitorException("Erro ao atualizar os thresholds.");
		}
	}

	public ResourcesUsage getAverageResourcesUsage(String ipVm, int lastHours)
			throws CloudMonitorException {
		try {
			if (cloudMonitor == null) {
				registerInCloudMonitor();
			}

			
			Map<String, ResourcesUsage> reUsage = cloudMonitor.getMestricsVMs(
					idClientCloudMonitor, new String[] { ipVm }, lastHours);

			return reUsage.get(ipVm);

		} catch (RegisterRMIException | RemoteException e) {
			throw new CloudMonitorException("Erro ao recuperar as metricas." +e.getMessage());
		}
	}
	
	
}
