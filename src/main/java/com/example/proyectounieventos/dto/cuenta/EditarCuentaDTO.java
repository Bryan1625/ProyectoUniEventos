package com.example.proyectounieventos.dto.cuenta;

public record EditarCuentaDTO(
        String id,
        String nombreCompleto,
        String direccionResidencia,
        String numeroTelefono,
        String correoElectronico
) {}