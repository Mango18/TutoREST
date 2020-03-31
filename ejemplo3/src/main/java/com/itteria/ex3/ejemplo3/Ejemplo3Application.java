package com.itteria.ex3.ejemplo3;

import com.itteria.ex3.ejemplo3.model.Equipo;
import com.itteria.ex3.ejemplo3.model.Persona;
import com.itteria.ex3.ejemplo3.repository.EquipoRepository;
import com.itteria.ex3.ejemplo3.repository.PersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Optional;

@SpringBootApplication
public class Ejemplo3Application {
	private static final Logger log = LoggerFactory.getLogger(Ejemplo3Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Ejemplo3Application.class, args);
	}

/*
	@Bean
	public CommandLineRunner demo(PersonaRepository repository, EquipoRepository equipoRepository) {
		return (args) -> {

			for( int i = 0; i < 3;i++) {
				Equipo equipo = new Equipo("Equipo "+ i + " "+Calendar.getInstance().getTime());
				equipoRepository.save(equipo);
				for (int j = 0; j < 4; j++) {
					repository.save(new Persona("Persona "+ j +" del equipo "+equipo.getId(), "Apellidos "+ j, equipo));
				}
			}

		};
	}

*/
	@Bean
	
	
	
	
	
	
	
	public CommandLineRunner buscamosEquipo(EquipoRepository equipoRepository) {
		return (args) -> {
			log.info("buscamosEquipo");

			Optional<Equipo> equipo = equipoRepository.findById( 35L);
			if ( equipo.isPresent()) {
				log.info("Equipo encontrado "+equipo.get());
				log.info("Equipo personas "+equipo.get().getPersonas());
			} else {
				log.info("Equipo NO encontrado ");
			}


			log.info("out buscamosEquipo");
		};
	}

}
