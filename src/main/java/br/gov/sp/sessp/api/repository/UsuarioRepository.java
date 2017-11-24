package br.gov.sp.sessp.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.gov.sp.sessp.api.models.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
