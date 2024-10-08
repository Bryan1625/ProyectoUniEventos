package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.evento.EventoDTO;
import com.example.proyectounieventos.dto.localidad.LocalidadDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Localidad;

import java.util.List;

public interface EventoServicios {

    //CREAR EVENTO Y DTO

    Evento crearEvento(EventoDTO eventoDTO)throws Exception;

    Evento crearEvento (Evento evento)throws Exception;

    //EDITAR EVENTO, ELIMINAR EVENTO POR ID Y POR EVENTO
    boolean editarEvento(Evento evento)throws Exception;
    boolean eliminarEventoId(String idEvento)throws Exception;
    void eliminarEvento (Evento evento)throws Exception;
    void eliminarEvento (String id)throws Exception;

    //LISTAR EVENTO Y FILTRAR

    List<EventoDTO> listarEventos() throws Exception;

    List<EventoDTO> filtrarEventoPorNombre(String nombre)throws Exception;

    //OBTENER EVENTO POR ID

    Evento obtenerEventoPorId(String id)throws Exception;

    List<Evento> obtenerTodosLosEventos()throws Exception;

    Evento actualizarEvento(String id, EventoDTO eventoDTO)throws Exception;

    //OBTENER LOCALIDADES POR EVENTO Y SU ID

    List<Localidad> obtenerLocalidadesPorEvento(String eventoId)throws Exception;
    List<Localidad> obtenerLocalidadesPorEvento(Evento evento)throws Exception;

    //AGREGAR LOCALIDAD

    boolean agregarLocalidad (Localidad localidad)throws Exception;
    Localidad agregarLocalidad(String eventoId, LocalidadDTO localidadDTO)throws Exception;
}
