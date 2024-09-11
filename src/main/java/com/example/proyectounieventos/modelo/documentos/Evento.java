package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.enums.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document("eventos")

public class Evento {

    private String id;

    private String nombre;
    private String descripcion;
    private LocalDateTime fecha;
    private TipoEvento tipo;
    private String direccion;
    private String ciudad;
    private List<Localidad> localidades;

    private String imagenPortada;
    private String imagenLocalidades;

    private EstadoEvento estadoEvento;

    @Builder

    public Evento(String id, String nombre, String descripcion, LocalDateTime fecha,
                  TipoEvento tipo, String direccion, String ciudad, List<Localidad> localidades,
                  String imagenPortada, String imagenLocalidades, EstadoEvento estadoEvento) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.localidades = localidades;
        this.imagenPortada = imagenPortada;
        this.imagenLocalidades = imagenLocalidades;
        this.estadoEvento = estadoEvento;

    }
}