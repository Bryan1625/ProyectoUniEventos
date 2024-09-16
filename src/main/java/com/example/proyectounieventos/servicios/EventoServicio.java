package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.EventoDTO;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

=======
>>>>>>> 38c2c1b (se edito algunas clases de modelo, repositorios y servicios)

public interface EventoServicio {

    String crearEvento(EventoDTO crearEventoDTO) throws Exception;
    String editarEvento(EventoDTO editarEventoDTO) throws Exception;
    String eliminarEvento(EventoDTO eliminarEventoDTO) throws Exception;


}
