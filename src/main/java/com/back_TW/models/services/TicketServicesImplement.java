package com.back_TW.models.services;

import com.back_TW.models.entity.PersonasImplicadas;

import com.back_TW.models.entity.empleadode;
import com.back_TW.models.entity.personas;
import com.back_TW.models.entity.servicios;
import com.back_TW.models.entity.ticket;
import com.back_TW.models.repository.personaRepository;
import com.back_TW.models.repository.ticketRepository;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Service
public class TicketServicesImplement implements ITicketServices {

	@Autowired
	private ticketRepository ticketRepository;

	@Autowired
	private EmpleadoDeServicesImplement emplde;
	
	@Autowired
	private PersonasImplicadasImplement perImp;

	@Autowired
	private ServiciosServicesImplement serv;
	

	
	public  String getFechaActual() 
	{
	    Date ahora = new Date();
	    SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
	    return formateador.format(ahora);
	}
	
	
	@Override
	public void CrearTicket(String descripcion, String idServicio, long idUser)
	{
		
		
		long idEmpresaCliente = emplde.idEmpresa(idUser);
		System.out.print("_____________"+"idEmpresaCliente "+idEmpresaCliente+"___________");
		ticket ticket = new ticket();
		PersonasImplicadas personImp = new PersonasImplicadas();
		ticket.setDescripcion(descripcion);
		ticket.setEstado("Solicitud");
		ticket.setServicios_idservicios(Integer.parseInt(idServicio));
		ticket.setEmpresa_idempresaCliente((int)idEmpresaCliente);
	//llenado PersonasImplicadas___________________________________________
		servicios s = new servicios();
		s=serv.buscar(Integer.parseInt(idServicio));
		long idEmprprest = s.getEmpres();
		System.out.print("_____________________________________"+ idEmprprest + "_________________________________");
		
		personImp.setEmpleadosDe_idEmpleadosDe(emplde.idconEmpresa(idEmprprest));//persona prestadora	
		personImp.setPersonas_idpersonas(idUser);//persona Cliente
		perImp.guardar(personImp);
		
	//_____________________________________________________________________
	//busqueda idPersonas implicadas recien agragado 	
		long idPersImp =perImp.buscarId(emplde.idconEmpresa(idEmprprest), idUser);
		System.out.print("_____________"+"idPersImp "+idPersImp+"___________");
		ticket.setPersonasImplicadas_idpersonasImplicadas(idPersImp);
		
		ticket.setFechaSolicitud(getFechaActual());
		ticketRepository.save(ticket);
		
		
	}
	
	@Override
	public List<ticket> listar() {

		return (List<ticket>) ticketRepository.findAll();
	}
	
	//este solo sireve para empresas clientes

	@Override
	public List<ticket> ConsultarMisTickets(long idemp) {
		List<ticket> listatodos = (List<ticket>) ticketRepository.findAll();
		List<ticket> ticketsEmpresa = new ArrayList<>();
		for (int i = 0; i < listatodos.size(); i++)
		{
			if (listatodos.get(i).getEmpresa_idempresaCliente() == idemp)
			{
				System.out.print("___________________"+"idemp "+idemp+"_____________________" );
				System.out.print(":_____________________ ticket:"+ listatodos.get(i).toString());
				ticketsEmpresa.add(listatodos.get(i));
				System.out.print(":_____________________ ticket:"+ ticketsEmpresa.get(i).toString());
			}
		}


		return ticketsEmpresa;
	}

	@Override
	public List<ticket> ConsultarMisTicketsAdmin(List<servicios> s) 
	{
		List<ticket> listatodos = (List<ticket>) ticketRepository.findAll();
		List<ticket> misServsSdmin = new ArrayList<ticket>();
		for (int i = 0; i < listatodos.size(); i++) 
		{
			for (int j = 0; j < s.size(); j++) 
			{
				if (listatodos.get(i).getServicios_idservicios() == s.get(j).getIdservicios() ) 
				{
					misServsSdmin.add(listatodos.get(i));
				}
			}
			
		}
		return misServsSdmin;
	}
	
	@Override
	public ticket obtenerTicket(long id) {
		
		return  ticketRepository.findById(id).get();
	}
	
	@Override
	public List<ticket> ticketsUser(long id) {
		
		List<ticket> listaTickets = (List<ticket>) ticketRepository.findAll();
		List<ticket> findById = new ArrayList<ticket>();
		
		for (int i = 0; i < listaTickets.size(); i++) 
		{
			if (listaTickets.get(i).getIdticket() == id) 
			{
				findById.add(listaTickets.get(i));
			}
		}
		return  findById;
	}
}
