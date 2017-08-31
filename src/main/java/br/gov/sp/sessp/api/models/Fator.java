package br.gov.sp.sessp.api.models;

import java.util.List;

public class Fator {

	private Integer id;
	private String titulo;
	private String descricao;
	private List<Questao> questoes;
	
	
	

	public Fator(Integer id, String titulo, String descricao, List<Questao> questoes) {
	
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.questoes = questoes;
	}
	
	public Fator(){}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void add(Questao questao) {
		questoes.add(questao);
	}

	public List<Questao> getQuestoes() {
		return this.questoes;
	}

}