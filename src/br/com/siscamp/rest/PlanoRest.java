package br.com.siscamp.rest;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.siscamp.dao.PlanoDAO;
import br.com.siscamp.dto.Plano;
import br.com.siscamp.util.Util;

@Path("/pdf")
public class PlanoRest {
	PlanoDAO dao = new PlanoDAO();

	@GET
	@Path("/get")
	@Produces("application/pdf")
	public Response getFile(@QueryParam("linha") int idLinha) {

		Plano arq = new Plano();
		arq = dao.getNomeArquivo(idLinha);
		if (arq.getCaminho() != null) {
			File file = new File(arq.getCaminho());

			ResponseBuilder response = Response.ok((Object) file);
			response.header("Content-Disposition", "attachment; filename=linha" + idLinha + ".pdf");
			return response.build();

		} else {
			ResponseBuilder response = Response.ok();
			response.header("Não Há Arquivo", null);
			return response.build();
		}

	}

	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProdutos(@QueryParam("linha") String str) {
		return Util.converterPlanoJSONUTF8(dao.listarPlanos()).toString();

	}

}
