package com.example.proyectounieventos.utils;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailService {

    private final String host = "smtp.gmail.com";  // Cambiar si no usas Gmail
    private final String port = "587";
    private final String username = "santiarco2611@gmail.com";  // Cambia esto por tu correo
    private final String password = "umde efmr mwxs avor";  // Cambia esto por tu contraseña

    public void enviarCorreo(String destinatario, String asunto, String mensaje) throws MessagingException {
        // Configurar las propiedades para la conexión SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.ssl.trust", host);

        // Crear una sesión con autenticación
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Crear el mensaje de correo electrónico
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        msg.setSubject(asunto);
        msg.setText(mensaje);

        // Enviar el mensaje
        Transport.send(msg);
    }
}

