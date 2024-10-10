package com.example.proyectounieventos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

/*
* Una vez que el usuario se loguea, se devolvera una token
* */
public class TokenDTO {

    private String token;

    public TokenDTO(String token) {
        this.token = token;
    }

}
