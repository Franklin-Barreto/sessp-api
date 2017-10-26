package br.gov.sp.sessp.api.models;

import org.springframework.data.annotation.Id;

public class Avaliado {

	@Id private UsuarioId usuarioId;
	private String nome;
	
	public UsuarioId getUsuarioId() {
		return usuarioId;
	}
	
	public String getNome() {
		return nome;
	}
}
