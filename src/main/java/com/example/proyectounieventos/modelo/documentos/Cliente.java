package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.vo.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("clientes")
@Getter
@Setter
@NoArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    private String idCliente;

    private String nombre;
    private String cedula;
    private String correo;
    private String direccion;
    private Usuario usuario;
    //cuenta mercadoPago

}
