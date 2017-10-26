package br.gov.sp.sessp.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document
public class Cargo {

	@Id
	private Integer codigo;
	@Getter
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
