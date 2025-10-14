package com.proyectoFinalISW2.proyectoFinalISW2.controllers.api;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
public ResponseEntity<?> loginUsuario(@RequestBody Map<String, String> loginData) {
    String email = loginData.get("email");
    String password = loginData.get("password"); // igual que el campo en tu entidad

    Optional<UsuarioModel> usuarioOpt = usuarioService.getUsuario().stream()
        .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
        .findFirst();

    if (usuarioOpt.isPresent()) {
        return ResponseEntity.ok(usuarioOpt.get());
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}


   

  
    
}
