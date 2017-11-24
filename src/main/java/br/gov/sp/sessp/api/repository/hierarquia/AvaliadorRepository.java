package br.gov.sp.sessp.api.repository.hierarquia;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.gov.sp.sessp.api.models.Avaliador;
import br.gov.sp.sessp.api.models.ServidorId;

public interface AvaliadorRepository extends MongoRepository<Avaliador, ServidorId> {

}
