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
    private String id;

    private String nombre;
    private String email;
    private String cedula;
    private CodigoValidacion validacion;

    private LocalDateTime fechaRegistro;

    private Usuario usuario;
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
