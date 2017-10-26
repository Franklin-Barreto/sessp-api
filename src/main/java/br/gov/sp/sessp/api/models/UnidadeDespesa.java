package br.gov.sp.sessp.api.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class UnidadeDespesa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer udCodigo;
	private String udDescricao;
	private List<UnidadeAdministrativa> unidadesAdministrativas;

	public UnidadeDespesa(Integer udCodigo, String udDescricao, List<UnidadeAdministrativa> unidadesAdministrativas) {

		this.udCodigo = udCodigo;
		this.udDescricao = udDescricao;
		this.unidadesAdministrativas = unidadesAdministrativas;
	}

	public UnidadeDespesa() {

	}

	public Integer getUdCodigo() {
		return udCodigo;
	}

	public String getUdDescricao() {
		return udDescricao;
	}

	public List<UnidadeAdministrativa> getUnidadesAdministrativas() {
		return unidadesAdministrativas;
	}

	public void adicionarUnidadesAdministrativas(UnidadeAdministrativa ua) {
		this.unidadesAdministrativas.add(ua);
	}

	public void setUnidadesAdministrativas(List<UnidadeAdministrativa> uas) {
		this.unidadesAdministrativas = uas;
	}
}
