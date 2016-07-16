package br.com.siscamp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.siscamp.dao.MovEstLinhaDAO;
import br.com.siscamp.util.Util;

@Path("movestlinha")
public class MovEstLinhaRest {
	private MovEstLinhaDAO mov = new MovEstLinhaDAO();

	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProdutos() {
		return Util.converterMovEstLinhaJSONUTF8(mov.listarMovEstLinha()).toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("teste")
	public String aloMundo() {
		return "Estamos Online";
	}

}
