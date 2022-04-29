package com.back_TW.models.repository;

import com.back_TW.models.entity.servicios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface serviciosRepository extends CrudRepository<servicios, Long> {

}
