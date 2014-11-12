package br.ufrn.consiste.CloudMonitor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class ClientImpl extends UnicastRemoteObject implements
		ClientCloudMonitor {
	
	

	protected ClientImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cpuThreshold(long vmId, double cpuUsage) throws RemoteException {
		System.out.println("Client callback: cpu usage = " + cpuUsage);

	}

	@Override
	public void memoryThreshold(long vmId, double memoryUsage)
			throws RemoteException {
		System.out.println("Client callback: memory usage = " + memoryUsage);

	}

	@Override
	public void storageThresold(long vmId, double storageUsage)
			throws RemoteException {
		System.out.println("Client callback: storage usage = " + storageUsage);

	}

	@Override
	public void txBytesThreshold(long vmId, long txBytes)
			throws RemoteException {
		System.out.println("Client callback: txBytes = " + txBytes);

	}

	@Override
	public void rxBytesthreshold(long vmId, long rxbytes)
			throws RemoteException {
		System.out.println("Client callback: rxBytes = " + rxbytes);

	}
	
	

	
}
