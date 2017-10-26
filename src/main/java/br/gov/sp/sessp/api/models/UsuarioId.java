package br.gov.sp.sessp.api.models;

import java.io.Serializable;

public class UsuarioId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer rsCodigo;
	private int pvCodigo;
	private int exCodigo;
	private Integer uaCodigo;

	public UsuarioId() {
	}

	public Integer getRsCodigo() {
		return rsCodigo;
	}

	public int getPvCodigo() {
		return pvCodigo;
	}

	public int getExCodigo() {
		return exCodigo;
	}

	public Integer getUaCodigo() {
		return uaCodigo;
	}

}
