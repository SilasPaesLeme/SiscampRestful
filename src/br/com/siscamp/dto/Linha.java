package br.com.siscamp.dto;

public class Linha {

	private int idLinha;
	private String nomenclatura;
	private String caboRaio;
	private String caboCond;
	private int largFaixa;

	public int getLargFaixa() {
		return largFaixa;
	}

	public void setLargFaixa(int largFaixa) {
		this.largFaixa = largFaixa;
	}

	public String getCaboRaio() {
		return caboRaio;
	}

	public void setCaboRaio(String caboRaio) {
		this.caboRaio = caboRaio;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public int getId() {
		return idLinha;
	}

	public void setId(int id) {
		this.idLinha = id;
	}

	public String getCaboCond() {
		return caboCond;
	}

	public void setCaboCond(String caboCond) {
		this.caboCond = caboCond;
	}

}
