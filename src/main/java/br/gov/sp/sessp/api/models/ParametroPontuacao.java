package br.gov.sp.sessp.api.models;

public class ParametroPontuacao {

	private int valor;
	private String titulo;
	private String descricao;

	public ParametroPontuacao(int valor, String titulo, String descricao) {
		this.valor = valor;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public ParametroPontuacao() {
	}

	public int getValor() {
		return valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

}
