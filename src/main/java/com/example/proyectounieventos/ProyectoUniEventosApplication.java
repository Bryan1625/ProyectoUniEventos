package com.example.proyectounieventos;

import com.example.proyectounieventos.servicios.impl.CuentaServiciosImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoUniEventosApplication implements CommandLineRunner {

    @Autowired
    private CuentaServiciosImplement cuentaServicios;  // Inyección de la clase de servicios

    public static void main(String[] args) {
        SpringApplication.run(ProyectoUniEventosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Aquí puedes llamar al método enviarCodigo
        String correo = "bryan.gomezm@uqvirtual.edu.co";  // Cambia esto por el correo que deseas probar
        try {
            cuentaServicios.enviarCodigo(correo);
            System.out.println("Código enviado a: " + correo);
        } catch (Exception e) {
            System.err.println("Error al enviar el código: " + e.getMessage());
        }
    }
}

