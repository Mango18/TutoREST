package com.itteria.ex3.ejemplo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.itteria.ex3.ejemplo3.model.Persona;



@RepositoryRestResource(collectionResourceRel = "lista_personas2", path = "personas2")

public interface PersonaRepository extends JpaRepository<Persona, Long>, 
	PagingAndSortingRepository<Persona,Long> {
	
	
	

	
}

