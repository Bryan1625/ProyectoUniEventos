package com.example.proyectounieventos.modelo.documentos;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Reporte {

    private Evento evento;

    private int porcentajeVendido;

    private double totalGanado;


    public Reporte(Evento evento, int porcentajeVendido, double totalGanado) {
        this.evento = evento;
        this.porcentajeVendido = porcentajeVendido;
        this.totalGanado = totalGanado;
    }
}
