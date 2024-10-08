package com.example.proyectounieventos.modelo.documentos;
import lombok.*;
import org.bson.types.ObjectId;
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

    private ObjectId cuenta;
    //Usuario y contraseñas que quedan asignados en el sistema
    private String usuario;
    private String password;

    @Builder

    public Usuario(String id, ObjectId cuenta, String usuario, String password) {
        this.id = id;
        this.cuenta = cuenta;
        this.usuario = usuario;
        this.password = password;
    }


}
