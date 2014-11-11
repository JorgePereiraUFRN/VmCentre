package br.ufrn.consiste.VmCentre.Resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.ufrn.consiste.exceptions.ControllerException;
import br.ufrn.consiste.model.ResponseAPI;
import br.ufrn.consiste.model.VirtualMachine;
import br.ufrn.vmcentre.Controller.VirtualMachineController;

@Path("VirtualMachines")
public class VmResources {

	private VirtualMachineController controller = new VirtualMachineController();

	public VmResources() {

	}

	@GET
	@Path("/{plataform}/getVm/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public VirtualMachine getVM(@PathParam("plataform") String plataform,
			@PathParam("id") String id) {

		System.out.println("*");
		try {
			return controller.getVM(plataform, id);
		} catch (ControllerException e) {
			System.out.println("não encontroe a maquina "+e.getMessage());
			return null;
		}
	}

	@GET
	@Path("/{plataform}/getAllVm")
	@Produces(MediaType.APPLICATION_JSON)
	public VirtualMachine[] getAllVM(
			@PathParam("plataform") String plataform) {

		try {
			return controller.getAllVM(plataform);
		} catch (ControllerException e) {
			return null;
		}

	}

	@PUT
	@Path("{plataform}/creatVM/{imageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseAPI createVM(@PathParam("plataform") String plataform,
			@PathParam("imageId") String imageId) {

		try {
			return controller.createVM(plataform, imageId);
		} catch (ControllerException e) {
			ResponseAPI resp = new ResponseAPI();
			resp.setStatusCode(-1);
			resp.setMessage(e.getMessage());

			return resp;
		}

	}

	@DELETE
	@Path("/{plataform}/deleteVM/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseAPI deleteVM(@PathParam("plataform") String plataform,
			@PathParam("id") String id) {

		try {
			return controller.deleteVM(plataform, id);
		} catch (ControllerException e) {
			ResponseAPI resp = new ResponseAPI();
			resp.setStatusCode(-1);
			resp.setMessage(e.getMessage());

			return resp;
		}

	}

	@POST
	@Path("/{plataform}/startVM/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseAPI startVM(@PathParam("plataform") String plataform,
			@PathParam("id") String id) {

		try {
			return controller.startVM(plataform, id);
		} catch (ControllerException e) {
			ResponseAPI resp = new ResponseAPI();
			resp.setStatusCode(-1);
			resp.setMessage(e.getMessage());

			return resp;
		}

	}

	@POST
	@Path("/{plataform}/suspendVM/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseAPI suspendVM(@PathParam("plataform") String plataform,
			@PathParam("id") String id) {

		try {
			return controller.suspendVM(plataform, id);
		} catch (ControllerException e) {
			ResponseAPI resp = new ResponseAPI();
			resp.setStatusCode(-1);
			resp.setMessage(e.getMessage());

			return resp;
		}

	}

	@POST
	@Path("/{plataform}/stopVM/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseAPI stopVM(@PathParam("plataform") String plataform,
			@PathParam("id") String id) {
		try {
			return controller.stopVM(plataform, id);
		} catch (ControllerException e) {
			ResponseAPI resp = new ResponseAPI();
			resp.setStatusCode(-1);
			resp.setMessage(e.getMessage());

			return resp;
		}

	}

}
