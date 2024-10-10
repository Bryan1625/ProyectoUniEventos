package com.example.proyectounieventos.dto.cuenta;

public record InformacionCuentaDTO(
        String id,
        String cedula,
        String nombreCompleto,
        String direccionResidencia,
        String correoElectronico
) {}