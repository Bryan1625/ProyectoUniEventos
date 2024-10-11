package com.example.proyectounieventos.dto.cuenta;


import com.example.proyectounieventos.modelo.documentos.Usuario;
import com.example.proyectounieventos.modelo.vo.CodigoValidacion;

import java.time.LocalDateTime;

public record CrearCuentaDTO(
        String cedula,               // Cédula del usuario
        String nombre,               // Nombre del usuario
        String email,                // Correo electrónico
        String contrasenia,          // Contraseña
        LocalDateTime fechaRegistro, // Fecha de registro de la cuenta
        CodigoValidacion codigoValidacion, // Código de validación
        Usuario usuario              // Usuario relacionado
) {}
