package com.back_TW.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back_TW.models.entity.personas;
import com.back_TW.models.services.IPersonasServices;

@RestController
public class personaController {

	@Autowired
	private IPersonasServices person;
	
	@GetMapping
	public List<personas> listar ()
	{
		
		return person.listar();
	}
}
