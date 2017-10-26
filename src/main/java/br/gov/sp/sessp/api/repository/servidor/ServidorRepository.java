package br.gov.sp.sessp.api.repository.servidor;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.gov.sp.sessp.api.models.Servidor;

public interface ServidorRepository extends MongoRepository<Servidor, Integer> {

	public Servidor findByRsCodigoAndInfoServidorPvCodigo(Integer rsCodigo, int pvCodigo);
}
