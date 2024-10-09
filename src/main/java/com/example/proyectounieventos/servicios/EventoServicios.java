package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.EventoDTO;
import com.example.proyectounieventos.dto.LocalidadDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Localidad;

import java.util.List;

public interface EventoServicios {

    Evento crearEvento(EventoDTO eventoDTO)throws Exception;



    String eliminarEvento(String id)throws Exception;

    List<EventoDTO> listarEventos() throws Exception;

    List<EventoDTO> filtrarEventoPorNombre(String nombre)throws Exception;

    Evento obtenerEventoPorId(String id)throws Exception;

    List<Evento> obtenerTodosLosEventos()throws Exception;

    Evento actualizarEvento(String id, EventoDTO eventoDTO)throws Exception;

    List<Localidad> obtenerLocalidadesPorEvento(String eventoId)throws Exception;

    Localidad agregarLocalidad(String eventoId, LocalidadDTO localidadDTO)throws Exception;
}
