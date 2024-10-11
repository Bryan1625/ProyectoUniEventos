<<<<<<<< HEAD:src/main/java/com/example/proyectounieventos/dto/pago/OrdenCompraDTO.java
package com.example.proyectounieventos.dto.pago;
========
package com.example.proyectounieventos.dto.carrito;
>>>>>>>> 016229f1dcdaed930e54ea0e34ee2bc2a5e83283:src/main/java/com/example/proyectounieventos/dto/carrito/OrdenCompraDTO.java

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