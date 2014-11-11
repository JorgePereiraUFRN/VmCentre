package br.ufrn.consiste.DriverManager;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.ufrn.consiste.CloudDriver.CloudDriver;
import br.ufrn.consiste.model.ResponseAPI;
import br.ufrn.consiste.model.VirtualMachine;

public interface DriverManager extends Remote{
	
	
	public void addDriver(String plataform, String driverPath) throws RemoteException;
	
	public CloudDriver getDriver(String plataform) throws RemoteException;
	
	public String[] getAvaliableDrivers() throws RemoteException;
	
	VirtualMachine getVM( String plataform, String id) throws RemoteException;

	 List<VirtualMachine> getAllVM( String plataform) throws RemoteException;

	 ResponseAPI createVM( String plataform, String imageId) throws RemoteException;

	 ResponseAPI deleteVM( String plataform, String id) throws RemoteException;

	 ResponseAPI startVM( String plataform, String id) throws RemoteException;

	 ResponseAPI suspendVM( String plataform, String id) throws RemoteException;

	 ResponseAPI stopVM( String plataform, String id) throws RemoteException;

}
