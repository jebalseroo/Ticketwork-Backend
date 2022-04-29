package com.back_TW.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.back_TW.models.entity.PersonasImplicadas;

@Repository
public interface PersonasImplicadasRepository extends CrudRepository<PersonasImplicadas, Long> {

}
