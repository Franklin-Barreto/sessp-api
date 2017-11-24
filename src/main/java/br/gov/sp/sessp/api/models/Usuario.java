package br.gov.sp.sessp.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Usuario {

	@Id
	@JsonProperty("cpf")
	private String cpf;
	private String senha;
	private List<Permissao> permissoes;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void addPermissao(Permissao permissao) {
		this.permissoes.add(permissao);
	}

}
