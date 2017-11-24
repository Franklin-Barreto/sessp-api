package br.gov.sp.sessp.api.repository.unidades;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;

import com.mongodb.DBObject;

import br.gov.sp.sessp.api.models.UnidadeAdministrativa;
import br.gov.sp.sessp.api.models.UnidadeDespesa;
import br.gov.sp.sessp.api.models.UnidadeOrcamentaria;

public class UnidadesRepositoryImpl implements UnidadesRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	public UnidadeDespesa findUnidadeDespesa(Integer uoCodigo, Integer udCodigo) {

		Criteria findUo = Criteria.where("_id").is(uoCodigo);
		Criteria findUd = Criteria.where("unidadesDespesa").elemMatch(Criteria.where("_id").is(udCodigo));
		BasicQuery query = new BasicQuery(findUo.getCriteriaObject(), findUd.getCriteriaObject());
		UnidadeOrcamentaria uo = mongoTemplate.findOne(query, UnidadeOrcamentaria.class);
		return new UnidadeDespesa(uo.getUnidadesDespesa().get(0).getUdCodigo(),
				uo.getUnidadesDespesa().get(0).getUdDescricao(),
				uo.getUnidadesDespesa().get(0).getUnidadesAdministrativas());

	}

	public UnidadeAdministrativa findUnidadeAdministrativa(Integer uoCodigo, Integer udCodigo, Integer uaCodigo) {

		Aggregation agg = newAggregation(unwind("unidadesDespesa"), unwind("unidadesDespesa.unidadesAdministrativas"),
				match(Criteria.where("unidadesDespesa._id").is(udCodigo)
						.and("unidadesDespesa.unidadesAdministrativas._id").is(uaCodigo)),
				project("unidadesDespesa.unidadesAdministrativas").andExclude("_id"));

		DBObject db = (DBObject) mongoTemplate.aggregate(agg, UnidadeOrcamentaria.class, DBObject.class)
				.getUniqueMappedResult().get("unidadesAdministrativas");
		return new UnidadeAdministrativa((Integer) db.get("_id"), (String) db.get("uaDescricao"));

	}

	public List<UnidadeAdministrativa> listarUas() {

		Aggregation agg = newAggregation(unwind("unidadesDespesa"), unwind("unidadesDespesa.unidadesAdministrativas"),
				project().andExclude("_id").andInclude("unidadesDespesa.unidadesAdministrativas"));
		List<UnidadeAdministrativa> unidades = new ArrayList<>();
		List<DBObject> dbs = mongoTemplate.aggregate(agg, UnidadeOrcamentaria.class, DBObject.class).getMappedResults();
		for (DBObject db : dbs) {
			DBObject ua = (DBObject) db.get("unidadesAdministrativas");
			unidades.add(new UnidadeAdministrativa((Integer) ua.get("_id"), (String) ua.get("uaDescricao")));
		}

		return unidades;
	}

}
