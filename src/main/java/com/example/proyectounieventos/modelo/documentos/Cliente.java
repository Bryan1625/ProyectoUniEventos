package com.example.proyectounieventos.modelo.documentos;

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

}
