package com.example.proyectounieventos.dto.evento;

public record EntradaDTO(
        String idEntrada,   // Identificador de la entrada
        int numeroAsiento,  // Número de asiento en la localidad
        boolean disponible   // Estado de disponibilidad de la entrada
) {}
