package br.com.siscamp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.siscamp.dao.PleDAO;
import br.com.siscamp.util.Util;

@Path("ple")
public class PleRest {
	private PleDAO ple = new PleDAO();

	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProdutos() {
		return Util.converterPleJSONUTF8(ple.listarPle()).toString();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("teste")
	public String aloMundo() {
		return "Estamos Online";
	}

}
