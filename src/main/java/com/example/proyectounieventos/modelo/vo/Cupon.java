package com.example.proyectounieventos.modelo.vo;
import com.example.proyectounieventos.modelo.enums.TipoCupon;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "cupon")
public class Cupon {
    @Id
    private String id;
    private String codigo;
    private String nombre;
    private double porcentajeDescuento;
    private Date fechaVencimiento;
    private TipoCupon tipo;
    private boolean activo;

}