package com.example.proyectounieventos.modelo.vo;
import com.example.proyectounieventos.modelo.enums.TipoCuenta;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data

public class Usuario {



    private String usuario;
    private String password;

    private String direccion;
    private String telefono;

}
