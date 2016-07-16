package br.com.siscamp.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.google.gson.Gson;

import br.com.siscamp.dto.Contato;
import br.com.siscamp.dto.Estrutura;
import br.com.siscamp.dto.Funcionario;
import br.com.siscamp.dto.Linha;
import br.com.siscamp.dto.MovEstLinha;
import br.com.siscamp.dto.MovFunProg;
import br.com.siscamp.dto.Plano;
import br.com.siscamp.dto.Ple;
import br.com.siscamp.dto.ProgServico;
import br.com.siscamp.dto.Sobreaviso;
import br.com.siscamp.dto.Vao;

public class Util {

	public static StringBuilder converterContatoJSONUTF8(List<Contato> contato) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(gson.toJson(contato).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterEstruturaJSONUTF8(List<Estrutura> estrutura) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(gson.toJson(estrutura).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterFuncionarioJSONUTF8(List<Funcionario> funcionario) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(
					gson.toJson(funcionario).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterLinhaJSONUTF8(List<Linha> linha) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(gson.toJson(linha).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterMovEstLinhaJSONUTF8(List<MovEstLinha> movestlinha) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(
					gson.toJson(movestlinha).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterMovFunProgJSONUTF8(List<MovFunProg> movfunprog) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(
					gson.toJson(movfunprog).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterPleJSONUTF8(List<Ple> ple) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(gson.toJson(ple).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterProgServicoJSONUTF8(List<ProgServico> progs) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(gson.toJson(progs).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterSobreavisoJSONUTF8(List<Sobreaviso> sobreaviso) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(
					gson.toJson(sobreaviso).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterVaoJSONUTF8(List<Vao> vao) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(gson.toJson(vao).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

	public static StringBuilder converterPlanoJSONUTF8(List<Plano> plano) {
		Gson gson = new Gson();
		StringBuilder produtosJson = new StringBuilder();
		String string;
		try {
			InputStream inputStream = new ByteArrayInputStream(gson.toJson(plano).getBytes(StandardCharsets.UTF_8));
			if (inputStream != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				while (null != (string = reader.readLine())) {
					produtosJson.append(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtosJson;
	}

}
