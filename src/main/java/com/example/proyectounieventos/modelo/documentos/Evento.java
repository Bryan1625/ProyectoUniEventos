package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.enums.EstadoEvento;
import com.example.proyectounieventos.modelo.enums.TipoEvento;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Evento {


    @Id
    private String id;

    private ObjectId Ciudad;

    private String nombre;
    private String descripcion;
    private String direccion;

    private LocalDateTime fecha;
    private TipoEvento tipo;


    private String imagenPortada;
    private String imagenLocalidades;

    private EstadoEvento estadoEvento;
    private List<Localidad> localidades;

    @Builder

    public Evento(String id, ObjectId ciudad, String nombre, String descripcion,
                  String direccion, LocalDateTime fecha, TipoEvento tipo, String imagenPortada,
                  String imagenLocalidades, EstadoEvento estadoEvento, List<Localidad> localidades) {
        this.id = id;
        Ciudad = ciudad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.imagenPortada = imagenPortada;
        this.imagenLocalidades = imagenLocalidades;
        this.estadoEvento = estadoEvento;
        this.localidades = localidades;
    }
}
