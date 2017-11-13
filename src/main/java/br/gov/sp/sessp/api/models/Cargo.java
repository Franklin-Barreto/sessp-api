package br.gov.sp.sessp.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Cargo {

	@Id
	@JsonProperty(value="_id")
	private Integer codigo;
	
	private String descricao;

	public Cargo() {

	}

	public Cargo(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
