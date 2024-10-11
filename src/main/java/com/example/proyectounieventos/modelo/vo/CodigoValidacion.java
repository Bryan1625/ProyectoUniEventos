package com.example.proyectounieventos.modelo.vo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data

public class CodigoValidacion {

    private ObjectId cliente;         // ID generado por MongoDB
    private String codigo;       // Código de validación
    private boolean usado;       // Estado del código: si ya fue utilizado
    private Date fechaExpiracion;


}