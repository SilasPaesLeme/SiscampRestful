package br.com.siscamp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.siscamp.dao.MovFunProgDAO;
import br.com.siscamp.util.Util;

@Path("movfunprog")
public class MovFunProgRest {
	private MovFunProgDAO movfunprog = new MovFunProgDAO();

	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProdutos() {
		return Util.converterMovFunProgJSONUTF8(movfunprog.listarMovFunProg()).toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("teste")
	public String aloMundo() {
		return "Estamos Online";
	}

}
