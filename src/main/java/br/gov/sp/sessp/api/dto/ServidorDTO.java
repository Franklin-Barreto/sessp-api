package br.gov.sp.sessp.api.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.gov.sp.sessp.api.models.InfoServidor;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServidorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonProperty(value="_id")
	private Integer rsCodigo;
	private String nome;
	private String cpf;
	private InfoServidor infoServidor;
	
	
	

	public ServidorDTO(Integer rsCodigo, String nome, String cpf, InfoServidor infoServidor) {
		this.rsCodigo = rsCodigo;
		this.nome = nome;
		this.cpf = cpf;
		this.infoServidor = infoServidor;
	}
	
	public ServidorDTO(){}

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
