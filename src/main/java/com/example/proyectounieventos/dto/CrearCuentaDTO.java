package com.example.proyectounieventos.dto;

import java.time.LocalDateTime;

public record CrearCuentaDTO(

        String nombre,
        String email,
        String cedula,
        String codigoVaidacion,
        LocalDateTime fechaRegistro,
        UsuarioDTO usuarioDTO,
        String estadoCuenta,
        String tipoCuenta

) {}
