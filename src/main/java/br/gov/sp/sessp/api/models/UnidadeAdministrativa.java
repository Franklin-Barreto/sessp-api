package br.gov.sp.sessp.api.models;

import org.springframework.data.annotation.Id;

public class UnidadeAdministrativa {

	@Id
	private Integer uaCodigo;
	private String uaDescricao;

	public UnidadeAdministrativa(Integer uaCodigo, String uaDescricao) {
		this.uaCodigo = uaCodigo;
		this.uaDescricao = uaDescricao;
	}

	public UnidadeAdministrativa() {
	}

	public Integer getUaCodigo() {
		return uaCodigo;
	}
	
	public void setUaCodigo(Integer uaCodigo) {
		this.uaCodigo = uaCodigo;
	}

	public String getUaDescricao() {
		return uaDescricao;
	}
	
	public void setUaDescricao(String uaDescricao) {
		this.uaDescricao = uaDescricao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ua Codigo"+this.uaCodigo+ "Descrição"+ this.uaDescricao;
	}

}
