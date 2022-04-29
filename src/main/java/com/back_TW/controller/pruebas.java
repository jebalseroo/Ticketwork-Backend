package com.back_TW.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.back_TW.models.entity.TicketImprimir;
import com.back_TW.models.services.ITicketImprimir;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("pruebas")
public class pruebas 
{
	@Autowired 
	private ITicketImprimir imptick;
	
	@GetMapping
	@RequestMapping(value = "/listarT")
	public List<TicketImprimir> listar() 
	{
		 return imptick.listar();
	}
	

}
