package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.enums.EstadoEvento;
import com.example.proyectounieventos.modelo.enums.TipoEvento;
import com.example.proyectounieventos.modelo.vo.Localidad;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("eventos")
@NoArgsConstructor
@Getter
@Setter
@ToString


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
<<<<<<< HEAD
@Document("eventos")
public class Evento {

    @Id
    private String eventoId;
=======

public class Evento {

    @Id
    private String idEvento;
>>>>>>> 38c2c1b (se edito algunas clases de modelo, repositorios y servicios)

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
    public Evento(String eventoId, String nombre, String descripcion, LocalDateTime fecha,
                  TipoEvento tipo, String direccion, String ciudad, List<Localidad> localidades,
                  String imagenPortada, String imagenLocalidades, EstadoEvento estadoEvento) {

<<<<<<< HEAD
        this.eventoId = eventoId;
=======
        this.idEvento = idEvento;
>>>>>>> 38c2c1b (se edito algunas clases de modelo, repositorios y servicios)
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
