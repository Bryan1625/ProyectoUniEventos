package com.example.proyectounieventos.dto.evento;

import com.example.proyectounieventos.modelo.enums.TipoEvento;
import java.time.LocalDateTime;
import java.util.List;

public record EventoDTO(
        String id,                          // Identificador del evento
        String nombre,                      // Nombre del evento
        String direccion,                   // Dirección del evento
        String ciudad,                      // Ciudad donde se lleva a cabo el evento
        String descripcion,                 // Descripción del evento
        TipoEvento tipoEvento,             // Tipo de evento (puede ser enum)
        String posterUrl,                  // URL del cartel del evento
        String distribucionLocalidadesUrl,  // URL para la distribución de localidades
        List<LocalidadDTO> localidades,    // Lista de localidades asociadas al evento
        LocalDateTime fecha                 // Fecha y hora del evento
) {}
