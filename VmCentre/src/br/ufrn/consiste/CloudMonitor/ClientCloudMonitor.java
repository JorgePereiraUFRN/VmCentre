package br.ufrn.consiste.CloudMonitor;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCloudMonitor extends Remote{
	
	void cpuThreshold(String ipVm, double cpuUsage) throws RemoteException;
	
	void memoryThreshold(String ipVm, double memoryUsage) throws RemoteException;
	
	void storageThresold(String ipVm, double storageUsage) throws RemoteException;
	
	void txBytesThreshold(String ipVm, long txBytes) throws RemoteException;
	
	void rxBytesthreshold(String ipVm, long rxbytes) throws RemoteException;
	
	

}
