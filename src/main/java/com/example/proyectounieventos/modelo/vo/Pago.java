package com.example.proyectounieventos.modelo.vo;

import com.example.proyectounieventos.modelo.enums.EstadoCompra;
import com.example.proyectounieventos.modelo.enums.MetodoPago;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "pago")
public class Pago {
    @Id
    private String id;
    private String codigoPago;
    private double monto;
    private Date fechaPago;
    private MetodoPago metodo;
    private EstadoCompra estado;
}
