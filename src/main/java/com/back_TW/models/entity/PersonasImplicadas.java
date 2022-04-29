package com.back_TW.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personas_implicadas")
public class PersonasImplicadas implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long  idpersonas_implicadas;
	
	@Column(name = "personas_idpersonas")
	private long personas_idpersonas;
	
	@Column(name = "empleados_de_id_empleados_de")
	private long empleadosDe_idEmpleadosDe;

	
//______________________________________________________
	



	public PersonasImplicadas() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getIdpersonas_implicadas() {
		return idpersonas_implicadas;
	}



	public long getPersonas_idpersonas() {
		return personas_idpersonas;
	}


	public void setPersonas_idpersonas(long personas_idpersonas) {
		this.personas_idpersonas = personas_idpersonas;
	}


	public long getEmpleadosDe_idEmpleadosDe() {
		return empleadosDe_idEmpleadosDe;
	}


	public void setEmpleadosDe_idEmpleadosDe(long empleadosDe_idEmpleadosDe) {
		this.empleadosDe_idEmpleadosDe = empleadosDe_idEmpleadosDe;
	}

	
	
}
