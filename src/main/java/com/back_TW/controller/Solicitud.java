package com.back_TW.controller;

import com.back_TW.models.entity.personas;
import com.back_TW.models.services.EmpleadoDeServicesImplement;
import com.back_TW.models.services.IServiciosServices;
import com.back_TW.models.services.ITicketServices;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/solicitud")
public class Solicitud {

    @Autowired
    private IServiciosServices servicios;

    @Autowired
    private ITicketServices iTicketServices;

    @Autowired
    private EmpleadoDeServicesImplement empDe;

    private JSONObject jsonObject;

    @PostMapping
    @RequestMapping("/servicio")
    public String solicitudServicio (@RequestBody String entrada) throws JSONException 
    {
        JSONObject g = new JSONObject();
        JSONObject jsonObject = new JSONObject(entrada);
        
        long idUser = jsonObject.getLong("idUsuario");
        iTicketServices.CrearTicket(jsonObject.getString("descripcion"),jsonObject.getString("idServicio"), idUser);
        g.put("respuesta","Solicitud Exitosa");
        return g.toString();
    }

    @PostMapping
    @RequestMapping("/operadores")
    public String listarOperadores (@RequestBody String entrada) throws JSONException {
        JSONObject jsonObject = new JSONObject(entrada);
        long idEmpresa = jsonObject.getLong("idEmpresa");
        return empDe.listarOperadores(idEmpresa);
    }

}
