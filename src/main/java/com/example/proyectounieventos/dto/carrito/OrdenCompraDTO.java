package com.example.proyectounieventos.dto.carrito;

import java.time.LocalDateTime;

public record OrdenCompraDTO(
        String codigoOrden,
        String clienteId,
        String eventoId,
        String localidad,
        int cantidadEntradas,
        double precioTotal,
        String cuponCodigo,
        LocalDateTime fechaCompra,
        String estadoPago
) {}