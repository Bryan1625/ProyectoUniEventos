package com.example.proyectounieventos.implement;

import com.example.proyectounieventos.dto.evento.EventoDTO;
import com.example.proyectounieventos.dto.evento.LocalidadDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Localidad;
import com.example.proyectounieventos.servicios.EventoServicios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiciosImplement implements EventoServicios {
    @Override
    public Evento crearEvento(EventoDTO eventoDTO) throws Exception {
        return null;
    }

    @Override
    public String eliminarEvento(String id) throws Exception {
        return null;
    }

    @Override
    public List<EventoDTO> listarEventos() throws Exception {
        return null;
    }

    @Override
    public List<EventoDTO> filtrarEventoPorNombre(String nombre) throws Exception {
        return null;
    }

    @Override
    public Evento obtenerEventoPorId(String id) throws Exception {
        return null;
    }

    @Override
    public List<Evento> obtenerTodosLosEventos() throws Exception {
        return null;
    }

    @Override
    public Evento actualizarEvento(String id, EventoDTO eventoDTO) throws Exception {
        return null;
    }

    @Override
    public List<Localidad> obtenerLocalidadesPorEvento(String eventoId) throws Exception {
        return null;
    }

    @Override
    public Localidad agregarLocalidad(String eventoId, LocalidadDTO localidadDTO) throws Exception {
        return null;
    }
}
