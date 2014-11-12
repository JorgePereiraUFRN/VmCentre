package br.ufrn.consiste.VmCentre.Resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ufrn.consiste.exceptions.NotificationsManagerException;
import br.ufrn.consiste.model.InformationsVM;
import br.ufrn.consiste.model.ResponseAPI;
import br.ufrn.vmcentre.Controller.NotificationsManager;

@Path("Monitoring")
public class MonitoringVMResouce {
	
	
	private static NotificationsManager notificationsManager = new NotificationsManager();

	public MonitoringVMResouce() {
		// TODO Auto-generated constructor stub
	}
	
	@PUT
	@Path("monitoreVM")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseAPI monitoreVM(InformationsVM informationsVM){
		
		ResponseAPI response = new ResponseAPI();
		try {
			notificationsManager.monitoreVM(informationsVM);
			
			response.setStatusCode(0);
			response.setMessage("Monitoramento iniciado.");
			
		} catch (NotificationsManagerException e) {
			response.setStatusCode(-1);
			response.setMessage("Erroao monitorar VM. "+e.getMessage());
		}
		
		return response;
		
	}

}
