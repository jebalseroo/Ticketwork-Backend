package com.back_TW.models.services;

import java.util.List;

import com.back_TW.models.entity.personas;

public interface IPersonasServices {

	
	public List<personas> listar(); 
	

	public void Registro(personas x); 

	public boolean existencia(String cedula);

	public boolean existeUser(String usuario, String contrasena);

	public personas existeUsuario(String usuario, String contrasena);

	public String obtenerRol(String usuario);

	public String obtenerId(String usuario);

	public personas obtenerPersona(long id);

}
