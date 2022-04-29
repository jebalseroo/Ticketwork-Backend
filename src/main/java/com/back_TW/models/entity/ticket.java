package com.back_TW.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="ticket")
public class ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long  idticket;

	@Column(name = "fecha_solicitud" )
	private String fechaSolicitud;
	
	@Column(name = "fecha_programadaincio" )
	private String fechaProgramadaIniciio;
	
	@Column(name = "fecha_inicio" )
	private String fechaInicio;
	
	@Column(name = "fecha_finalizacion" )
	private String fechaFinal;

	@Column(name = "descripcion" )
	private String descripcion;

	@Column(name = "estado" )
	private String estado;

	@Column(name = "servicios_idservicios" )
	private int servicios_idservicios;
	
	@Column(name = "personas_implicadas_idpersonas_implicadas")
	private long personasImplicadas_idpersonasImplicadas;
	
	
	@Column (name = "empresa_idempresa_cliente")
	private int empresa_idempresaCliente;


	public String getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public String getFechaProgramadaIniciio() {
		return fechaProgramadaIniciio;
	}


	public void setFechaProgramadaIniciio(String fechaProgramadaIniciio) {
		this.fechaProgramadaIniciio = fechaProgramadaIniciio;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getServicios_idservicios() {
		return servicios_idservicios;
	}


	public void setServicios_idservicios(int servicios_idservicios) {
		this.servicios_idservicios = servicios_idservicios;
	}


	public long getPersonasImplicadas_idpersonasImplicadas() {
		return personasImplicadas_idpersonasImplicadas;
	}


	public void setPersonasImplicadas_idpersonasImplicadas(long personasImplicadas_idpersonasImplicadas) {
		this.personasImplicadas_idpersonasImplicadas = personasImplicadas_idpersonasImplicadas;
	}


	public int getEmpresa_idempresaCliente() {
		return empresa_idempresaCliente;
	}


	public void setEmpresa_idempresaCliente(int empresa_idempresaCliente) {
		this.empresa_idempresaCliente = empresa_idempresaCliente;
	}


	public Long getIdticket() {
		return idticket;
	}


	public ticket() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setIdticket(Long idticket) {
		this.idticket = idticket;
	}


	@Override
	public String toString() {
		return "ticket [idticket=" + idticket + ", fechaSolicitud=" + fechaSolicitud + ", fechaProgramadaIniciio="
				+ fechaProgramadaIniciio + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", servicios_idservicios="
				+ servicios_idservicios + ", personasImplicadas_idpersonasImplicadas="
				+ personasImplicadas_idpersonasImplicadas + ", empresa_idempresaCliente=" + empresa_idempresaCliente
				+ "]";
	}
	

	
	
	
	


}
