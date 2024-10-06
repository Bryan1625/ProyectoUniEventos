package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.vo.Entrada;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Localidad {

    @Id
    private String id;

    private String nombre;

    private double precio;

    private int capacidadMax;

    private List<Entrada> entradaList;

    @Builder
    public Localidad(String id, String nombre, double precio, int capacidadMax,
                     List<Entrada> entradaList) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadMax = capacidadMax;
        this.entradaList = entradaList;
    }
}
