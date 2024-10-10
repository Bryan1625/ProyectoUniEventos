package com.example.proyectounieventos.dto.cupon;

public record ActualizarCuponDTO(
        String idCupon,               // ID del cupón a actualizar
        String nuevoCodigo,           // Nuevo código del cupón
        String nuevaDescripcion,      // Nueva descripción del cupón
        double nuevoDescuento,        // Nuevo valor del descuento
        String nuevaFechaExpiracion    // Nueva fecha de expiración
) {}
