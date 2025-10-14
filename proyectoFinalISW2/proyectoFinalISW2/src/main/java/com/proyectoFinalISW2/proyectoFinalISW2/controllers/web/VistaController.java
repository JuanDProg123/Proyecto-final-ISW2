package com.proyectoFinalISW2.proyectoFinalISW2.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public record VistaController() {

     @GetMapping("/login")
    public String mostrarLogin() {
        return "Login"; 
    }

     @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro"; 
    }
    
}
