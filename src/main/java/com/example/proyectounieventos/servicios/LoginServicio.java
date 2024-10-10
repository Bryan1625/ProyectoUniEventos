package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.TokenDTO;
import com.example.proyectounieventos.dto.cuenta.LoginDTO;

public interface LoginServicio {

    TokenDTO login(LoginDTO loginDTO);
}
