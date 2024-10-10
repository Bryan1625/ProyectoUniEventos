package com.example.proyectounieventos.implement;


import com.example.proyectounieventos.dto.*;
import com.example.proyectounieventos.dto.cuenta.LoginDTO;
import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.repositorios.*;
import com.example.proyectounieventos.servicios.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;


@Service
public class LoginServiciosImpl implements LoginServicio {

    @Autowired
    private CuentaRepo cuentaRepo;


    @Override
    public TokenDTO login(LoginDTO loginDTO) {

        // Busca la cuenta por el correo electrónico
        Optional<Cuenta> cuenta = cuentaRepo.findByEmail(loginDTO.correoElectronico());

        // Valida si la cuenta existe y si la contraseña es correcta---> pero esta es en Usuario
        if (cuenta.isPresent() && cuenta.get().getUsuario().getPassword().equals(loginDTO.correoElectronico())) {
            // Genera un token o retorna uno estático (simulación)
            return new TokenDTO(generarToken("datos validos"));
        }
        return null; // Si no existe o la contraseña es incorrecta
    }



    private String generarToken(String cuenta) {
        return Base64.getEncoder().encodeToString((cuenta.toString() + ":token").getBytes());

    }


}
