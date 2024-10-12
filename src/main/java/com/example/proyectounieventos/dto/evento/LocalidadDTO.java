package com.example.proyectounieventos.dto.evento;

import java.util.List;

public record LocalidadDTO(
        String id,
        String nombre,
        double precio,
        List<EntradaDTO> entradas ,
        String eventoId
) {}
