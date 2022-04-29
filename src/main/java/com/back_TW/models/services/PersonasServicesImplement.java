package com.back_TW.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_TW.models.entity.personas;
import com.back_TW.models.repository.personaRepository;
@Service
public class PersonasServicesImplement implements IPersonasServices 
{

	@Autowired
	private personaRepository person;
	
	@Override
	public List<personas> listar() {
		
		return (List<personas>) person.findAll();
	}

	@Override
	public void Registro(personas per) {
		person.save(per);
		
	}

	@Override
	public boolean existencia(String cedula) {
		boolean existe = false;
		List<personas> list = (List<personas>) person.findAll();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).getCedula().equals(cedula)){
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public boolean existeUser(String usuario, String contrasena) {
		boolean existe = false;
		List<personas> list = (List<personas>) person.findAll();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).getUsuario().equals(usuario)){
				if(list.get(i).getClave().equals(contrasena)){
					existe = true;
				}
			}
		}
		return existe;
	}
	public personas existeUsuario(String usuario, String contrasena) {
		boolean existe = false;
		List<personas> list = (List<personas>) person.findAll();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).getUsuario().equals(usuario)){
				if(list.get(i).getClave().equals(contrasena)){
					personas p = list.get(i);
					return p;
				}
			}
		}
		return null;
	}
	
	@Override
	public String obtenerRol(String usuario) {
		String rol = "";
		List<personas> list = (List<personas>) person.findAll();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).getUsuario().equals(usuario)){
				rol = list.get(i).getRol();
			}
		}
		return rol;
	}

	@Override
	public String obtenerId(String usuario) {
		String rol = "";
		List<personas> list = (List<personas>) person.findAll();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).getUsuario().equals(usuario)){
				rol = list.get(i).getRol();
			}
		}
		return rol;
	}

	@Override
	public personas obtenerPersona(long id) {
		return person.findById(id).get();

	}
}
