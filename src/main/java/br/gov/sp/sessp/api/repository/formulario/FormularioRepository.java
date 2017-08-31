package br.gov.sp.sessp.api.repository.formulario;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.sessp.api.models.Formulario;

@Repository
public interface FormularioRepository extends MongoRepository<Formulario, Integer>, FormularioRepositoryCustom {

}
