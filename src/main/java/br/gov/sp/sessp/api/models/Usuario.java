package br.gov.sp.sessp.api.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Document
public class Usuario {

	@Id
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

	public Collection<? extends GrantedAuthority> getPermissoes() {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		permissoes.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase()))

		);
		return authorities;

	}

	public void addPermissao(Permissao permissao) {
		this.permissoes.add(permissao);
	}

}
