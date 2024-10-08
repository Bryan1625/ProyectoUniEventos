package com.example.proyectounieventos.dto.usuario;

public record CambiarPasswordDTO(
        String correoElectronico,
        String nuevaContrasenia,
        String codigoRecuperacion
) {}
