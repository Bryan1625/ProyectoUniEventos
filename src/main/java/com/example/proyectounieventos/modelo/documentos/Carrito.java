package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import com.example.proyectounieventos.modelo.vo.Identificador;
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

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "Carrito")

public class Carrito {

    @Id
    private String id;

    //Relacion con el Usuario
    private ObjectId idUsuario;

    private List<Compra> items;

    @Builder
    public Carrito(String id, ObjectId idUsuario, List<Compra> items) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.items = items;
    }

}
