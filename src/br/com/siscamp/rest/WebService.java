package br.com.siscamp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("servico")
public class WebService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("online")
	public boolean aloMundo() {
		return true;
	}

}
