package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.vo.Entrada;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Localidad {

    @Id
    private String id;

    private String nombre;

    private double precio;

    private List<Entrada> entradas;
    private String eventoId;

    @Builder
    public Localidad(String id, String nombre, double precio,
                     List<Entrada> entradas) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.entradas = entradas;
    }
}
