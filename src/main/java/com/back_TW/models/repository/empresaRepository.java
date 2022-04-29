package com.back_TW.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.back_TW.models.entity.empresa;

@Repository
public interface empresaRepository extends CrudRepository<empresa, Long> {

}
