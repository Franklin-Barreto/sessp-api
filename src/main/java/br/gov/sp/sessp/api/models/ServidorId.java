package br.gov.sp.sessp.api.models;

import java.io.Serializable;

public class ServidorId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer rsCodigo;
	private int pvCodigo;
	private int exCodigo;
	private UnidadeServidor unidade;

	public ServidorId() {
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

	public UnidadeServidor getUnidade() {
		return unidade;
	}

}
