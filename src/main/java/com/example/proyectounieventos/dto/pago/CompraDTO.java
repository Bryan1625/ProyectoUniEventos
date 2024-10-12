package com.example.proyectounieventos.dto.pago;

import java.time.LocalDateTime;

// DTO para la compra
public record CompraDTO(
        String idCompra,      // ID de la compra
        String clienteId,    // ID del cliente que realiza la compra
        String eventoId,     // ID del evento asociado
        String localidad,     // Localidad de la compra
        int cantidadEntradas, // Cantidad de entradas compradas
        double precioTotal,   // Precio total de la compra
        String cuponCodigo,   // Código del cupón utilizado
        LocalDateTime fechaCompra, // Fecha de la compra
        String estadoPago      // Estado del pago (ej. "Pendiente", "Completado")
) {}