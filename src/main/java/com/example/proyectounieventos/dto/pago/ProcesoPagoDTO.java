package com.example.proyectounieventos.dto.pago;

public record ProcesoPagoDTO(
        String idCompra,      // ID de la compra asociada
        double montoTotal,    // Monto total a pagar
        String metodoPago     // marcadopago
) {}