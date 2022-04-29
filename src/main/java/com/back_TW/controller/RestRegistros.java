package com.back_TW.controller;

import com.back_TW.models.entity.*;
import com.back_TW.models.repository.PersonasImplicadasRepository;
import com.back_TW.models.repository.ticketRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.back_TW.models.repository.empleadodeRepository;
import com.back_TW.models.repository.personaRepository;
import com.back_TW.models.services.IPersonasServices;
import com.back_TW.models.services.IServiciosServices;
import com.back_TW.models.services.EmpleadoDeServicesImplement;
import com.back_TW.models.services.IEmpleadoDeServices;
import com.back_TW.models.services.IEmpresaServices;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/registro")
public class RestRegistros {
	
	@Autowired
	private IPersonasServices person;
	@Autowired
	private IEmpresaServices emp;

	@Autowired
	private IServiciosServices ser; 
	
	
	@Autowired
	private empleadodeRepository emp_de;

	@Autowired
	private personaRepository personaRepository;

	@Autowired
	private PersonasImplicadasRepository personasImplicadasRepository;

	@Autowired
	private ticketRepository ticketRepository;
	

	
	@PostMapping
	@RequestMapping("/reg_per")
	public String registroPersona(@RequestBody personas per ) throws JSONException 
	{
		JSONObject g = new JSONObject();
		if(person.existencia(per.getCedula())){
			g.put("respuesta","Usuario Ya Existe");
		}else{
			person.Registro(per);
			g.put("respuesta","Usuario Registrado");
		}
		return g.toString();
	}
// registro de personas------------------	
	@PostMapping
	@RequestMapping("/reg_emp")
	public String registroEmpresa (@RequestBody empresa e) throws JSONException 
	{
		JSONObject g = new JSONObject();
		if(emp.existencia(e.getNit())){
			g.put("respuesta","Empresa Ya Existe");
		}else{
			emp.registro(e);
			g.put("respuesta","Empresa Registrado");
		}
		return g.toString();

	}
//REGISTRTO EN empleados_de-------------------
	
	public void registroEmpleadosDe (long idUserRsgistrador, long idUserNuevo ) 
	{
		empleadode empd = new empleadode();
		int idEmpresa = emp_de.findById(idUserRsgistrador).get().getIdEmpresa();
		empd.setIdEmpresa(idEmpresa);
		empd.setIdPersona((int) idUserNuevo);
		empd.setSueldo("50");
		
		emp_de.save(empd);
		
	}
	
	
	
//registro de empleados------------------	
	@PostMapping
	@RequestMapping("/reg_empleado")
	public String registroEmleado (@RequestBody String entrada) throws JSONException
	{
		JSONObject g = new JSONObject();
		JSONObject pers = new JSONObject(entrada);
		personas per = new personas();
			per.setApellidos(pers.getString("apellidos"));
			per.setCedula(pers.getString("cedula"));
			per.setNombre(pers.getString("nombre"));
			per.setClave(pers.getString("clave"));
			per.setUsuario(pers.getString("usuario"));
			per.setCorreo(pers.getString("correo"));
			per.setRol(pers.getString("rol"));
		if(person.existencia(per.getCedula())){
			g.put("respuesta","Usuario Ya Existe");
		}else{
			
			
			person.Registro(per);
			g.put("respuesta","Usuario Registrado");
			personas  p = person.existeUsuario(per.getUsuario(), per.getClave());
			registroEmpleadosDe(pers.getLong("id_usuario_registrador"), p.getIdpersonas());
			
		}
		return g.toString();
	}
// registro de servicios------------------	
	@PostMapping
	@RequestMapping("/reg_serv")
	public void registroServicio (@RequestBody String serv) throws JSONException 
	{
		
		JSONObject g = new JSONObject();
		JSONObject servicio = new JSONObject(serv);
		servicios se = new servicios();
		se.setDescripcion(servicio.getString("descripcion"));
		se.setNombre(servicio.getString("nombre"));
		se.setEmpres(ser.idEmpresa(servicio.getLong("idpersona")));		
		System.out.print("____________"+ ser.idEmpresa(servicio.getLong("idpersona")) + "_________");
		
		ser.guardar(se);
		g.put("respuesta", "servicio registrado");
		

	}

	// Asignar Operador A Ticket------------------
	@PostMapping
	@RequestMapping("/operador_ticket")
	public String asignarOperadorTicket (@RequestBody String entrada) throws JSONException
	{

		JSONObject g = new JSONObject();
		JSONObject jsonObject = new JSONObject(entrada);
		Long idPersona = jsonObject.getLong("id_persona");
		Long idTicket = jsonObject.getLong("id_ticket");

		//me traigo los registros de empleadoDe
		List<empleadode> listaEmpleadoDe = (List<empleadode>) emp_de.findAll();
		Optional<empleadode> empleadode = null;
		for(int i = 0; i< listaEmpleadoDe.size(); i++)
		{
			//Busco el id del empleadoDe que sea del id de la persona que me pasaron
			if(listaEmpleadoDe.get(i).getIdPersona()==idPersona)
			{
				empleadode = emp_de.findById(listaEmpleadoDe.get(i).getIdempleadosde());
			}
		}
		//Obtengo el registro del ticket que necesito
		ticket ticket = ticketRepository.findById(idTicket).orElse(null);
		ticket.setFechaProgramadaIniciio(jsonObject.getString("fechaProgrmada"));
		//Con la información anterior encuentro el registro que tengo que modificar en personas Implicadas
		PersonasImplicadas personasImplicadas = personasImplicadasRepository.findById(ticket.getPersonasImplicadas_idpersonasImplicadas()).orElse(null);
		if(empleadode.isEmpty()){
			g.put("respuesta", "No Actualizado");
		}else{
			//Actualizo el registro y lo guardo
			personasImplicadas.setEmpleadosDe_idEmpleadosDe(empleadode.get().getIdempleadosde());
			personasImplicadasRepository.save(personasImplicadas);
			ticket ticket1 = ticketRepository.findById(idTicket).orElse(null);
			ticket1.setEstado("Asignado");
			ticketRepository.save(ticket1);
			g.put("respuesta", "Actualizado");
		}
		return g.toString();
	}

}
