package com.example.proyectounieventos.dto.cuenta;

public record RecuperarPasswordDTO(
        String correoElectronico,
        String codigoRecuperacion,
        String nuevaContrasenia
) {}