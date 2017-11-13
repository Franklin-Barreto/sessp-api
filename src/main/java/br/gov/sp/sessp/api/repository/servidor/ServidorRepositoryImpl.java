package br.gov.sp.sessp.api.repository.servidor;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.facet;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.skip;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import br.gov.sp.sessp.api.dto.ServidorDTO;

public class ServidorRepositoryImpl implements ServidorRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Page<ServidorDTO> filtrar(ServidorFilter filter, Pageable pageable) {

		List<AggregationOperation> aggs = new ArrayList<>();

		aggs.add(unwind("infoServidor"));

		if (!StringUtils.isEmpty(filter.getNome())) {
			aggs.add(match(Criteria.where("nome").regex(filter.getNome())));

		}

		if (!StringUtils.isEmpty(filter.getCpf())) {
			aggs.add(match(Criteria.where("cpf").is(filter.getCpf())));
		}

		if (!StringUtils.isEmpty(filter.getUaCodigo())) {
			aggs.add(match(Criteria.where("infoServidor.unidade.uaCodigo").is(filter.getUaCodigo())));
		}

		aggs.add(facet()
				.and(skip((long) (pageable.getPageSize() * (pageable.getPageNumber() - 1))),
						limit(pageable.getPageSize()))
				.as("infoServidor").and(group().count().as("total"), project().andExclude("_id")).as("infoPage"));
				Aggregation agg = newAggregation(aggs);

		List<BasicDBObject> dbs = mongoTemplate.aggregate(agg, "servidor", BasicDBObject.class).getMappedResults();

		ObjectMapper mapper = new ObjectMapper();
		long total = 1;
		List<ServidorDTO> servidores;
		try {
			servidores = mapper.readValue(dbs.get(0).get("infoServidor").toString(),
					new TypeReference<List<ServidorDTO>>() {
					});
			JSONObject json = (JSONObject) new JSONArray(dbs.get(0).get("infoPage").toString()).get(0);
			total = (long) json.get("total");

		} catch (UnrecognizedPropertyException e) {
			
			servidores = null;
			System.out.println(e);

		} catch (Exception e) {
			System.out.println(e);
			servidores = null;
		}
		return new PageImpl<ServidorDTO>(servidores, pageable, (long)total);

	}

}
