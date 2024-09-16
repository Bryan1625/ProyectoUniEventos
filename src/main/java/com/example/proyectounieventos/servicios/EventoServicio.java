package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.EventoDTO;

public interface EventoServicio {

    String crearEvento(EventoDTO crearEventoDTO) throws Exception;
    String editarEvento(EventoDTO editarEventoDTO) throws Exception;
    String eliminarEvento(EventoDTO eliminarEventoDTO) throws Exception;


}
