package com.back_TW.controller;

import com.back_TW.models.services.IEmpleadoDeServices;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.back_TW.models.entity.personas;
import com.back_TW.models.services.IPersonasServices;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/login")
public class LogIn {

    @Autowired
    private IPersonasServices person;

    @Autowired
    private IEmpleadoDeServices empleadoDeServices;

    private JSONObject jsonObject;

    @PostMapping
    @RequestMapping("/principal")
    public String registroEmleado (@RequestBody String entrada) throws JSONException {
        
    	
    	
    	JSONObject g = new JSONObject();
        JSONObject jsonObject = new JSONObject(entrada);
        if(person.existeUser(jsonObject.get("usuario").toString(), jsonObject.get("contrasena").toString()))
        {	        	
            g.put("respuesta","LogIn Existoso");
            g.put("rol",person.obtenerRol(jsonObject.get("usuario").toString()));
            personas p = person.existeUsuario(jsonObject.get("usuario").toString(), jsonObject.get("contrasena").toString());
            g.put("idPersona", p.getIdpersonas());
            g.put("idEmpresa", empleadoDeServices.idEmpresa(p.getIdpersonas()));
            
        }else{
            g.put("respuesta","Usuario O Contraseña Erroneo");
        }
        return g.toString();
    }

}
