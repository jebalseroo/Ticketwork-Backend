package com.back_TW.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class personas implements Serializable {

	
	public personas() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long  idpersonas;
	@Column(name = "nombre" )
	private String nombre;
	@Column(name = "apellidos" )
	private String apellidos;
	@Column(name = "clave" )
	private String clave;
	@Column(name = "cedula" )
	private String cedula;
	@Column(name = "usuario" )
	private String usuario;
	@Column(name = "rol" )
	private String rol;
	@Column(name = "correo" )
	private String correo;
	
	
	
	
	@Override
	public String toString() {
		return "personas [idpersonas=" + idpersonas + ", nombre=" + nombre + ", apellidos=" + apellidos + ", clave="
				+ clave + ", cedula=" + cedula + ", usuario=" + usuario + ", rol=" + rol + ", correo=" + correo + "]";
	}
	
	
	public long getIdpersonas() {
		return idpersonas;
	}
	public void setIdpersonas(long idpersonas) {
		this.idpersonas = idpersonas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
}
