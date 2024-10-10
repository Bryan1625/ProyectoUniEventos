package com.example.proyectounieventos.dto.cupon;

public record CuponDTO(
        String idCupon,               // ID único del cupón
        String codigo,                // Código del cupón
        String descripcion,           // Descripción del cupón
        double descuento,             // Valor del descuento
        String fechaExpiracion,       // Fecha de expiración
        boolean activo                // Indica si el cupón está activo
) {}