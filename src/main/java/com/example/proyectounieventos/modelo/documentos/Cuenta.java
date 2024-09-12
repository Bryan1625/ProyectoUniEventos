package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.enums.TipoUsuario;
import com.example.proyectounieventos.modelo.vo.CodigoValidacion;
import com.example.proyectounieventos.modelo.vo.EstadoCuenta;
import com.example.proyectounieventos.modelo.vo.Usuario;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("cuentas")
@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)



public class Cuenta {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private String email;
    private String contrasenia;
    private TipoUsuario tipoUsuario;
    private LocalDateTime fechaRegistro;
    private Usuario usuario;
    private EstadoCuenta estado;

    private CodigoValidacion codigoValidacion;

    @Builder
    public Cuenta(String id, String email, String contrasenia, TipoUsuario tipoUsuario,
                  LocalDateTime fechaRegistro, Usuario usuario, EstadoCuenta estado,
                  CodigoValidacion codigoValidacion) {

        this.id = id;
        this.email = email;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
        this.usuario = usuario;
        this.estado = estado;
        this.codigoValidacion = codigoValidacion;
    }




}
