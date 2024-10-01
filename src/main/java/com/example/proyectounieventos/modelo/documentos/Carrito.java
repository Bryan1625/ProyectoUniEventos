package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import com.example.proyectounieventos.modelo.vo.Identificador;
import lombok.*;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Carrito {

    private String id;

    private ObjectId idUsuario;
    private List<DetalleCompra> items;
    private LocalDateTime fecha;

    @Builder

    public Carrito(String id, ObjectId idUsuario, List<DetalleCompra> items,
                   LocalDateTime fecha) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.items = items;
        this.fecha = fecha;
    }
}
