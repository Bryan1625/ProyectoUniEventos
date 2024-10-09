package com.example.proyectounieventos.dto;

import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.modelo.enums.TipoCuenta;


public record CuentaDTO(
        String cedula,
        String nombreCompleto,
        String direccionResidencia,
        String numeroTelefono,
        String correoElectronico,
        String contrasenia
) {

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getpasswd() {
        return getpasswd();
    }

    public TipoCuenta getTipoCuenta() {
        return getTipoCuenta();
    }

    public void eliminar (String cedula){



    }
}


