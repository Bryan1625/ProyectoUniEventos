package com.example.proyectounieventos.dto;

import java.util.List;

public record EventoDTO(
        String id,
        String nombre,
        String direccion,
        String ciudad,
        String descripcion,
        String tipoEvento,
        String posterUrl,
        String distribucionLocalidadesUrl,
        List<LocalidadDTO> localidades,
        String fecha
) {}
