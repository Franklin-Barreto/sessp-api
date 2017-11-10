package br.gov.sp.sessp.api.repository.servidor;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.skip;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.util.StringUtils;
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
		aggs.add(skip((long) (pageable.getPageSize() *( pageable.getPageNumber()-1))));
		aggs.add(limit(pageable.getPageSize()));
		
		Aggregation agg = newAggregation(aggs);
		
		List<ServidorDTO> servidores = mongoTemplate.aggregate(agg, "servidor", ServidorDTO.class).getMappedResults();
System.out.println("TESTE"+pageable.getOffset());
		Long total = (long) servidores.size();
		System.out.println("Total de registros" + total);

		return new PageImpl<ServidorDTO>(servidores, pageable, 5);

	}

}
