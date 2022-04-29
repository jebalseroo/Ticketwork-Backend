package com.back_TW.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table (name = "tickets_imprimir")
public class TicketImprimir implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "idticket")
	private long idTicket;
	
	@Column(name = "fecha_solicitud")
	private String fechaSolicitud;	
	
	@Column(name = "fecha_programadaincio")
	private String fechaProgramadaInicio;	
	
	@Column(name = "fecha_inicio")
	private String fechaInicio;	
	
	@Column(name = "fecha_finalizacion")
	private String fechaFinalizacion;
	

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Column(name = "estado")
	private String estado;	
	
	
	@Column (name =  "nombre_cliente")
	private String nombreEmpresaPrestadora;
	
	@Column (name = "nit_cliente")
	private String nitEmpresaPrestadora;
	
	@Column(name = "idservicios")
	private long idServicio;
	
	@Column(name = "nombre")
	private String nombreServicio;
	
	@Column(name = "empresa_prestadora")
	private String nombreEmpresaCliente;
	
	@Column (name = "nit_emp_prestadora")
	private String nitEmpresaCliente;

	@Column (name = "cliente")
	private String nombrePersonaCliente;
	

	@Column (name = "apellidos_c")
	private String apellidoCliente;
	
	@Column(name = "nombre_prest")
	private String nombreOperador;
	
	@Column(name = "apellidos_prest")
	private String apellidoOperador;	
	
	@Column(name = "descripcion")
	private String descirpcionTicket;
	
	
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//Getters setters 
	public long getIdTicket() {
		return idTicket;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public String getFechaProgramadaInicio() {
		return fechaProgramadaInicio;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public String getNombreEmpresaPrestadora() {
		return nombreEmpresaPrestadora;
	}

	public String getNitEmpresaPrestadora() {
		return nitEmpresaPrestadora;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public String getNombreEmpresaCliente() {
		return nombreEmpresaCliente;
	}

	public String getNitEmpresaCliente() {
		return nitEmpresaCliente;
	}

	public String getNombrePersonaCliente() {
		return nombrePersonaCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public String getNombreOperador() {
		return nombreOperador;
	}

	public String getApellidoOperador() {
		return apellidoOperador;
	}

	public String getDescirpcionTicket() {
		return descirpcionTicket;
	}
	public TicketImprimir() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void setIdTicket(long idTicket) {
		this.idTicket = idTicket;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public void setFechaProgramadaInicio(String fechaProgramadaInicio) {
		this.fechaProgramadaInicio = fechaProgramadaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public void setNombreEmpresaPrestadora(String nombreEmpresaPrestadora) {
		this.nombreEmpresaPrestadora = nombreEmpresaPrestadora;
	}
	public void setNitEmpresaPrestadora(String nitEmpresaPrestadora) {
		this.nitEmpresaPrestadora = nitEmpresaPrestadora;
	}
	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public void setNombreEmpresaCliente(String nombreEmpresaCliente) {
		this.nombreEmpresaCliente = nombreEmpresaCliente;
	}
	public void setNitEmpresaCliente(String nitEmpresaCliente) {
		this.nitEmpresaCliente = nitEmpresaCliente;
	}
	public void setNombrePersonaCliente(String nombrePersonaCliente) {
		this.nombrePersonaCliente = nombrePersonaCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
	}
	public void setApellidoOperador(String apellidoOperador) {
		this.apellidoOperador = apellidoOperador;
	}
	public void setDescirpcionTicket(String descirpcionTicket) {
		this.descirpcionTicket = descirpcionTicket;
	}
	@Override
	public String toString() {
		return "TicketImprimir [idTicket=" + idTicket + ", fechaSolicitud=" + fechaSolicitud
				+ ", fechaProgramadaInicio=" + fechaProgramadaInicio + ", fechaInicio=" + fechaInicio
				+ ", fechaFinalizacion=" + fechaFinalizacion + ", estado=" + estado + ", nombreEmpresaPrestadora="
				+ nombreEmpresaPrestadora + ", nitEmpresaPrestadora=" + nitEmpresaPrestadora + ", idServicio="
				+ idServicio + ", nombreServicio=" + nombreServicio + ", nombreEmpresaCliente=" + nombreEmpresaCliente
				+ ", nitEmpresaCliente=" + nitEmpresaCliente + ", nombrePersonaCliente=" + nombrePersonaCliente
				+ ", apellidoCliente=" + apellidoCliente + ", nombreOperador=" + nombreOperador + ", apellidoOperador="
				+ apellidoOperador + ", descirpcionTicket=" + descirpcionTicket + "]";
	}
	
	
	
	

	
	

	
	
		
	
	
	
	
	
}
