package com.back_TW.controller;

import com.back_TW.models.entity.PersonasImplicadas;
import com.back_TW.models.entity.TicketImprimir;
import com.back_TW.models.entity.empleadode;


import com.back_TW.models.entity.PersonasImplicadas;
import com.back_TW.models.entity.empresa;
import com.back_TW.models.entity.personas;
import com.back_TW.models.entity.servicios;
import com.back_TW.models.entity.ticket;
import com.back_TW.models.services.EmpleadoDeServicesImplement;
import com.back_TW.models.entity.ticket;
import com.back_TW.models.repository.PersonasImplicadasRepository;
import com.back_TW.models.repository.empleadodeRepository;
import com.back_TW.models.repository.personaRepository;
import com.back_TW.models.repository.serviciosRepository;
import com.back_TW.models.repository.ticketRepository;
import com.back_TW.models.services.IEmpresaServices;
import com.back_TW.models.services.IPersonasImplicadasServices;
import com.back_TW.models.services.IPersonasServices;
import com.back_TW.models.services.IServiciosServices;
import com.back_TW.models.services.ITicketImprimir;
import com.back_TW.models.services.ITicketServices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("empleado")
public class RestVisualizar {
	
	@Autowired
	private IServiciosServices serv;

	@Autowired
	private IPersonasServices person;	
	
	@Autowired
	private ITicketServices ticket;

	@Autowired
	private personaRepository p;

	@Autowired
	private PersonasImplicadasRepository persImp;
	
	@Autowired
	private serviciosRepository service;

	@Autowired
	private ticketRepository t;

	@Autowired
	private EmpleadoDeServicesImplement empDe;

	@Autowired
	private ITicketServices tick;

	@Autowired
	private IEmpresaServices empresaServ;

	@Autowired
	private IPersonasImplicadasServices perImpServ;
	
	@Autowired
	private empleadodeRepository emp_de;
	
	@Autowired
	private ITicketImprimir ticketImp;

	public  String getFechaActual() 
	{
	    Date ahora = new Date();
	    SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
	    return formateador.format(ahora);
	}
	
	

    @PostMapping
    @RequestMapping(value = "/info/{idpersonas}")
    public String visualizarEmpleado (@PathVariable long idpersonas) throws JSONException {
    	
    	JSONObject g = new JSONObject();
    	
    	if(person.existencia(person.obtenerPersona(idpersonas).getCedula())){
			g.put("Nombre",person.obtenerPersona(idpersonas).getNombre());
			g.put("Apellidos",person.obtenerPersona(idpersonas).getApellidos());
			g.put("Clave",person.obtenerPersona(idpersonas).getClave());
			g.put("Cedula",person.obtenerPersona(idpersonas).getCedula());
			g.put("Usuario",person.obtenerPersona(idpersonas).getUsuario());
			g.put("Rol",person.obtenerPersona(idpersonas).getRol());
			g.put("Correo",person.obtenerPersona(idpersonas).getCorreo());
		}else{
			g.put("respuesta", "informacion invalida");
		}

    	return g.toString();
    }

    @PostMapping
    @RequestMapping(value = "/actualizar/{idpersonas}")
    public String actualizarEmpleado (@PathVariable long idpersonas, @RequestBody String entrada) throws JSONException {

    	JSONObject g = new JSONObject();
		JSONObject pers = new JSONObject(entrada);
		personas per = person.obtenerPersona(idpersonas);

		per.setApellidos(pers.getString("apellidos"));
		per.setNombre(pers.getString("nombre"));
		per.setClave(pers.getString("clave"));
		per.setUsuario(pers.getString("usuario"));
		per.setCorreo(pers.getString("correo"));

		p.save(per);

    	if(person.existencia(person.obtenerPersona(idpersonas).getCedula())){

			g.put("Nombre", per.getNombre());
			g.put("Apellidos", per.getApellidos());
			g.put("Clave", per.getClave());
			g.put("Usuario", per.getUsuario());
			g.put("Correo", per.getCorreo());

			g.put("Respuesta", "usuario actualizado");
		}else{
			g.put("respuesta", "informacion invalida");
		}

    	return g.toString();
    }

    @GetMapping
    @RequestMapping(value = "/cat_serv")
    public List <servicios> visualizarCatalogo()
    {
    	return serv.listar();
    }
    

    @PostMapping
    @RequestMapping(value = "/tickets/{idpersonas}")
    public List<TicketImprimir> verTicketsEmpleado(@PathVariable long idpersonas) throws JSONException {
    	List<PersonasImplicadas> listaPersonImplicadas = (List<PersonasImplicadas>) persImp.findAll();
    	List<empleadode> emplDe = (List<empleadode>) emp_de.findAll();
    	List<ticket> listaTickets = (List<ticket>) t.findAll();
    	List<ticket> ticks = new ArrayList<ticket>();
    	List<TicketImprimir> tickimp = new ArrayList<TicketImprimir>();
    	
    	
    	for (int e=0; e <emplDe.size(); e++ )
    	{System.out.println();
		System.out.println();
		
		System.out.println();
    		if(emplDe.get(e).getIdPersona() == idpersonas)
    		{
		    	for (int i = 0; i < listaPersonImplicadas.size(); i++)
		    	{
					if (listaPersonImplicadas.get(i).getEmpleadosDe_idEmpleadosDe() == emplDe.get(e).getIdempleadosde())
					{							
						for (int j = 0; j < listaTickets.size(); j++) 
						{
							if(listaTickets.get(j).getPersonasImplicadas_idpersonasImplicadas() == listaPersonImplicadas.get(i).getIdpersonas_implicadas()) 
							{
								ticks.add(listaTickets.get(j));
							}
						}		
					}
				}
    		}
    	}
    	for (int i = 0; i < ticks.size(); i++) 
    	{ 
    		tickimp.add(i,imprimirticket(ticks.get(i).getIdticket()));
			System.out.println();
			System.out.println();
			System.out.println(ticks.get(i).toString()+ "_______ ahhhhhhh admin_________");
			System.out.println();
		}
    	
    	
    	return tickimp;
    }
    
    
    @PostMapping
    @RequestMapping(value = "/serv_empresa/{idempresa}")
    public List <servicios> visualizarServiciosPorEmpresa(@PathVariable long idempresa)
    {
    	List<servicios> listaServicios = (List<servicios>) service.findAll();
		for (int i = 0; i < listaServicios.size(); i++)
		{

			if (listaServicios.get(i).getEmpres() == idempresa)
			{
				return serv.listar();
			}
		}
		return null;
    }
// ver tickets desde cliente
    @PostMapping
    @RequestMapping(value = "/mis_tickets")
    public List<TicketImprimir> VisualizarMisTickets(@RequestBody String idUser) throws JSONException
    {
    	JSONObject id = new JSONObject(idUser);
    	long idEmpresa = empDe.idEmpresa(id.getLong("id"));
    	List<ticket> misTickets =  tick.ConsultarMisTickets(idEmpresa);
    	List<TicketImprimir> tickimp = new ArrayList<TicketImprimir>();
    	//Gson gson = new Gson();
    	
    	for (int i = 0; i < misTickets.size(); i++) 
    	{ 
    		tickimp.add(i,imprimirticket(misTickets.get(i).getIdticket()));
			System.out.println();
			System.out.println(misTickets.get(i).toString()+ "___________________ ahhhhhhh");
			System.out.println();
		}
    	
    	return tickimp;
    }

    
    
    @PostMapping
    @RequestMapping(value = "/mis_tickets_admin")
    public List<TicketImprimir> visualizarMisTicketsAdmin (@RequestBody String idEmpresa) throws JSONException
    {
    	JSONObject idE = new JSONObject(idEmpresa);
    	Long idEmp = idE.getLong("idEmpresa");
    	List<servicios> misServs = serv.listarMisServicios(idEmp);
    	List<ticket> misTickets =  tick.ConsultarMisTicketsAdmin(misServs);
    	List<TicketImprimir> tickimp = new ArrayList<TicketImprimir>();
    	for (int i = 0; i < misTickets.size(); i++) 
    	{ 
    		tickimp.add(i,imprimirticket(misTickets.get(i).getIdticket()));
			System.out.println();
			System.out.println();
			System.out.println(misTickets.get(i).toString()+ "___________________ ahhhhhhh admin_________________________");
			System.out.println();
		}
    	
    	
    	return tickimp;
    }
    
    
    //regresa un ticket , debe usarse en un ciclo 

    public TicketImprimir  imprimirticket (ticket t) throws JSONException
    {	empresa empresaP = new empresa();
    	empresa empresaC = new empresa();
    	personas perOperador =  new personas();
    	personas perCliente =  new personas();
    	PersonasImplicadas persImp = new PersonasImplicadas();
    	JSONObject ticks = new JSONObject();
    	
    	TicketImprimir ti = new TicketImprimir();

    	//idTicket
    		ti.setIdTicket(t.getIdticket());
    		System.out.println();
    		System.out.println("id ticket" + t.getIdticket());
    		System.out.println();
    		
    	//datos Empresa Presatadora
    		long idEmpresaPrestadora = serv.idEmpresaConId(t.getServicios_idservicios());
    		empresaP = empresaServ.EmpresaObjet(idEmpresaPrestadora);
    		ti.setNombreEmpresaPrestadora(empresaP.getNombre());
    		
    		ti.setNitEmpresaPrestadora(empresaP.getNit());
    		
    	//datos del servicio
    		servicios s = new servicios();
    		s = serv.buscar(t.getServicios_idservicios());
    		ti.setIdServicio(t.getServicios_idservicios());
    		
    		ti.setNombreServicio(s.getNombre());
    		
    	//datos empresa cliente
    		empresaC = empresaServ.EmpresaObjet(t.getEmpresa_idempresaCliente());
    		System.out.println();
    		ti.setNombreEmpresaCliente(empresaC.getNombre());
    	
    		ti.setNitEmpresaCliente(empresaC.getNit());
    	
    	//datos personas implicadas
    	//cliente
    		persImp = perImpServ.persoObject(t.getPersonasImplicadas_idpersonasImplicadas());
    		perCliente = person.obtenerPersona(persImp.getPersonas_idpersonas());
    		ti.setNombrePersonaCliente(perCliente.getNombre() +"  "+ perCliente.getApellidos());
    	
    	//operador
    		long idop = empDe.operadorid(persImp.getEmpleadosDe_idEmpleadosDe());
    		perOperador = person.obtenerPersona(idop);
    		ti.setNombreOperador(perOperador.getNombre() +"  "+ perOperador.getApellidos());
    		
    	//info ticket
    		ti.setDescirpcionTicket(t.getDescripcion());
      	return ti;

    }
    
    
    
    public TicketImprimir  imprimirticket (long idTicket) 
    {	
    	System.out.println();
    	System.out.println("______________ si entre a imprimir________________");
    	System.out.println();
    	//List<TicketImprimir> todos = ticketImp.listar();
    	TicketImprimir t = ticketImp.buscarXId(idTicket);
    	System.out.println();
    	System.out.println("______________ si entre a imprimir 2!!________________");
    	System.out.println();
    	
    	return t;
    }
    
    @PostMapping
    @RequestMapping(value = "/estadoTicket")
    public String estadoTicket(@RequestBody String entrada) throws JSONException
    { 	JSONObject g = new JSONObject();
		JSONObject infoTicket = new JSONObject(entrada);
		Long idTicket = infoTicket.getLong("id_ticket");
		
		ticket ticketE = tick.obtenerTicket(idTicket);
		ticketE.setEstado(infoTicket.getString("estado"));
    	if ( ticketE.getEstado().equals("cancelado") )
    	{
    		g.put("respuesta", "ticket cerrado");
    		return g.toString();
		}else 
		{
			
			if(ticketE.getEstado().equals("finalizado")) 
			{
				ticketE.setFechaFinal(getFechaActual());
				g.put("respuesta", "Estado actualizado");
				t.save(ticketE);
				return g.toString();
			}
			
			ticketE.setEstado(infoTicket.getString("estado"));
			ticketE.setFechaInicio(getFechaActual());
			g.put("respuesta", "Estado actualizado");
			t.save(ticketE);
		
			return g.toString();
    	}
    }
    
 // Cancelar ticket a operador desde cliente
 	@PostMapping
 	@RequestMapping("/cancelar")
 	public String asignarOperadorTicket (@RequestBody String entrada) throws JSONException
 	{

 		JSONObject g = new JSONObject();
 		JSONObject info = new JSONObject(entrada);
 		Long idTicket = info.getLong("id_ticket");
 		String cancelar = info.getString("cancelacion");
 		
 		if(cancelar.equals("cancelar"))
 		{
 			//Se busca el ticket y las operadores asignados
 			ticket ticket = t.findById(idTicket).orElse(null);
 	 		PersonasImplicadas personI = persImp.findById(ticket.getPersonasImplicadas_idpersonasImplicadas()).orElse(null);
 	 		ticket.setEstado("canelado");
 	 		ticket.setFechaFinal(getFechaActual());
 	 		t.save(ticket);
 	 		
 	 		//Se verifica que si este asignado
 	 		if(personI.getEmpleadosDe_idEmpleadosDe() == 0)
 	 		{
 	 			g.put("respuesta", "Ticket no asignado");
 	 		}
 	 		else
 	 		{
 	 			//Se desasocia de cuaquier empleado para que no se le liste desde operador
 	 			personI.setEmpleadosDe_idEmpleadosDe(0);
 	 			persImp.save(personI);
 	 			g.put("respuesta", "Ticket cancelado");
 	 		}
 		}
 		return g.toString();
 	}


}
