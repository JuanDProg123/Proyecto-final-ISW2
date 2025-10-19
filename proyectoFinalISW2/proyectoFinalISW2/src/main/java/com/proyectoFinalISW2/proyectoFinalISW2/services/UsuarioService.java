package com.proyectoFinalISW2.proyectoFinalISW2.services;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectoFinalISW2.proyectoFinalISW2.models.UsuarioModel;
import com.proyectoFinalISW2.proyectoFinalISW2.repositories.IUsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;
    @Autowired
    EmailService emailService;
    public ArrayList<UsuarioModel> getUsuario() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    public UsuarioModel saveUsuario(UsuarioModel usuario) {
        usuario.setActivo(false);
        usuario.setTokenActivacion(UUID.randomUUID().toString());
        UsuarioModel guardado = usuarioRepository.save(usuario);
        emailService.enviarCorreoConfirmacion(
                guardado.getEmail(),
                guardado.getTokenActivacion()
        );
        return guardado;
    }
    public Optional<UsuarioModel> getById(Long id) {
        return usuarioRepository.findById(id);
    }
    public UsuarioModel updateById(UsuarioModel request, Long id) {
        UsuarioModel usuario = usuarioRepository.findById(id).get();

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(request.getPassword());
        usuario.setSaldo(request.getSaldo());
        usuario.setEstado(request.getEstado());
        usuario.setPuntos_fidelizacion(request.getPuntos_fidelizacion());
        return usuarioRepository.save(usuario);
    }
    public Boolean deleteUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
