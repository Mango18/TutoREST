package com.itteria.ex3.ejemplo3.repository;

import com.itteria.ex3.ejemplo3.model.Equipo;
import com.itteria.ex3.ejemplo3.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Long>
//,PagingAndSortingRepository<Equipo,Long> 
{


	
	
	

	
}

