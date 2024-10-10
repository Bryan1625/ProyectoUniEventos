package com.example.proyectounieventos.dto.reporte;

import java.time.LocalDateTime;

public record ReporteAuditoriaDTO(
        String id,               // ID del reporte
        String usuarioId,        // ID del usuario que realizó la acción
        String accion,           // Descripción de la acción realizada
        LocalDateTime fechaHora, // Fecha y hora de la acción
        String detalle            // Detalle adicional sobre la acción
) {}