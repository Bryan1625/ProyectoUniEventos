package com.example.proyectounieventos.modelo.documentos;


import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import com.example.proyectounieventos.modelo.vo.Identificador;
import com.example.proyectounieventos.modelo.vo.Pago;
import com.mongodb.client.model.Collation;
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

@Document(collection = "Compra")

public class Compra {

    @Id
    private String id;  // Cambiado a long para autoincremento

    private List<DetalleCompra> detalles;
    private float valorTotal;
    private ObjectId idCupon;
    private LocalDateTime fecha;




}
