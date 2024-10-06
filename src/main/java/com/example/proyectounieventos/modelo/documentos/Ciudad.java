package com.example.proyectounieventos.modelo.documentos;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Ciudad {

    @Id
    private String id;
    private String nombre;

    private List<Evento> eventoList;

    @Builder
    public Ciudad(String id, String nombre, List<Evento> eventoList) {
        this.id = id;
        this.nombre = nombre;
        this.eventoList = eventoList;
    }

}
