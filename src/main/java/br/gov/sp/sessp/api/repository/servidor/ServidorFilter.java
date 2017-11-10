package br.gov.sp.sessp.api.repository.servidor;

public class ServidorFilter {

	private Integer rsCodigo;
	private String nome;
	private Integer uaCodigo;
	private String cpf;

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

	public Integer getUaCodigo() {
		return uaCodigo;
	}

	public void setUaCodigo(Integer uaCodigo) {
		this.uaCodigo = uaCodigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
