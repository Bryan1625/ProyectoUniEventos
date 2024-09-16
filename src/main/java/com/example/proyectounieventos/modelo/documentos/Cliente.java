package com.example.proyectounieventos.modelo.documentos;

<<<<<<< HEAD
import com.example.proyectounieventos.modelo.enums.TipoUsuario;
import com.example.proyectounieventos.modelo.vo.CodigoValidacion;
import com.example.proyectounieventos.modelo.vo.EstadoCuenta;
import com.example.proyectounieventos.modelo.vo.Usuario;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Cliente extends Cuenta{

    private String direccion;

    private Carrito carrito;

    public Cliente(String id, String email, String contrasenia, TipoUsuario tipoUsuario, LocalDateTime fechaRegistro, Usuario usuario, EstadoCuenta estado, CodigoValidacion codigoValidacion, String direccion, Carrito carrito) {
        super(id, email, contrasenia, tipoUsuario, fechaRegistro, usuario, estado, codigoValidacion);
        this.direccion = direccion;
        this.carrito = carrito;
    }
=======
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
>>>>>>> 38c2c1b (se edito algunas clases de modelo, repositorios y servicios)

}
