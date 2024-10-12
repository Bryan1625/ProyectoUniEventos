package com.example.proyectounieventos.modelo.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class EstadoCuenta {


    private boolean activo;

    private Date cambioEstado;


}