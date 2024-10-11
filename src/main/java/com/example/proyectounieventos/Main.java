package com.example.proyectounieventos;

import com.example.proyectounieventos.servicios.impl.CuentaServiciosImplement;

public class Main {
    public static void main(String[] args) {
        try {
            CuentaServiciosImplement cuentaServicios = new CuentaServiciosImplement();
            cuentaServicios.enviarCodigo("cod26bo@gmail.com"); // Reemplaza con un correo real
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}