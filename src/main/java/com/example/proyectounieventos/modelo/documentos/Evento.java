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
@AllArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Evento {


    @Id
    private String id;



    private String nombre;
    private String direccion;

    private ObjectId Ciudad;
    private String descripcion;
    private TipoEvento tipo;
    private String imagenPortada;
    private String imagenLocalidades;

    private LocalDateTime fecha;






    private EstadoEvento estadoEvento;
    private List<Localidad> localidades;



    public void agregarLocalidad(Localidad nuevaLocalidad) {
        localidades.add(nuevaLocalidad);
    }
}
