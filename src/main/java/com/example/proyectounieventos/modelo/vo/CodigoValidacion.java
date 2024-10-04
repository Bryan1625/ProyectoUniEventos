package com.example.proyectounieventos.modelo.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data

public class CodigoValidacion {
    @Id
    private String id;
    private String codigo;
}