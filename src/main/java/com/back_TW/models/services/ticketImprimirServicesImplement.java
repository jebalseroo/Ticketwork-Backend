package com.back_TW.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_TW.models.entity.TicketImprimir;
import com.back_TW.models.repository.ImprimirTicketRpository;

@Service
public class ticketImprimirServicesImplement implements ITicketImprimir 
{
	@Autowired 
	private ImprimirTicketRpository impTicket;	
	
	@Override
	public List<TicketImprimir> listar() 
	{
		return (List<TicketImprimir>) impTicket.findAll();
		
	}

	@Override
	public TicketImprimir buscarXId(long id) {
		Optional<TicketImprimir> t = impTicket.findById(id);
		return t.get();
	}

}
