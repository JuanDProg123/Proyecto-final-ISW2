package com.proyectoFinalISW2.proyectoFinalISW2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="BICICLETA")
public class BicicletaModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_Bicicleta;

    private String tipo;

    private String estado;

    private int nivelBateria;

    private String pos_actual;

    private Boolean estadoCandado;

    private String ultimoReporte;

    public Long getId_Bicicleta() {
        return id_Bicicleta;
    }

    public void setId_Bicicleta(Long id_Bicicleta) {
        this.id_Bicicleta = id_Bicicleta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public String getPos_actual() {
        return pos_actual;
    }

    public void setPos_actual(String pos_actual) {
        this.pos_actual = pos_actual;
    }

    public Boolean getEstadoCandado() {
        return estadoCandado;
    }

    public void setEstadoCandado(Boolean estadoCandado) {
        this.estadoCandado = estadoCandado;
    }

    public String getUltimoReporte() {
        return ultimoReporte;
    }

    public void setUltimoReporte(String ultimoReporte) {
        this.ultimoReporte = ultimoReporte;
    }

    
    
}
