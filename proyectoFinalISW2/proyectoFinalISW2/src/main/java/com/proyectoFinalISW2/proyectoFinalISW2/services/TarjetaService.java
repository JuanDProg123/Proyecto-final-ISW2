package com.proyectoFinalISW2.proyectoFinalISW2.services;

import com.proyectoFinalISW2.proyectoFinalISW2.DTO.TarjetaRegistroDTO;
import com.proyectoFinalISW2.proyectoFinalISW2.models.TarjetaModel;
import com.proyectoFinalISW2.proyectoFinalISW2.models.UsuarioModel;
import com.proyectoFinalISW2.proyectoFinalISW2.repositories.TarjetaRepository;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {

    private final TarjetaRepository tarjetaRepository;
    private final PagoService pagoService;

    // Inyección de dependencias
    public TarjetaService(TarjetaRepository tarjetaRepository, PagoService paymentService) {
        this.tarjetaRepository = tarjetaRepository;
        this.pagoService = paymentService;
    }

    /**
     * Procesa y registra la tarjeta de un usuario de forma segura.
     * @param usuario El usuario al que se le asignará la tarjeta.
     * @param tarjetaDTO Los datos sensibles de la tarjeta.
     * @return La entidad TarjetaModel guardada.
     * @throws IllegalArgumentException Si la tarjeta es inválida o está vencida.
     */
    public TarjetaModel registrarTarjetaSegura(UsuarioModel usuario, TarjetaRegistroDTO tarjetaDTO) {
        
        // Criterio 1: Validación de formato/vigencia (Lanzará excepción si falla)
        String tokenGenerado = pagoService.tokenizarTarjeta(tarjetaDTO);
        
        // 2. Crear la entidad TarjetaModel SÓLO con datos seguros
        TarjetaModel nuevaTarjeta = new TarjetaModel();
        nuevaTarjeta.setTokenPago(tokenGenerado);
        nuevaTarjeta.setNombreTitular(tarjetaDTO.getNombreTitular());
        nuevaTarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
        
        // Guardar los últimos 4 dígitos para visualización al usuario
        String numeroTarjeta = tarjetaDTO.getNumeroTarjeta();
        nuevaTarjeta.setUltimosCuatroDigitos(numeroTarjeta.substring(numeroTarjeta.length() - 4));
        
        // 3. Establecer la relación y guardar
        nuevaTarjeta.setUsuario(usuario);
        usuario.setTarjeta(nuevaTarjeta);
        
        TarjetaModel tarjetaGuardada = tarjetaRepository.save(nuevaTarjeta);

        // Criterio 3: Registro correcto (Se confirma al devolver la entidad guardada)
        return tarjetaGuardada;
    }
}