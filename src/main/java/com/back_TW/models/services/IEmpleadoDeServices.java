package com.back_TW.models.services;

import java.util.ArrayList;
import java.util.List;

import com.back_TW.models.entity.empleadode;
import com.back_TW.models.entity.personas;
import org.json.JSONException;


public interface IEmpleadoDeServices {
	
public List<empleadode> listar();

public String listarOperadores(long idEmpresa) throws JSONException;
	
public void Registro(empleadode x); 

public long idEmpresa (long id);

public long idconEmpresa (long idemp);

public long operadorid (long id);

public empleadode empleadoDe (long id);

}
