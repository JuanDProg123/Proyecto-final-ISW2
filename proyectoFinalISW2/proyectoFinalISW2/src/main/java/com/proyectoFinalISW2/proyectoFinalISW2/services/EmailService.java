package com.proyectoFinalISW2.proyectoFinalISW2.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${app.url}")
    private String appUrl;
    public void enviarCorreoConfirmacion(String destinatario, String token) {
        String asunto = "Confirma tu cuenta en BicicletasUEB 🚲";
        String linkActivacion = appUrl + "/usuario/activar/" + token;

        String cuerpoHtml = "<!DOCTYPE html>" +
                "<html>" +
                "<body style='font-family: Arial, sans-serif;'>" +
                "<h2 style='color:#2E86C1;'>Bienvenido a BicicletasUEB</h2>" +
                "<p>Gracias por registrarte. Para activar tu cuenta, haz clic en el siguiente botón:</p>" +
                "<a href='" + linkActivacion + "' " +
                "style='display:inline-block;padding:10px 20px;margin-top:10px;" +
                "background-color:#28a745;color:white;text-decoration:none;border-radius:5px;'>" +
                "Activar cuenta</a>" +
                "<p style='margin-top:20px;'>C:</p>" +
                "</body>" +
                "</html>";
        try {
            MimeMessage mensaje = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpoHtml, true); 
            mailSender.send(mensaje);
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar el correo de confirmación", e);
        }
    }
}
