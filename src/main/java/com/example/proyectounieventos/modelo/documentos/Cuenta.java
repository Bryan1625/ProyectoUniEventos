package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.enums.TipoCuenta;
import com.example.proyectounieventos.modelo.vo.CodigoValidacion;
import com.example.proyectounieventos.modelo.vo.EstadoCuenta;
import com.example.proyectounieventos.modelo.vo.Usuario;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "Cuenta")
@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Cuenta {

    @Id
    @EqualsAndHashCode.Include
    //Se utiliza para referenciar en la base de datos
    private String id;
    //datos de una persona
    private String nombre;
    private String email;
    private String cedula;

    //codigo de validacion que se utiliza a la hora del registro
    private CodigoValidacion validacion;
    //se registra la fecha
    private LocalDateTime fechaRegistro;

    //la persona o la cuenta que se esta registrando, crea un usuario
    private Usuario usuario;

    //El estaod de la cuenta se coloca como activo al momento del registro
    private EstadoCuenta estado;

    private TipoCuenta tipoCuenta;

    @Builder

    public Cuenta(String id, String nombre, String email, String cedula,
                  CodigoValidacion validacion, LocalDateTime fechaRegistro,
                  Usuario usuario, EstadoCuenta estado, TipoCuenta tipoCuenta) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
        this.validacion = validacion;
        this.fechaRegistro = fechaRegistro;
        this.usuario = usuario;
        this.estado = estado;
        this.tipoCuenta = tipoCuenta;
    }
}