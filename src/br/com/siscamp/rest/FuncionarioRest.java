package br.com.siscamp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.siscamp.dao.FuncionarioDAO;
import br.com.siscamp.dto.Funcionario;
import br.com.siscamp.util.Util;

@Path("funcionarios")
public class FuncionarioRest {
	
	private FuncionarioDAO funcionario = new FuncionarioDAO();

	@Path("listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getProdutos() {
		return Util.converterFuncionarioJSONUTF8(funcionario.listarFuncionarios()).toString();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("teste")
	public String aloMundo() {
		return "Estamos Online";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("logar")
	public String logar(@QueryParam("usuario") String user, @QueryParam("senha") String pass) {
		Funcionario usuario = FuncionarioDAO.validarLogin(user, pass);
		
		String res = "";
		if (usuario != null) {
			res = new Gson().toJson(usuario);
		}
		
		return res;
	}

}
