package br.ufrn.consiste.DriverManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Driver;

import br.ufrn.consiste.CloudDriver.CloudDriver;
import br.ufrn.consiste.exceptions.CloudDriverException;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) throws CloudDriverException{
		
		try {
			DriverManager driverManager = (DriverManager) Naming.lookup("rmi://localhost:5000/CloudDriverManager");
			
			driverManager.addDriver("Amazon","/home/jorge/ec2Driver.jar");
			
			String[]drivers = driverManager.getAvaliableDrivers();
			
			for(String d : drivers){
				System.out.println(d);
			}
		
			
			System.out.println(driverManager.getAllVM("Amazon"));
			
			System.out.println(driverManager.createVM("Amazon", "ami-6630b80e"));
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
