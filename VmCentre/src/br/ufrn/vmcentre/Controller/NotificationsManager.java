package br.ufrn.vmcentre.Controller;

import br.ufrn.consiste.CloudMonitor.CloudMonitorFacade;
import br.ufrn.consiste.exceptions.CloudMonitorException;
import br.ufrn.consiste.exceptions.NotificationsManagerException;
import br.ufrn.consiste.model.InformationsVM;

public class NotificationsManager{
	
	private CloudMonitorFacade cloudMonitorFacade = CloudMonitorFacade.getInstance();

	public NotificationsManager() {
		
	}
	

	public void monitoreVM(InformationsVM informationsVM) throws NotificationsManagerException{
		try {
			cloudMonitorFacade.monitoreVM(informationsVM);
			
		} catch (CloudMonitorException e) {
			throw new NotificationsManagerException(e.getMessage());
		}
	}
	
	
	

}
