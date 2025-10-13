package com.proyectoFinalISW2.proyectoFinalISW2.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoFinalISW2.proyectoFinalISW2.models.UsuarioModel;
import com.proyectoFinalISW2.proyectoFinalISW2.repositories.IUsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    IUsuarioRepository usuarioRepository;


    public ArrayList<UsuarioModel> getUsuario(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel saveUsuario(UsuarioModel usuario){ 
        return usuarioRepository.save(usuario); 
    
    }

    public Optional<UsuarioModel> getById(Long id){
         return usuarioRepository.findById(id); } 

    public UsuarioModel updateById (UsuarioModel request, Long id){
        
        UsuarioModel usuario= usuarioRepository.findById(id).get();
         
        usuario.setNombre(request.getNombre()); 
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setTelefono(request.getTelefono());
        usuario.setRol(request.getRol());

        
        return usuarioRepository.save(usuario);
     } 


     public Boolean deleteUsuario (Long id){
         try { usuarioRepository.deleteById(id);
             return true; 
            } catch (Exception e) {
                 return false; } 
    } 


     


    
}
