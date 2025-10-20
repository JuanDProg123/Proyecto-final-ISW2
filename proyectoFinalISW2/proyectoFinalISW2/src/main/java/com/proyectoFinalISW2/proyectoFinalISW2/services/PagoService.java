package com.proyectoFinalISW2.proyectoFinalISW2.services; // Crea este paquete

import com.proyectoFinalISW2.proyectoFinalISW2.DTO.TarjetaRegistroDTO;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    /**
     * Simula la validación y tokenización de una tarjeta con un proveedor externo.
     * @return El token de pago seguro.
     */
    public String tokenizarTarjeta(TarjetaRegistroDTO tarjetaDTO) {
        
        // 1. Criterio: Formato incorrecto
        if (!validarFormato(tarjetaDTO)) {
            throw new IllegalArgumentException("Error: Formato de tarjeta inválido. Revise número, CVV y fecha.");
        }
        
        // 2. Criterio: Tarjeta vencida
        if (estaVencida(tarjetaDTO.getFechaVencimiento())) {
            throw new IllegalArgumentException("Error: La tarjeta ha expirado. Ingrese una tarjeta vigente.");
        }
        
        // 3. Simulación de la Generación de Token (en un entorno real es una llamada HTTP)
        String ultimos4 = tarjetaDTO.getNumeroTarjeta().substring(tarjetaDTO.getNumeroTarjeta().length() - 4);
        return "tok_sandbox_" + ultimos4 + "_" + System.currentTimeMillis();
    }

    private boolean validarFormato(TarjetaRegistroDTO tarjeta) {
        // Validación básica (13-19 dígitos, 3 o 4 CVV, MM/AA)
        return tarjeta.getNumeroTarjeta() != null && tarjeta.getNumeroTarjeta().matches("^\\d{13,19}$") &&
               tarjeta.getCvv() != null && tarjeta.getCvv().matches("^\\d{3,4}$") &&
               tarjeta.getFechaVencimiento() != null && tarjeta.getFechaVencimiento().matches("^\\d{2}/\\d{2}$");
    }

    private boolean estaVencida(String fechaVencimiento) {
        if (fechaVencimiento == null) return true;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth tarjetaYM = YearMonth.parse(fechaVencimiento, formatter);
            YearMonth hoy = YearMonth.now();

            return tarjetaYM.isBefore(hoy); 
        } catch (DateTimeParseException e) {
            return true; // Si el parseo falla (aunque ya lo valida el regex), se considera inválida.
        }
    }
}