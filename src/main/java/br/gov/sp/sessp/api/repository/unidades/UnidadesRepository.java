package br.gov.sp.sessp.api.repository.unidades;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.sessp.api.models.UnidadeOrcamentaria;

@Repository
public interface UnidadesRepository extends MongoRepository<UnidadeOrcamentaria, Integer>, UnidadesRepositoryCustom {

	public UnidadeOrcamentaria findByDescricao(String descricao);
	
	public UnidadeOrcamentaria findOneBycodigoUoAndUnidadesDespesaUdCodigo(Integer udCodigo);

}
