package com.example.proyectounieventos.modelo.vo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "entrada")
public class Entrada {
    @Id
    private String id;
    private String codigoQR;
    private String codigoOrden;
    private String codigoEvento;
    private String localidad;
    private int cantidad;
    private Date fechaCompra;

}