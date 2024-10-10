package com.example.proyectounieventos.modelo.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class DatabaseSequence {
    //Este se utiliza para generar el id de 1 en 1
    @Id
    private String id;
    private long seq;
}