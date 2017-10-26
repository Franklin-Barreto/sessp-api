package br.gov.sp.sessp.api.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Servidor {

	@Id
	private Integer rsCodigo;
	private String nome;
	private String cpf;
	private List<InfoServidor> infoServidor = new ArrayList<>();

	public Integer getRsCodigo() {
		return rsCodigo;
	}

	public void setRsCodigo(Integer rsCodigo) {
		this.rsCodigo = rsCodigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<InfoServidor> getInfoServidor() {
		return infoServidor;
	}
	
	public void setInfoServidor(List<InfoServidor> infoServidor) {
		this.infoServidor = infoServidor;
	}

	public void setInfo(InfoServidor info) {
		this.infoServidor.add(info);
	}

	@Override
	public String toString() {

		return "rsCodigo:" + this.rsCodigo + ",nome:" + this.nome + ",cpf:" + this.cpf + ", infoServidor"
				+ this.infoServidor;
	}

}
