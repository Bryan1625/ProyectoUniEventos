package com.example.proyectounieventos.dto.notificaciones;

import java.time.LocalDateTime;

public record NotificacionDTO(
        String id,
        String mensaje,
        LocalDateTime fecha,
        boolean leida
) {}