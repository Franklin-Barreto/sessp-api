package br.gov.sp.sessp.api.models;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "formulario")
public class Formulario {

	private Integer id;
	private String descricao;
	private List<Fator> fatores;

	public Formulario(Integer id, String descricao, List<Fator> fatores) {
		this.id = id;
		this.descricao = descricao;
		this.fatores = fatores;

	}

	public Formulario() {
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Fator> getFatores() {
		return fatores;
	}

	public void addFator(Fator factor) {
		this.fatores.add(factor);
	}
	
	public void removeFator(Fator factor){
		this.fatores.remove(factor);
	}

}