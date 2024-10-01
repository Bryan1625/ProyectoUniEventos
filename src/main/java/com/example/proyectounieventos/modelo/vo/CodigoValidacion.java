package com.example.proyectounieventos.modelo.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "codigoValidacion")
public class CodigoValidacion {
    @Id
    private String id;
    private String codigo;
    private Date fechaGeneracion;
    private Date fechaExpiracion;
    private String usuarioId;
    private boolean usado;
}