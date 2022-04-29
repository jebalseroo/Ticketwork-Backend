package com.back_TW.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_TW.models.entity.empresa;
import com.back_TW.models.repository.empresaRepository;

@Service
public class EmpresaServicesImplement implements IEmpresaServices {

	@Autowired
	private empresaRepository emp;
	
	
	@Override
	public List<empresa> listar() {
		 return (List<empresa>) emp.findAll();
		
	}

	@Override
	public void registro(empresa x) {
		emp.save(x);

	}

	@Override
	public boolean existencia(String nit) {
		boolean existe = false;
		List<empresa> list = (List<empresa>) emp.findAll();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).getNit().equals(nit)){
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public empresa EmpresaObjet(long id) 
	{
		List<empresa> Emp = (List<empresa>) emp.findAll();
		for (int i = 0; i < Emp.size(); i++) 
		{
			if (Emp.get(i).getIdempresa()== id)
			{
				return Emp.get(i);
			}
		}
		
		return null;
	}
}



