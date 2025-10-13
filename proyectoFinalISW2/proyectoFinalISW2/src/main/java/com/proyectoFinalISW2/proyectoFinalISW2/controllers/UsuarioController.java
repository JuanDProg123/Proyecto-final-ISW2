package com.proyectoFinalISW2.proyectoFinalISW2.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoFinalISW2.proyectoFinalISW2.models.UsuarioModel;
import com.proyectoFinalISW2.proyectoFinalISW2.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

     @GetMapping
    public ArrayList<UsuarioModel> getUsuario(){
        return this.usuarioService.getUsuario();
    }

    @PostMapping
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.saveUsuario(usuario);
    }

    @GetMapping(path="/{id}")
    public Optional <UsuarioModel> getUsuariotById(@PathVariable("id") Long Id  ){
        return this.usuarioService.getById(Id);
    }

    @PutMapping(path="/{id}")
    public UsuarioModel updateUsuariotById (@RequestBody UsuarioModel request,@PathVariable("id") Long id ){
        return this.usuarioService.updateById(request, id);

    }

    @DeleteMapping(path="/{id}")
    public String  deleteById(@PathVariable("id") Long id){
        boolean ok= this.usuarioService.deleteUsuario(id);

        if(ok){
            return "Product with id"+id+" deleted";
        }else{
            return "Error";
        }
        
    }

   

  
    
}
