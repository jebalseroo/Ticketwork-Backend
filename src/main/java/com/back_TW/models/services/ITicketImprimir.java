package com.back_TW.models.services;

import java.util.List;

import com.back_TW.models.entity.TicketImprimir;

public interface ITicketImprimir
{

	
	public List<TicketImprimir> listar();
	public TicketImprimir buscarXId (long id);
}
