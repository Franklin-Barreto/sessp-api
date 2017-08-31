package br.gov.sp.sessp.api.models;

public class Questao {

	private Integer id;
	private String description;

	public Questao(Integer id, String description) {

		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return description;
	}

}