package com.example.proyectounieventos.dto;


import com.example.proyectounieventos.modelo.enums.TipoEvento;

import java.time.LocalDateTime;
import java.util.List;

public record EventoDTO(
        String id,
        String nombre,
        String direccion,
        String ciudad,
        String descripcion,
        TipoEvento tipoEvento,
        String posterUrl,
        String distribucionLocalidadesUrl,
        List<LocalidadDTO> localidades,
        LocalDateTime fecha
) {}
