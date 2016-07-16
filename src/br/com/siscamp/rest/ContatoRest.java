package br.com.siscamp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.siscamp.dao.ContatoDAO;
import br.com.siscamp.util.Util;

@Path("contatos")
public class ContatoRest {
	private ContatoDAO contato = new ContatoDAO();

	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getContato(@QueryParam("str") String str) {
		return Util.converterContatoJSONUTF8(contato.listarContatos()).toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("teste")
	public String aloMundo() {
		return "Estamos Online";
	}

}
