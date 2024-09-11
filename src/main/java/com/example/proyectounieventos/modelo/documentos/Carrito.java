package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.vo.*;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Document("carritos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Carrito {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private ObjectId idUsuario;
    private List<DetalleCompra> items;
    private LocalDateTime fecha;

    @Builder

    public Carrito(ObjectId idUsuario, List<DetalleCompra> items,
                   LocalDateTime fecha) {
        this.idUsuario = idUsuario;
        this.items = items;
        this.fecha = fecha;
    }
}
