package com.example.proyectounieventos.dto.evento;

import com.example.proyectounieventos.modelo.documentos.Ciudad;
import com.example.proyectounieventos.modelo.enums.TipoEvento;

import java.time.LocalDateTime;

public record FiltrarEventoDTO(
        String nombre,
        TipoEvento tipoEvento,
        LocalDateTime fecha,
        Ciudad ciudad
) {}
