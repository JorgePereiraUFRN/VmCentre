package br.ufrn.consiste.CloudDriver;

import java.io.Serializable;
import java.util.List;

import br.ufrn.consiste.exceptions.CloudDriverException;
import br.ufrn.consiste.model.IPAddress;
import br.ufrn.consiste.model.ResponseAPI;
import br.ufrn.consiste.model.VirtualMachine;

public interface CloudDriver{

	
	 VirtualMachine getVM(String id) throws CloudDriverException;

	 List<VirtualMachine> getAllVM() throws CloudDriverException;

	 ResponseAPI createVM(String imageId) throws CloudDriverException;

	 ResponseAPI deleteVM(String id) throws CloudDriverException;

	 ResponseAPI startVM(String id) throws CloudDriverException;

	 ResponseAPI suspendVM(String id) throws CloudDriverException;

	 ResponseAPI stopVM(String id) throws CloudDriverException;

	 List<IPAddress> getAllIP() throws CloudDriverException;

	 IPAddress createIP() throws CloudDriverException;

	 ResponseAPI associateIP(IPAddress ip) throws CloudDriverException;

	 ResponseAPI deassociateIP(IPAddress ip)
			throws CloudDriverException;

	 ResponseAPI deleteIP(IPAddress ip) throws CloudDriverException;
}
