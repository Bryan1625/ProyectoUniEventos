package com.example.proyectounieventos.modelo.vo;
import com.example.proyectounieventos.modelo.enums.TipoCuenta;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data

public class Usuario {
    @Id
    private String id;
    private String cedula;
    private String nombreCompleto;
    private String direccion;
    private String telefono;

}
