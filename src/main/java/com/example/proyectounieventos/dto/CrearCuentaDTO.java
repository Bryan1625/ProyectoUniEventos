package com.example.proyectounieventos.dto;

import com.example.proyectounieventos.modelo.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;



public record CrearCuentaDTO(
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

    public TipoUsuario getTipoUsuario() {
        return getTipoUsuario();
 }
}


