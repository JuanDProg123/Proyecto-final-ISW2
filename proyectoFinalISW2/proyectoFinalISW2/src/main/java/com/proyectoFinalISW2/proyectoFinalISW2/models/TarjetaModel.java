package com.proyectoFinalISW2.proyectoFinalISW2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tarjeta")
public class TarjetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarjeta;

    private String tokenPago; 
    private String ultimosCuatroDigitos; 
    private String fechaVencimiento; 
    private String nombreTitular;
    
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario")
    private UsuarioModel usuario;

    // Getters y Setters
    public Long getIdTarjeta() { return idTarjeta; }
    public void setIdTarjeta(Long idTarjeta) { this.idTarjeta = idTarjeta; }
    public String getTokenPago() { return tokenPago; }
    public void setTokenPago(String tokenPago) { this.tokenPago = tokenPago; }
    public String getUltimosCuatroDigitos() { return ultimosCuatroDigitos; }
    public void setUltimosCuatroDigitos(String ultimosCuatroDigitos) { this.ultimosCuatroDigitos = ultimosCuatroDigitos; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public String getNombreTitular() { return nombreTitular; }
    public void setNombreTitular(String nombreTitular) { this.nombreTitular = nombreTitular; }
    public UsuarioModel getUsuario() { return usuario; }
    public void setUsuario(UsuarioModel usuario) { this.usuario = usuario; }
}