package com.example.proyectounieventos.modelo.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EstadoCuenta {
    //private String usuarioId;
    //private double saldo;
    //private List<DetalleCompra> comprasRealizadas;
    //private List<Cupon> cuponesDisponibles;

    private boolean activo;

    private Date cambioEstado;


}