package com.example.proyectounieventos.modelo.vo;

import com.example.proyectounieventos.modelo.documentos.Evento;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class DetalleCompra {

    private ObjectId evento;
    private ObjectId localidad;
    private int cantidadEntradas;
    private double valorUnitario;
    private double total;

}

