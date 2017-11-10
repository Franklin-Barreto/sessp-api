package br.gov.sp.sessp.api.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import br.gov.sp.sessp.api.models.InfoServidor;

public class ServidorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer rsCodigo;
	private String nome;
	private String cpf;
	private InfoServidor infoServidor;

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

	public InfoServidor getInfoServidor() {
		return infoServidor;
	}

	public void setInfoServidor(InfoServidor info) {
		this.infoServidor = info;
	}

	@Override
	public String toString() {

		return "rsCodigo:" + this.rsCodigo + ",nome:" + this.nome + ",cpf:" + this.cpf + ", infoServidor"
				+ this.infoServidor;
	}
}
