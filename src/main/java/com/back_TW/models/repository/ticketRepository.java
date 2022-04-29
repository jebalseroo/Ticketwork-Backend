package com.back_TW.models.repository;

import com.back_TW.models.entity.servicios;
import com.back_TW.models.entity.ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketRepository extends CrudRepository<ticket, Long> {

}
