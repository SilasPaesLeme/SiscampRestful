package br.com.siscamp.dto;

public class Plano {

	private String Caminho;
	private String Arquivo;
	private int idLinha;
	private int versao;

	public String getCaminho() {
		return Caminho;
	}

	public void setCaminho(String caminho) {
		Caminho = caminho;
	}

	public String getArquivo() {
		return Arquivo;
	}

	public void setArquivo(String arquivo) {
		Arquivo = arquivo;
	}

	public int getIdLinha() {
		return idLinha;
	}

	public void setIdLinha(int idLinha) {
		this.idLinha = idLinha;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

}
