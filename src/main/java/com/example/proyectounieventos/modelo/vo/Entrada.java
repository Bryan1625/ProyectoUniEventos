package com.example.proyectounieventos.modelo.vo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Data
@Document(collection = "entrada")
public class Entrada {
    @Id
    private String id;
    private int numeroAsiento;
    private boolean disponible;


}