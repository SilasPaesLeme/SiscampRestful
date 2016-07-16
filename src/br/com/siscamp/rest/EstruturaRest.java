package br.com.siscamp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.siscamp.dao.EstruturaDAO;
import br.com.siscamp.util.Util;

@Path("estruturas")
public class EstruturaRest {
	private EstruturaDAO estBO = new EstruturaDAO();

	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProdutos(@QueryParam("str") String str) {
		return Util.converterEstruturaJSONUTF8(estBO.listarEstruturas(str)).toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("teste")
	public String aloMundo() {
		return "Estamos Online";
	}

}
