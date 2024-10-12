package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.Token.TokenDTO;
import com.example.proyectounieventos.dto.cuenta.LoginDTO;

public interface LoginServicio {

    TokenDTO login(LoginDTO loginDTO);
}
