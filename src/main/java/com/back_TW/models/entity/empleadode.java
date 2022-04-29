package com.back_TW.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleados_de")
public class empleadode implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long  idempleadosde;
	
	@Column(name = "personas_idpersonas")
	private int idPersona;

	@Column (name = "empresa_idempresa")
	private int idEmpresa;
	
	@Column(name = "sueldo")
	private String sueldo;

	
	//getters setters
	public long getIdempleadosde() {
		return idempleadosde;
	}


	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}


	@Override
	public String toString() {
		return "empleadode [idempleadosde=" + idempleadosde + ", idPersona=" + idPersona + ", idEmpresa=" + idEmpresa
				+ ", sueldo=" + sueldo + "]";
	}


	public empleadode() {
		super();
	}
	
	

}
