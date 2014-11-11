package br.ufrn.vmcentre.Controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import br.ufrn.consiste.DriverManager.DriverManager;
import br.ufrn.consiste.exceptions.ControllerException;
import br.ufrn.consiste.exceptions.InvalidValueException;
import br.ufrn.consiste.exceptions.ObjectNullException;
import br.ufrn.consiste.model.ResponseAPI;
import br.ufrn.consiste.model.VirtualMachine;

public class VirtualMachineController/* extends Controller<VirtualMachine, Long>*/ {

	/*private VirtualMachineDaoInterface virtualMachineDao = factory
			.getVirtualMachineDAO();*/
	
	
	
	public VirtualMachine getVM(String plataform, String vmId) throws ControllerException{
		try {
			DriverManager driver = (DriverManager) Naming.lookup("rmi://localhost:5000/CloudDriverManager");
			
			return driver.getVM(plataform, vmId);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new ControllerException(e.getMessage());
		}
		
	}
	
	public VirtualMachine[] getAllVM(String plataform) throws ControllerException{
		try {
			DriverManager driver = (DriverManager) Naming.lookup("rmi://localhost:5000/CloudDriverManager");
			
			List<VirtualMachine> machines = driver.getAllVM(plataform);
			return machines.toArray(new VirtualMachine[machines.size()]);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new ControllerException(e.getMessage());
		}
		
	}
	
	public ResponseAPI createVM(String plataform, String imageId) throws ControllerException{
		try {
			DriverManager driver = (DriverManager) Naming.lookup("rmi://localhost:5000/CloudDriverManager");
			
			return driver.createVM(plataform, imageId);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	public ResponseAPI deleteVM(String plataform, String vmId) throws ControllerException{
		try {
			DriverManager driver = (DriverManager) Naming.lookup("rmi://localhost:5000/CloudDriverManager");
			
			
			return driver.deleteVM(plataform, vmId);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	public ResponseAPI startVM(String plataform, String vmId) throws ControllerException{
		try {
			DriverManager driver = (DriverManager) Naming.lookup("rmi://localhost:5000/CloudDriverManager");
	
			
			return driver.startVM(plataform, vmId);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	public ResponseAPI suspendVM(String plataform, String vmId) throws ControllerException{
		try {
			DriverManager driver = (DriverManager) Naming.lookup("rmi://localhost:5000/CloudDriverManager");
			
			
			return driver.suspendVM(plataform, vmId);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	public ResponseAPI stopVM(String plataform, String vmId) throws ControllerException{
		try {
			DriverManager driver = (DriverManager) Naming.lookup("rmi://localhost:5000/CloudDriverManager");
			
			
			return driver.stopVM(plataform, vmId);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	

	private boolean validate(VirtualMachine vm) throws ObjectNullException,
			InvalidValueException {

		if (vm == null) {
			throw new ObjectNullException("Vm is null");
		}

		if (vm.getImage() == null) {
			throw new InvalidValueException("value of Vm.image is null");
		}

		if (vm.getIps() == null) {
			throw new InvalidValueException("value of Vm.IPs is null");
		}

		if (vm.getKeyname() == null || vm.getKeyname().trim().equals("")) {
			throw new InvalidValueException("value of Vm.KeyName is null");
		}

		if (vm.getName().trim().equals("")) {
			throw new InvalidValueException("value of Vm.Name is null");
		}
		if (vm.getState() == null) {
			throw new InvalidValueException("value of Vm.State is null");
		}		

		if (vm.getVMType() == null) {
			throw new InvalidValueException("value of Vm.VMType is null");
		}
		
		return true;

	}

	/*@Override
	public VirtualMachine save(VirtualMachine entity)
			throws ControllerException {

		try {
			if (validate(entity)) {
				return virtualMachineDao.save(entity);
			}else{
				throw new ControllerException("vm can not be saved");
			}
		} catch (ObjectNullException | InvalidValueException  | DAOException e) {
			throw new ControllerException(e.getMessage());
		} 
	}

	@Override
	public VirtualMachine upadate(VirtualMachine entity)
			throws ControllerException {

		try {
			if (validate(entity) && entity.getId() != null
					&& entity.getId() > -1) {
				return virtualMachineDao.update(entity);
			}else{
				throw new ControllerException("Vm.id is null or invalid");
			}
		} catch (ObjectNullException | InvalidValueException | DAOException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@Override
	public void delete(VirtualMachine entity) throws ControllerException {
		try {
			virtualMachineDao.delete(entity);
		} catch (DAOException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@Override
	public VirtualMachine findById(Long id) throws ControllerException {
		try {
			return virtualMachineDao.findById(VirtualMachine.class, id);
		} catch (DAOException e) {
			throw new ControllerException(e.getMessage());
		}
	}

	@Override
	public List<VirtualMachine> findAll() throws ControllerException {
		try {
			return virtualMachineDao.findAll(VirtualMachine.class);
		} catch (DAOException e) {
			throw new ControllerException(e.getMessage());
		}
	}
*/
}
