package com.example.proyectounieventos.dto.notificaciones;

import java.time.LocalDateTime;

public record RecordatorioDTO(
        String id,
        String mensaje,
        LocalDateTime fechaRecordatorio,
        boolean enviado
) {}