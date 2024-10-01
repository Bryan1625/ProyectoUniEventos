package com.example.proyectounieventos.dto;

public record InformacionCuentaDTO(
        String id,
        String cedula,
        String nombreCompleto,
        String direccionResidencia,
        String numeroTelefono,
        String correoElectronico
) {}