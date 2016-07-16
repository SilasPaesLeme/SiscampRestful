package br.com.siscamp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.siscamp.dao.SobreavisoDAO;
import br.com.siscamp.util.Util;

@Path("sobreaviso")
public class SobreavisoRest {
	private SobreavisoDAO sobreaviso = new SobreavisoDAO();

	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProdutos() {
		return Util.converterSobreavisoJSONUTF8(sobreaviso.listarSobreaviso()).toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("teste")
	public String aloMundo() {
		return "Estamos Online";
	}

}
