package br.gov.sp.sessp.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UnidadeOrcamentaria {

	@Id
	private Integer codigoUo;
	private String descricao;
	private List<UnidadeDespesa> unidadesDespesa;
	private UnidadeDespesa unidadeDespesa;

	public UnidadeOrcamentaria(Integer codigoUo, String descricao, List<UnidadeDespesa> unidadesDespesa) {
		this.codigoUo = codigoUo;
		this.descricao = descricao;
		this.unidadesDespesa = unidadesDespesa;
	}

	public UnidadeOrcamentaria() {

	}

	public Integer getCodigoUo() {
		return codigoUo;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<UnidadeDespesa> getUnidadesDespesa() {
		return unidadesDespesa;
	}

	public void adicionarUnidadeDespesa(UnidadeDespesa ud) {
		unidadesDespesa.add(ud);
	}

	public void setUnidadesDespesa(List<UnidadeDespesa> uds) {
		this.unidadesDespesa = uds;
	}

	public UnidadeDespesa getUnidadeDespesa() {
		return unidadeDespesa;
	}

	public void setUnidadeDespesa(UnidadeDespesa unidadeDespesa) {
		this.unidadeDespesa = unidadeDespesa;
	}

}
