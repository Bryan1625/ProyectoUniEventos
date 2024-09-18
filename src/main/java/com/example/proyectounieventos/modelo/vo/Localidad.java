package com.example.proyectounieventos.modelo.vo;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Localidad {

    private String nombre;

    private double precio;

    private int capacidadMax;

    public Localidad(String nombre, double precio, int capacidadMax) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadMax = capacidadMax;
    }


}
