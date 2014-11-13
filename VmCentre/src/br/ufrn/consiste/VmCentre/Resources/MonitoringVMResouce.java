package br.ufrn.consiste.VmCentre.Resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Response;

import br.ufrn.consiste.exceptions.NotificationsManagerException;
import br.ufrn.consiste.model.InformationsVM;
import br.ufrn.consiste.model.ResourcesUsage;
import br.ufrn.consiste.model.ResponseAPI;
import br.ufrn.consiste.model.Thresholds;
import br.ufrn.vmcentre.Controller.NotificationsManager;

@Path("Monitoring")
public class MonitoringVMResouce {

	private static NotificationsManager notificationsManager = new NotificationsManager();

	public MonitoringVMResouce() {
	}

	@PUT
	@Path("monitoreVM")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseAPI monitoreVM(InformationsVM informationsVM) {

		ResponseAPI response = new ResponseAPI();
		try {
			notificationsManager.monitoreVM(informationsVM);

			response.setStatusCode(0);
			response.setMessage("Monitoramento iniciado.");

		} catch (NotificationsManagerException e) {
			response.setStatusCode(-1);
			response.setMessage("Erroao monitorar VM. " + e.getMessage());
		}

		return response;

	}

	@POST
	@Path("cancelMonitoringVM/{ipVM}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseAPI cancelMonitoringVm(@PathParam("ipVM") String ip) {

		ResponseAPI response = new ResponseAPI();

		try {
			notificationsManager.cancelMonitoringVM(ip);

			response.setStatusCode(0);
			response.setMessage("Monitoramento cancelado");

		} catch (NotificationsManagerException e) {
			response.setStatusCode(-1);
			response.setMessage("Erro ao cancelar monitoramento. "
					+ e.getMessage());
		}

		return response;
	}

	@POST
	@Path("updateThresholds/{ipVM}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseAPI updateThresholds(@PathParam("ipVM") String ip,
			Thresholds thresholds) {
		ResponseAPI response = new ResponseAPI();

		try {
			notificationsManager.updatThresholds(ip, thresholds);

			response.setStatusCode(0);
			response.setMessage("Limiares atualizados");

		} catch (NotificationsManagerException e) {
			response.setStatusCode(-1);
			response.setMessage("Erro ao atualizar limiares. " + e.getMessage());
		}

		return response;
	}

	@GET
	@Path("averageResourcesUsage/{ipVM}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResourcesUsage getAverageResourcesUsage(
			@PathParam("ipVM") String ip, @QueryParam("lastHours") int lastHours) {
		ResourcesUsage reUsage = null;

		try {
			reUsage = notificationsManager.getAverageResourcesUsage(ip,
					lastHours);
			return reUsage;
		} catch (NotificationsManagerException e) {
			e.printStackTrace();
			return null;
		}

	}
}
