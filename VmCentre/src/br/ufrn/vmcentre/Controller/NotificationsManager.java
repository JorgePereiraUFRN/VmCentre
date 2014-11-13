package br.ufrn.vmcentre.Controller;

import br.ufrn.consiste.CloudMonitor.CloudMonitorFacade;
import br.ufrn.consiste.exceptions.CloudMonitorException;
import br.ufrn.consiste.exceptions.NotificationsManagerException;
import br.ufrn.consiste.model.InformationsVM;
import br.ufrn.consiste.model.ResourcesUsage;
import br.ufrn.consiste.model.ResponseAPI;
import br.ufrn.consiste.model.Thresholds;

public class NotificationsManager {

	private CloudMonitorFacade cloudMonitorFacade = CloudMonitorFacade
			.getInstance();

	public NotificationsManager() {

	}

	public void monitoreVM(InformationsVM informationsVM)
			throws NotificationsManagerException {
		try {
			cloudMonitorFacade.monitoreVM(informationsVM);

		} catch (CloudMonitorException e) {
			throw new NotificationsManagerException(e.getMessage());
		}
	}

	public void cancelMonitoringVM(String ipVM)
			throws NotificationsManagerException {
		try {
			cloudMonitorFacade.cancelMonitoringVM(ipVM);

		} catch (CloudMonitorException e) {
			throw new NotificationsManagerException(e.getMessage());
		}
	}

	public void updatThresholds(String ipVM, Thresholds thresholds) throws NotificationsManagerException {
		try {
			cloudMonitorFacade.updatThresholds(ipVM, thresholds);

		} catch (CloudMonitorException e) {
			throw new NotificationsManagerException(e.getMessage());
		}
	}
	
	
	public ResourcesUsage getAverageResourcesUsage(String ipVm, int lastHours) throws NotificationsManagerException{
		try {
			
			return cloudMonitorFacade.getAverageResourcesUsage(ipVm, lastHours);

		} catch (CloudMonitorException e) {
			throw new NotificationsManagerException(e.getMessage());
		}
	}
	

}
