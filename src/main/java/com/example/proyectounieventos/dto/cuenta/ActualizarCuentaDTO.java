package com.example.proyectounieventos.dto.cuenta;

public record ActualizarCuentaDTO(
        String cedula,
        String nombreCompleto,
        String direccionResidencia,
        String numeroTelefono,
        String correoElectronico,
        String contrasenia
) {
}


