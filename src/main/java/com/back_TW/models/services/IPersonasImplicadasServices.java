package com.back_TW.models.services;

import com.back_TW.models.entity.PersonasImplicadas;

public interface IPersonasImplicadasServices {
	
	public void guardar (PersonasImplicadas p); 
	
	public long buscarId (long idPrestador, long idCliente);
	
	public PersonasImplicadas persoObject (long id);
	



}
