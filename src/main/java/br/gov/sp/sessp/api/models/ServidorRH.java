package br.gov.sp.sessp.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class ServidorRH {

	@Id
	private Integer rsCodigo;
	private String cpf;
	private int pvCodigo;
	private int exCodigo;
	private String nome;
	private List<UnidadeOrcamentaria> uos;

	public Integer getRsCodigo() {
		return rsCodigo;
	}

	public String getCpf() {
		return cpf;
	}

	public int getPvCodigo() {
		return pvCodigo;
	}

	public int getExCodigo() {
		return exCodigo;
	}

	public String getNome() {
		return nome;
	}

	public List<UnidadeOrcamentaria> getUos() {
		return uos;
	}

	public void addUnidadeOrcamentaria(UnidadeOrcamentaria uo) {
		this.uos.add(uo);
	}

}
