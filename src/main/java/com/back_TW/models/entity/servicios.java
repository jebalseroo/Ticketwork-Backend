package com.back_TW.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="servicios")
public class servicios implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long  idservicios;
	
	@Column(name = "descripcion" )
	private String descripcion;
	
	@Column(name = "nombre" )
	private String nombre;
	

	@Column(name = "empresa_idempresa")
	private int empres;
	
	

//getters setters	
	
	public long getIdservicios() {
		return idservicios;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	

	public int getEmpres() {
		return empres;
	}

	public void setEmpres(long l) {
		this.empres = (int) l;
	}

	@Override
	public String toString() 
	{
		return "servicios{" +
				"idservicios=" + idservicios +
				", descripcion='" + descripcion + '\'' +
				", nombre='" + nombre + '\'' +
				", empresa='" + empres + '\'' +
				'}';
	}




//constructrorer
	public servicios(long idservicios, String descripcion, String nombre, int empres) 
	{
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.empres = empres;
	}


	public servicios() {
		super();
	}
	
	

}
