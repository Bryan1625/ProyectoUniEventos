package com.example.proyectounieventos.modelo.vo;

import lombok.Data;

@Data
public class DetalleCompra {
    private String codigoEvento;
    private String nombreLocalidad;
    private int cantidadEntradas;
    private double precioIndividual;
    private double total;

}

