package com.proyectoFinalISW2.proyectoFinalISW2.repositories;

import com.proyectoFinalISW2.proyectoFinalISW2.models.TarjetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<TarjetaModel, Long> {

    TarjetaModel findByUltimosCuatroDigitos(String ultimosCuatroDigitos);
    
    TarjetaModel findByUsuario_IdUsuario(Long idUsuario);
}