package com.example.proyectounieventos.dto.evento;


import com.example.proyectounieventos.dto.localidad.LocalidadDTO;
import com.example.proyectounieventos.modelo.enums.TipoEvento;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

public record EventoDTO(
        String id,
        String nombre,
        String direccion,
        ObjectId ciudad,
        String descripcion,
        TipoEvento tipoEvento,
        String posterUrl,
        String distribucionLocalidadesUrl,
        List<LocalidadDTO> localidades,
        LocalDateTime fecha
) {}
