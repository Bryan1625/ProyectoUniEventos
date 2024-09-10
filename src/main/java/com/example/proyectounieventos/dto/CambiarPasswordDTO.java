package com.example.proyectounieventos.dto;

public record CambiarPasswordDTO(
        String correoElectronico,
        String nuevaContrasenia,
        String codigoRecuperacion
) {}
