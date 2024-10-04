package com.example.proyectounieventos.modelo.vo;
import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.modelo.enums.TipoCuenta;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data

public class Usuario {

    //Usuario y contraseñas que quedan asignados en el sistema
    private Cuenta cuenta;

    private String usuario;
    private String password;

    //direccion y telefono, que se le agrega a la cuenta



}
