package br.gov.sp.sessp.api.repository.unidades;

import br.gov.sp.sessp.api.models.UnidadeAdministrativa;
import br.gov.sp.sessp.api.models.UnidadeDespesa;

public interface UnidadesRepositoryCustom {

	public UnidadeDespesa findUnidadeDespesa(Integer uoCodigo, Integer udCodigo);

	public UnidadeAdministrativa findUnidadeAdministrativa(Integer uoCodigo, Integer udCodigo, Integer ua);
}
