package com.example.proyectounieventos.dto.cuenta;

import com.example.proyectounieventos.dto.usuario.UsuarioDTO;

import java.time.LocalDateTime;

public record CrearCuentaDTO (

        String nombre,
        String cedula,
        String email,
        String codigoValidacion,
        LocalDateTime fecha,
        UsuarioDTO usuario,
        String estado,
        String tipoCuenta

){


}
