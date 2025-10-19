package com.proyectoFinalISW2.proyectoFinalISW2.controllers.api;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.proyectoFinalISW2.proyectoFinalISW2.models.UsuarioModel;
import com.proyectoFinalISW2.proyectoFinalISW2.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public ArrayList<UsuarioModel> getUsuario() {
        return this.usuarioService.getUsuario();
    }
    @PostMapping
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.saveUsuario(usuario);
    }
    @PostMapping("/form")
    public ResponseEntity<?> saveUsuarioFromForm(@ModelAttribute UsuarioModel usuario) {
        usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok("Usuario registrado desde formulario. Revisa tu correo para activarlo.");
    }
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> getUsuariotById(@PathVariable("id") Long Id) {
        return this.usuarioService.getById(Id);
    }
    @PutMapping(path = "/{id}")
    public UsuarioModel updateUsuariotById(@RequestBody UsuarioModel request, @PathVariable("id") Long id) {
        return this.usuarioService.updateById(request, id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.deleteUsuario(id);
        if (ok) {
            return "Usuario con id " + id + " eliminado";
        } else {
            return "Error al eliminar";
        }
    }
    @GetMapping("/activar/{token}")
    public ResponseEntity<String> activarCuenta(@PathVariable String token) {
        Optional<UsuarioModel> usuarioOpt = usuarioService.getUsuario().stream()
                .filter(u -> token.equals(u.getTokenActivacion()))
                .findFirst();
        if (usuarioOpt.isPresent()) {
            UsuarioModel usuario = usuarioOpt.get();
            usuario.setActivo(true);
            usuario.setTokenActivacion(null);
            usuarioService.saveUsuario(usuario);
            return ResponseEntity.ok("✅ Cuenta activada correctamente. Ya puedes iniciar sesión.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Token inválido o expirado.");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");
        Optional<UsuarioModel> usuarioOpt = usuarioService.getUsuario().stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst();
        if (usuarioOpt.isPresent()) {
            UsuarioModel usuario = usuarioOpt.get();
            if (!usuario.isActivo()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Debes activar tu cuenta desde el correo antes de iniciar sesión.");
            }
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}

