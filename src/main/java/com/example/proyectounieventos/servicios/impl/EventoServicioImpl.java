package com.example.proyectounieventos.servicios.impl;

import com.example.proyectounieventos.dto.evento.EventoDTO;
import com.example.proyectounieventos.dto.localidad.LocalidadDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Localidad;
import com.example.proyectounieventos.modelo.enums.EstadoEvento;
import com.example.proyectounieventos.repositorios.EventoRepo;
import com.example.proyectounieventos.servicios.EventoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
public class EventoServicioImpl implements EventoServicios {

    @Autowired
    private EventoRepo eventoRepo;

    @Override
    public Evento crearEvento(EventoDTO eventoDTO) {
        Evento evento = mapearDTOAEvento(eventoDTO);
        return eventoRepo.save(evento);
    }

    @Override
    public Evento crearEvento(Evento evento) throws Exception {
        return null;
    }

    @Override
    public boolean editarEvento(Evento evento) throws Exception {
        return false;
    }

    @Override
    public boolean eliminarEventoId(String idEvento) throws Exception {
        return false;
    }

    @Override
    public void eliminarEvento(Evento evento) throws Exception {

    }


    @Override
    public boolean eliminarEvento(String id) throws Exception {
        // Buscar el evento por ID
        Optional<Evento> evento = eventoRepo.findById(id);
        if (evento.isPresent()) {
            eventoRepo.deleteById(id);
            return true;
        } else {
            throw new Exception("Evento no encontrado");
        }

    }

    /*
     * Obtiene todos los eventos del repositorio, los mapea a DTOs y los devuelve
     * */
    @Override
    public List<EventoDTO> listarEventos() throws Exception {
        // Obtener todos los eventos de la base de datos y mapear a DTO
        List<Evento> eventos = eventoRepo.findAll();
        if (!eventos.isEmpty()) {
            return eventos.stream()
                    .map(this::mapearEventoAEventoDTO)
                    .collect(Collectors.toList());
        } else {
            throw new Exception("No se encontraron eventos");
        }
    }

    /*
    * Encuentra eventos, los mapea a DTOs y los devuelve, de lo contrario lanza una excepción
    * */
    @Override
    public List<EventoDTO> filtrarEventoPorNombre(String nombre) throws Exception {
        // Filtrar eventos por nombre usando el repositorio
        List<Evento> eventos = eventoRepo.findByNombreContainingIgnoreCase(nombre);
        if (!eventos.isEmpty()) {
            return eventos.stream()
                    .map(this::mapearEventoAEventoDTO)
                    .collect(Collectors.toList());
        } else {
            throw new Exception("No se encontraron eventos con ese nombre");
        }
    }

    /*
    * Busca un evento por su ID en la base de datos. Si lo encuentra, lo devuelve; si no, lanza una excepción
    * */
    @Override
    public Evento obtenerEventoPorId(String id) throws Exception {
        // Buscar evento por ID
        Optional<Evento> evento = eventoRepo.findById(id);
        if (evento.isPresent()) {
            return evento.get();
        } else {
            throw new Exception("Evento no encontrado");
        }
    }


    /*Devuelve todos los eventos almacenados en la base de datos
    * */
    @Override
    public List<Evento> obtenerTodosLosEventos() throws Exception {
        // Devolver todos los eventos
        List<Evento> eventos = eventoRepo.findAll();
        if (!eventos.isEmpty()) {
            return eventos;
        } else {
            throw new Exception("No se encontraron eventos");
        }
    }

    /*Busca un evento por su ID, si lo encuentra actualiza sus atributos con la información del DTO recibido
    *
    * */
    @Override
    public Evento actualizarEvento(String id, EventoDTO eventoDTO) throws Exception {
        return null;
    }

    @Override
    public List<Localidad> obtenerLocalidadesPorEvento(String eventoId) throws Exception {
        Evento evento = obtenerEventoPorId(eventoId);
        return evento.getLocalidades();
    }

    @Override
    public List<Localidad> obtenerLocalidadesPorEvento(Evento evento) throws Exception {
        return List.of();
    }

    @Override
    public boolean agregarLocalidad(Localidad localidad) throws Exception {
        return false;
    }

    @Override
    public Localidad agregarLocalidad(String eventoId, LocalidadDTO localidadDTO) throws Exception {
        Evento evento = obtenerEventoPorId(eventoId);
        Localidad nuevaLocalidad = new Localidad();
        evento.getLocalidades().add(nuevaLocalidad);
        eventoRepo.save(evento);
        return nuevaLocalidad;
    }



    public Evento mapearDTOAEvento(EventoDTO eventoDTO) {

        List<Localidad> localidades = eventoDTO.localidades().stream()
                .map(this::mapearLocalidadDTOALocalidad)
                .collect(Collectors.toList());

        return new Evento(
        );
    }

    public Localidad mapearLocalidadDTOALocalidad(LocalidadDTO localidadDTO) {
        return null;
    }

    // Método auxiliar para mapear de Evento a EventoDTO
    private EventoDTO mapearEventoAEventoDTO(Evento evento) {
        return null;
    }
}

