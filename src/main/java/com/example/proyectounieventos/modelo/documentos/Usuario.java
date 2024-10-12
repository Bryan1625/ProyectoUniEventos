package com.example.proyectounieventos.modelo.documentos;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Usuario {


    @Id
    private String id;

    private Cuenta cuenta;

    //Usuario y contraseñas que quedan asignados en el sistema
    private String usuario;
    private String password;

    @Builder

    public Usuario(String id, Cuenta cuenta, String usuario, String password) {
        this.id = id;
        this.cuenta = cuenta;
        this.usuario = usuario;
        this.password = password;
    }


}
