
package com.example.proyectounieventos.utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailService {

    private final String host = "smtp.gmail.com";
    private final String port = "587";
    private final String username = "santiarco2611@gmail.com";  // Cambia aqui tu correo
    private final String password = "umde efmr mwxs avor";

    public void enviarCorreo(String destinatario, String asunto, String mensaje) throws MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.ssl.trust", host);


        Session session = Session.getInstance(props, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        msg.setSubject(asunto);
        msg.setText(mensaje);

        Transport.send(msg);
    }
}
