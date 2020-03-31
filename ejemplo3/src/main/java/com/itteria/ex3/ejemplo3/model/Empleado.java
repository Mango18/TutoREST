package com.itteria.ex3.ejemplo3.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="Empleado")
public class Empleado implements Serializable {

	/**
	 * le podria quitar el "serializable"
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//mirar el campo "unique" de column
	@Column(name="codigoEmpleado")
	public long codigoEmpleado;
	@Column(name = "nombre")
	public String nombre;
	@Column(name = "apellido")
	public String apellido;
	@Column(name = "fechaNacimiento")
	public Date fechaNacimiento;
	
	public Empleado() {
		
	}

	public Empleado(long codigoEmpleado, String nombre, String apellido, Date fechaNacimiento) {
		//super();
		this.codigoEmpleado = codigoEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(long codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Empleado [codigoEmpleado=" + codigoEmpleado + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
}
