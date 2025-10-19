package com.proyectoFinalISW2.proyectoFinalISW2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoFinalISW2.proyectoFinalISW2.models.UsuarioModel;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    
}
