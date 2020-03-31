package com.itteria.ex3.ejemplo3.TestEmpleado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;



public class TestEmpleado {
	//puede que pete por aqui
	@PersistenceContext(name = "persistencia")
	private static EntityManager manager;
	//entityManager para hacer cualidades de CRUD
	
	public static void main(String[] args) {
		//@PersistenceUnit(unitName = "nombre unidad");
		//manager.
	//manager.createQuery("FROM Equipo");
	}

}
