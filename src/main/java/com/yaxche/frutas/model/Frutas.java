package com.yaxche.frutas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="frutas")
public class Frutas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3740770766033022834L;
	@Id
	@Column
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String clave;
	@Column
	private String Nombre;
	@Column
	private float precio;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public Frutas() {

	}
	

/*	
	@Override
	public String toString() {
		return "Frutas [id=" + id + ", clave=" + clave + ", Nombre=" + Nombre + ", precio=" + precio + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frutas other = (Frutas) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		return true;
	}
	*/
	 
	
	
	
	

	

}
