package com.back_TW.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.back_TW.models.entity.TicketImprimir;

@Repository
public interface ImprimirTicketRpository extends CrudRepository<TicketImprimir, Long> 
{

}
