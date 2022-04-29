package com.back_TW.models.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.back_TW.models.entity.servicios;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
public class empresa implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long  idempresa;
	
	@Column(name = "nombre" )
	private String nombre;
	
	@Column(name = "nit" )
	private String nit;
	
	@Column(name = "correo" )
	private String correo;
	
	@Column(name = "telefono" )
	private int telefono;
	
	@Column(name = "clave" )
	private String clave;
	
	@Column(name = "usuario" )
	private String usuario;
	
	@Column(name = "rol" )
	private String rol;
	

	
//getters and setters 	
	public long getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(long idempresa) {
		this.idempresa = idempresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}


	
// toString	
	@Override
	public String toString() {
		return "empresa [idempresa=" + idempresa + ", nombre=" + nombre + ", nit=" + nit + ", correo1=" + correo
				+ ", telefono=" + telefono + ", clave=" + clave + ", usuario=" + usuario + ", rol=" + rol + "]";
	}


	
	


	
}
