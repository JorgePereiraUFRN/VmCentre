package br.ufrn.consiste.CloudMonitor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements
		ClientCloudMonitor {
	
	

	protected ClientImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cpuThreshold(String ipVm, double cpuUsage) throws RemoteException {
		System.out.println("Client callback: cpu usage = " + cpuUsage);

	}

	@Override
	public void memoryThreshold(String ipVm, double memoryUsage)
			throws RemoteException {
		System.out.println("Client callback: memory usage = " + memoryUsage);

	}

	@Override
	public void storageThresold(String ipVm, double storageUsage)
			throws RemoteException {
		System.out.println("Client callback: storage usage = " + storageUsage);

	}

	@Override
	public void txBytesThreshold(String ipVm, long txBytes)
			throws RemoteException {
		System.out.println("Client callback: txBytes = " + txBytes);

	}

	@Override
	public void rxBytesthreshold(String ipVm, long rxbytes)
			throws RemoteException {
		System.out.println("Client callback: rxBytes = " + rxbytes);

	}
	
	

	
}
