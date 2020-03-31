package com.itteria.ex3.ejemplo3.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	private String nombre;
	private String apellidos;
	private String datonSinValor;

	@ManyToOne //columna de la tabla persona
	@JoinColumn(name="id_equipo", nullable=false)
	//ponemos jsonidentityinfo @JsonManagedReference
	private Equipo equipo;

	public Persona(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Persona() {

	}

	public Persona(String nombre, String apellidos, Equipo equipo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.equipo = equipo;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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


	public String getDatonSinValor() {
		return datonSinValor;
	}

	public void setDatonSinValor(String datonSinValor) {
		this.datonSinValor = datonSinValor;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
}
