package com.example.proyectounieventos.dto.cupon;

public record CrearCuponDTO(
        String codigo,                // Código del cupón
        String descripcion,           // Descripción del cupón
        double descuento,             // Valor del descuento
        String fechaExpiracion        // Fecha de expiración
) {}