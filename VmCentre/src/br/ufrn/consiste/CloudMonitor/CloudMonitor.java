package br.ufrn.consiste.CloudMonitor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import br.ufrn.consiste.model.ResourcesUsage;
import br.ufrn.consiste.model.Thresholds;

public interface CloudMonitor extends Remote {

	long register(String rmiURL) throws RemoteException;

	void unregister(Long clientId) throws RemoteException;

	void monitoreVM(Long clientId, String ipVm, int tomcatPort,
			String tomcatUser, String tomcatPassword, Thresholds thresholds)
			throws RemoteException;

	void monitoringVMCancel(Long clientId, String ipVM) throws RemoteException;
	
	void updatThresholds(Long clientId, String ipVM, Thresholds thresholds) throws RemoteException;

	Map<String, ResourcesUsage> getMestricsVMs(Long clientId, String[] ips, int lastHour)
			throws RemoteException;

}
