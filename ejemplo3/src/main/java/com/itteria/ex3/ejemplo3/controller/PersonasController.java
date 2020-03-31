package com.itteria.ex3.ejemplo3.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.itteria.ex3.ejemplo3.Ejemplo3Application;
import com.itteria.ex3.ejemplo3.model.Equipo;
import com.itteria.ex3.ejemplo3.repository.EquipoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.itteria.ex3.ejemplo3.model.Persona;
import com.itteria.ex3.ejemplo3.repository.PersonaRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo")
public class PersonasController {

	private static final Logger log = LoggerFactory.getLogger(PersonasController.class);


	@Autowired
	private PersonaRepository repositorio;

	@Autowired
	private EquipoRepository equipoRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addPersonaOComoQuiera 
	  (@RequestParam String nombre
	      , @RequestParam String apellidos, 
	      @RequestParam(name = "identificador") long id) {
	    // 
	    Persona n = new Persona();
	    n.setNombre(nombre);
	    n.setApellidos(apellidos);
	    n.setId(id);
	    List<Persona> lista = repositorio.findAll();
	    repositorio.save(n);
	    return "Saved";
	  }
	
	

	@PostMapping(path="/add2") // Map ONLY POST Requests
	  public @ResponseBody String addPersonaOComoQuieraConPost
	  (@RequestBody Persona persona) {
	    // 
	    repositorio.save(persona);
	    return "Saved persona";
	  }
	

	  @GetMapping(path="/getequipo/{id}")
	public @ResponseBody Equipo getEquipoById(@PathVariable("id") Long id){
		  log.info("getEquipoById");

		  Optional<Equipo> equipo = equipoRepository.findById( id);
		  if ( equipo.isPresent()) {
		  	log.info("");
		  	return equipo.get();
			  /*log.info("Equipo encontrado "+equipo.get());
			  log.info("Equipo personas "+equipo.get().getPersonas());
			  */
		  } else {
			  log.info("Equipo NO encontrado ");
		  }


		  log.info("out getEquipoById");
		  return null;

	}

	@GetMapping(path="/getpersona/{id}")
	public @ResponseBody Persona getPersonaById(@PathVariable("id") Long id){
		log.info("getPersonaById");

		Optional<Persona> persona = repositorio.findById( id);
		if ( persona.isPresent()) {
			log.info(" Persona encontrada ");
			log.info( ""+persona.get());
			log.info(" Y con equipo");
			log.info( ""+persona.get().getEquipo());
			return persona.get();
			  /*log.info("Equipo encontrado "+equipo.get());
			  log.info("Equipo personas "+equipo.get().getPersonas());
			  */
		} else {
			log.info("Persona NO encontrada ");
		}


		log.info("out getPersonaById");
		return null;

	}
	///-------
	
	 

	@GetMapping("/")
	    public String index(Model model) {
		 model.addAttribute("equipos", equipoRepository.findAll());
	        return "index";
	        
	        
	    }
	   
	    @GetMapping("/showformequipo")
	    public String showFormEquipo(Equipo equipo) {
	        return "add-equipo";
	    }
	    
	    @PostMapping("/addequipo")
		   public String addEquipo(@Valid Equipo equipo, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-equipo";
	        }
	        equipoRepository.save(equipo);
	        model.addAttribute("equipos",equipoRepository.findAll());
	        return "index";
	    }
	    @GetMapping("/edit/{id}")
	    public String showFormEditEquipo(@PathVariable("id") long id, Model model) {
	        Equipo equipo = equipoRepository.findById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	         
	        model.addAttribute("equipo", equipo);
	        return "index";
	    }
	    
	    
	    
	    @PostMapping("/update/{id}")
	    
	    public String updateEquipo(@PathVariable("id") long id, @Valid 	Equipo equipo, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            equipo.setId(id);
	            return "update-equipo";
	        }
	             
	        equipoRepository.save(equipo);
	        model.addAttribute("users", equipoRepository.findAll());
	        return "index";
	    }
	    
	    @GetMapping("/delete/{id}")
	    public String deleteEquipo(@PathVariable("id") long id, Model model) {
	        Equipo equipo = equipoRepository.findById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid equipo Id:" + id));
	        equipoRepository.delete(equipo);
	        model.addAttribute("equipos", equipoRepository.findAll());
	        return "index";
	        
	    }
	   
	 
	 
	 
	 
	 
	   }

