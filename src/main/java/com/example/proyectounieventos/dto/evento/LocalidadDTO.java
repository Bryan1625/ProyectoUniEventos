package com.example.proyectounieventos.dto.evento;

import java.util.List;

public record LocalidadDTO(
        String id,                          // Identificador de la localidad
        String nombre,                      // Nombre de la localidad
        double precio,                      // Precio de la localidad
        List<EntradaDTO> entradas           // Lista de entradas asociadas a la localidad
) {}
