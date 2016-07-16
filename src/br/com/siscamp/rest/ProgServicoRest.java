package br.com.siscamp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.siscamp.dao.ProgServicoDAO;
import br.com.siscamp.util.Util;

@Path("progservico")
public class ProgServicoRest {
	private ProgServicoDAO progs = new ProgServicoDAO();

	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProdutos() {
		return Util.converterProgServicoJSONUTF8(progs.listarProgServico()).toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("teste")
	public String aloMundo() {
		return "Estamos Online";
	}

}
