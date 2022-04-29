package com.back_TW.models.services;



import java.util.List;

import com.back_TW.models.entity.personas;
import com.back_TW.models.entity.servicios;

//la tabla se llama empleados_de

public interface IServiciosServices {

	public boolean existencia(long idservicios, long idEmpresaPrestadora);
	
	public void Registro(servicios x); 
	
	public boolean existencia(Long ids);
	
	public long idEmpresa(long idper);
	
	public long idEmpresaConId(long id);
	
	public void guardar(servicios s);
	
	public List<servicios> listar(); 
	
	public List<servicios> listarMisServicios(long idEmp); 
		
	public servicios buscar (long idServ);
}
