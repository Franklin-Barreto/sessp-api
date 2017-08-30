package br.gov.sp.sessp.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.sessp.api.models.UnidadeAdministrativa;
import br.gov.sp.sessp.api.models.UnidadeDespesa;
import br.gov.sp.sessp.api.models.UnidadeOrcamentaria;
import br.gov.sp.sessp.api.repository.unidades.UnidadesRepository;

@Service
public class UnidadesService {
	@Autowired
	private UnidadesRepository unidades;

	public UnidadeOrcamentaria save(UnidadeOrcamentaria uo) {
		return unidades.save(uo);
	}

	public List<UnidadeOrcamentaria> getUos() {

		return unidades.findAll();
	}

	public void deletarUos() {
		unidades.deleteAll();
	}

	public void adicionarUd(UnidadeOrcamentaria uo) {
		unidades.save(uo);
	}

	public UnidadeOrcamentaria getUoById(Integer id) {

		return unidades.findOne(id);
	}

	public List<UnidadeDespesa> getUdsByUo(Integer id) {

		List<UnidadeDespesa> uds = unidades.findOne(id).getUnidadesDespesa();
		return uds;
	}

	public UnidadeOrcamentaria getUdById(Integer uo, Integer ud) {
		// return unidades.findByCodigoUoAndUnidadesDespesaUdCodigo(uo, ud);
		return null;
	}

	public UnidadeAdministrativa uas(Integer uo, Integer ud, Integer ua) {
		//System.out.println("TESTE");
		
		return unidades.findUnidadeAdministrativa(uo, ud, ua);
	}

	public UnidadeDespesa ud(Integer uoCodigo, Integer udCodigo) {
		
		return unidades.findUnidadeDespesa(uoCodigo, udCodigo);

	}

}
