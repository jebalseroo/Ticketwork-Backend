package com.back_TW.models.services;

import java.util.List;

import com.back_TW.models.entity.empresa;

public interface IEmpresaServices {
	
	
	public List<empresa> listar();
	
	public void registro (empresa e);

	public boolean existencia(String nit);
	
	public empresa EmpresaObjet (long id);
}
