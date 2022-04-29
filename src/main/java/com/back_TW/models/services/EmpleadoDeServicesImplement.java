package com.back_TW.models.services;

import com.back_TW.models.entity.empleadode;
import com.back_TW.models.entity.empresa;
import com.back_TW.models.entity.personas;
import com.back_TW.models.repository.empleadodeRepository;
import com.back_TW.models.repository.empresaRepository;
import com.back_TW.models.repository.personaRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpleadoDeServicesImplement implements IEmpleadoDeServices {

	@Autowired
	private empleadodeRepository empleadodeRepository;

	@Autowired
	private personaRepository personaRepository;


	@Override
	public List<empleadode> listar() {
		return null;
	}

	@Override
	public String listarOperadores(long idEmpresa) throws JSONException {
		List<empleadode> list = (List<empleadode>) empleadodeRepository.findAll();
		ArrayList<Integer> listaIdsEmpleados = new ArrayList<Integer>();
		for(int i = 0; i < list.size();i++){
			if(list.get(i).getIdEmpresa() == idEmpresa){
				listaIdsEmpleados.add(list.get(i).getIdPersona());
			}
		}
		List<personas> listPersonas = (List<personas>) personaRepository.findAll();
		JSONArray listaOperadores = new JSONArray();
		for(int i = 0; i < listPersonas.size();i++){
			if(listPersonas.get(i).getRol().equals("operador")){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("nombre",listPersonas.get(i).getNombre());
				jsonObject.put("apellidos",listPersonas.get(i).getApellidos());
				jsonObject.put("cedula",listPersonas.get(i).getCedula());
				jsonObject.put("usuario",listPersonas.get(i).getUsuario());
				jsonObject.put("rol",listPersonas.get(i).getRol());
				jsonObject.put("correo",listPersonas.get(i).getCorreo());
				jsonObject.put("id_persona",listPersonas.get(i).getIdpersonas());
				listaOperadores.put(jsonObject);
			}
		}
		return listaOperadores.toString();
	}

	@Override
	public void Registro(empleadode x) {
		empleadodeRepository.save(x);
	}

	@Override
	public long idEmpresa(long id) 
	{
		long idEmpresa = 0;
		List<empleadode> list = (List<empleadode>) empleadodeRepository.findAll();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).getIdPersona() == id){
				idEmpresa = list.get(i).getIdEmpresa();
			}
		}
		return idEmpresa;
	}

	@Override
	public long idconEmpresa(long idemp) 
	{
		long idpersona = -1;
		List<empleadode> list = (List<empleadode>) empleadodeRepository.findAll();
		for(int i = 0; i< list.size(); i++){
			if(list.get(i).getIdEmpresa() == idemp)
			{
				idpersona = list.get(i).getIdempleadosde();
				return idpersona;
			}
		}
		return idpersona;
	}

	@Override
	public long operadorid(long id) {
	
		List<empleadode> e = (List<empleadode>) empleadodeRepository.findAll();
		for (int i = 0; i < e.size(); i++) 
		{
			if (e.get(i).getIdempleadosde() == id) 
			{
				return e.get(i).getIdPersona();
			}
		}
		
		
		return -1;
	}

	@Override
	public empleadode empleadoDe(long id) 
	{
		
		Optional<empleadode> e = empleadodeRepository.findById(id);
		return e.get();
	}

	
	
	
	
}



