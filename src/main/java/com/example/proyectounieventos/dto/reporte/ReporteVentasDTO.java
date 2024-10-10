package com.example.proyectounieventos.dto.reporte;

import java.time.LocalDateTime;

public record ReporteVentasDTO(
        String id,               // ID del reporte
        String eventoId,         // ID del evento relacionado
        LocalDateTime fechaInicio, // Fecha de inicio del periodo del reporte
        LocalDateTime fechaFin,   // Fecha de fin del periodo del reporte
        int totalEntradasVendidas, // Total de entradas vendidas en el periodo
        double ingresosTotales,   // Ingresos totales generados en el periodo
        String cuponUtilizado     // Código del cupón utilizado, si aplica
) {}