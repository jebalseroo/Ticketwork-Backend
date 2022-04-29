package com.back_TW.models.services;


import com.back_TW.models.entity.empleadode;
import com.back_TW.models.entity.personas;
import com.back_TW.models.entity.servicios;
import com.back_TW.models.repository.empleadodeRepository;
import com.back_TW.models.repository.serviciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.valueOf;

@Service
public class ServiciosServicesImplement implements IServiciosServices {

	@Autowired
	private serviciosRepository service;

	@Autowired 
	private empleadodeRepository emp;
	
	@Override
	public boolean existencia(long idservicios, long idEmpresa) 
	{
		boolean existe = false;
		List<servicios> list = (List<servicios>) service.findAll();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).getIdservicios() == idservicios)
			{
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public void Registro(servicios x)
	{
	 
		service.save(x);
		
	}

	@Override
	public boolean existencia(Long ids) {
		boolean existe = false;
		List<servicios> list = (List<servicios>) service.findAll();
		for(int i = 0; i< list.size(); i++)
		{
			if(list.get(i).getIdservicios() == ids)
			{
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public long idEmpresa(long idPer)
	{
		
		List<empleadode> listaEmpleados= (List<empleadode>) emp.findAll();
		for (int i = 0; i < listaEmpleados.size(); i++) 
		{
		
			if (listaEmpleados.get(i).getIdempleadosde() == idPer) 
			{
				long idEmp = listaEmpleados.get(i).getIdEmpresa();
				return idEmp;
			}
		}
		
		return -1;
	}

	@Override
	public void guardar(servicios s) {
		service.save(s);
		
	}
	
	public List<servicios> listar() {
		
		return (List<servicios>) service.findAll();
	}

	@Override
	public servicios buscar(long idServ) {
		Optional<servicios> s = Optional.ofNullable(new servicios());
		s= service.findById(idServ);
		return s.get();
	}

	@Override
	public long idEmpresaConId(long id) 
	{
		List<servicios> servi = (List<servicios>) service.findAll();
		for (int i = 0; i < servi.size(); i++) 
		{
			if (servi.get(i).getIdservicios() == id) 
			{
				return servi.get(i).getIdservicios(); 
			}
		}
		
		return -1;
	}

	@Override
	public List<servicios> listarMisServicios(long idEmp) {
		List<servicios> MisServs = new ArrayList<servicios>();
		List<servicios> servs = listar();
		for (int i = 0; i <listar().size(); i++) 
		{
			if (servs.get(i).getEmpres() == idEmp) 
			{
				MisServs.add(servs.get(i));
			}
		}
		
		return MisServs;
	}	

	
}
