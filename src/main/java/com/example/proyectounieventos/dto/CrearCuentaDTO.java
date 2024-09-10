package com.example.proyectounieventos.dto;

public record CrearCuentaDTO(
        String cedula,
        String nombreCompleto,
        String direccionResidencia,
        String numeroTelefono,
        String correoElectronico,
        String contrasenia
) {}
