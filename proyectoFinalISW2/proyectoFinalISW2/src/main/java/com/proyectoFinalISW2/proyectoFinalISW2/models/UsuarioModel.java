package com.proyectoFinalISW2.proyectoFinalISW2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    
    private String apellido;

    private String email;

    private String password;

    private int saldo;

    private String estado;

    private int puntos_fidelizacion;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPuntos_fidelizacion() {
        return puntos_fidelizacion;
    }

    public void setPuntos_fidelizacion(int puntos_fidelizacion) {
        this.puntos_fidelizacion = puntos_fidelizacion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





   



    
}
