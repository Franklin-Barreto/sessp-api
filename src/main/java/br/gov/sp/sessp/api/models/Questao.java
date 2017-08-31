package br.gov.sp.sessp.api.models;

public class Questao {

	private Integer codigo;
	private String descricao;

	public Questao(Integer codigo, String descricao) {

		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Questao() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}