package br.gov.sp.sessp.api.models;

import java.io.Serializable;

public class InfoServidor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pvCodigo;
	private int exCodigo;
	private UnidadeServidor unidade;
	private Cargo cargo;
	private String status;

	public int getPvCodigo() {
		return pvCodigo;
	}

	public void setPvCodigo(int pvCodigo) {
		this.pvCodigo = pvCodigo;
	}

	public int getExCodigo() {
		return exCodigo;
	}

	public void setExCodigo(int exCodigo) {
		this.exCodigo = exCodigo;
	}

	public UnidadeServidor getUnidade() {
		return unidade;
	}
	
	public void setUnidade(UnidadeServidor unidadeOrcamentaria) {
		this.unidade = unidadeOrcamentaria;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public String getStatus() {
		return status;
	}
	
	@Override
	public String toString() {

		return "pvCodigo:" + this.pvCodigo + ",exCodigo:" + this.exCodigo + ",uo:" + this.unidade;
	}

}
