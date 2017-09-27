package br.gov.sp.sessp.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.sessp.api.models.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, Integer> {

}
