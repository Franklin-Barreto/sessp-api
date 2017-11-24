package br.gov.sp.sessp.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Avaliador {

	@Id
	private ServidorId usuarioId;
	private String nome;
	private List<Avaliado> avaliados;

	public ServidorId getUsuarioId() {
		return usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public void adicionarAvaliado(Avaliado avaliado) {
		this.avaliados.add(avaliado);
	}

	public List<Avaliado> getAvaliados() {
		return avaliados;
	}

}
