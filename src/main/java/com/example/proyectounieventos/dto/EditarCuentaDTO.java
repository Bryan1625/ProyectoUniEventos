package com.example.proyectounieventos.dto;

public record EditarCuentaDTO(
        String id,
        String nombreCompleto,
        String direccionResidencia,
        String numeroTelefono,
        String correoElectronico
) {}
