package com.example.proyectounieventos.modelo.documentos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "database_sequences")
public class DatabaseSequence {

    //Este se utiliza para generar el id de 1 en 1

    @Id
    private String id;

    private long seq;
}