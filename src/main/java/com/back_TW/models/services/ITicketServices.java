package com.back_TW.models.services;

import java.sql.Date;

import java.util.List;
import java.util.Optional;

import com.back_TW.models.entity.servicios;
import com.back_TW.models.entity.ticket;

public interface ITicketServices {

	public List<ticket> listar();
	public ticket obtenerTicket(long id);

	public void CrearTicket(String descripcion, String idServicio, long idUser);
	
	public List<ticket> ticketsUser (long iduser);
	public List<ticket> ConsultarMisTickets (long idemp);//este solo sireve para empresas clientes
	public List<ticket> ConsultarMisTicketsAdmin (List<servicios> s);//este solo sireve para empresas prestadora 
	
}
