package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.enums.TipoCuenta;
import com.example.proyectounieventos.modelo.vo.CodigoValidacion;
import com.example.proyectounieventos.modelo.vo.EstadoCuenta;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class Cliente extends Cuenta{
    private String direccion;

    public Cliente(String id, String nombre, String email, String cedula,
                   CodigoValidacion validacion, LocalDateTime fechaRegistro,
                   Usuario usuario, EstadoCuenta estado, TipoCuenta tipoCuenta,
                   String direccion) {
        super(id, nombre, email, cedula, validacion, fechaRegistro, usuario, estado, tipoCuenta);
        this.direccion = direccion;
    }
}
