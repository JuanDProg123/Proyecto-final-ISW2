package com.proyectoFinalISW2.proyectoFinalISW2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name="ESTACION")
public class EstacionModel {

    private Long id_estacion;

    private String nombre;

    private String ubicacion;

    private int capacidad;

    private int bicicletasDisponibles;

    private String estado;

    public Long getId_estacion() {
        return id_estacion;
    }

    public void setId_estacion(Long id_estacion) {
        this.id_estacion = id_estacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getBicicletasDisponibles() {
        return bicicletasDisponibles;
    }

    public void setBicicletasDisponibles(int bicicletasDisponibles) {
        this.bicicletasDisponibles = bicicletasDisponibles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
