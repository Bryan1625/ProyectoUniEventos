package com.example.proyectounieventos.dto.usuario;

import com.example.proyectounieventos.modelo.documentos.Cuenta;

import java.time.LocalDateTime;

public record UsuarioDTO(
        Cuenta cuenta,
        String usuario,
        String password
) {}