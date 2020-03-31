package com.itteria.ex3.ejemplo3.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")// probando una historia aqui
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    private String nombre;

    @OneToMany(mappedBy="equipo", fetch = FetchType.EAGER)
    //para jugar con el lAZY
    //ponemos jsonidentityinfo  @JsonBackReference
    private Set<Persona> personas;


    public Equipo(){};

    public Equipo(String nombre) {
        setNombre( nombre);
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

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }
}
