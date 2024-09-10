package com.example.proyectounieventos.modelo.documentos;


import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import com.example.proyectounieventos.modelo.vo.Identificador;
import com.example.proyectounieventos.modelo.vo.Pago;
import lombok.*;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Compra {

    private String id;

    private List<DetalleCompra> detalles;
    private ObjectId idCliente;
    private float total;
    private ObjectId idCupon;
    private LocalDateTime fecha;
    private String codigoPasarela;
    private Pago pago;







}
