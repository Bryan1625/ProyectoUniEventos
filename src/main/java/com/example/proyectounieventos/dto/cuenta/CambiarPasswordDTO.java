package com.example.proyectounieventos.dto.cuenta;

public record CambiarPasswordDTO(
        String correoElectronico,
        String nuevaContrasenia,
        String codigoRecuperacion
) {}
