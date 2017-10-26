package br.gov.sp.sessp.api.models;

import java.io.Serializable;

public class UnidadeServidor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uoCodigo;
	private String uoDescricao;
	private Integer udCodigo;
	private String udDescricao;
	private Integer uaCodigo;
	private String uaDescricao;

	public UnidadeServidor() {
	}

	public UnidadeServidor(Integer uoCodigo, String uoDescricao, Integer udCodigo, String udDescricao, Integer uaCodigo,
			String uaDescricao) {

		this.uoCodigo = uoCodigo;
		this.uoDescricao = uoDescricao;
		this.udCodigo = udCodigo;
		this.udDescricao = udDescricao;
		this.uaCodigo = uaCodigo;
		this.uaDescricao = uaDescricao;
	}

	public Integer getUoCodigo() {
		return uoCodigo;
	}

	public void setUoCodigo(Integer uoCodigo) {
		this.uoCodigo = uoCodigo;
	}

	public String getUoDescricao() {
		return uoDescricao;
	}

	public void setUoDescricao(String uoDescricao) {
		this.uoDescricao = uoDescricao;
	}

	public Integer getUdCodigo() {
		return udCodigo;
	}

	public String getUdDescricao() {
		return udDescricao;
	}

	public Integer getUaCodigo() {
		return uaCodigo;
	}

	public String getUaDescricao() {
		return uaDescricao;
	}

}
