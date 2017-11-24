package br.gov.sp.sessp.api.models;

import org.springframework.data.annotation.Id;

public class Avaliado {

	@Id private ServidorId usuarioId;
	private String nome;
	
	public ServidorId getUsuarioId() {
		return usuarioId;
	}
	
	public String getNome() {
		return nome;
	}
}
