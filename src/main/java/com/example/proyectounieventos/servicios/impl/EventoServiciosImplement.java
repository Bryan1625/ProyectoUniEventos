package com.example.proyectounieventos.servicios.impl;

import com.example.proyectounieventos.dto.evento.EntradaDTO;
import com.example.proyectounieventos.dto.evento.EventoDTO;
import com.example.proyectounieventos.dto.evento.LocalidadDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Localidad;
import com.example.proyectounieventos.modelo.vo.Entrada;
import com.example.proyectounieventos.repositorios.EntradaRepo;
import com.example.proyectounieventos.repositorios.EventoRepo; // Asegúrate de tener el repositorio correspondiente
import com.example.proyectounieventos.repositorios.LocalidadRepo; // Asegúrate de tener el repositorio correspondiente
import com.example.proyectounieventos.servicios.EventoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoServiciosImplement implements EventoServicios {

    @Autowired
    private EventoRepo eventoRepo; // Repositorio de Evento

    @Autowired
    private LocalidadRepo localidadRepo; // Repositorio de Localidad

    @Autowired
    private EntradaRepo entradaRepo;

    @Override
    public Evento crearEvento(EventoDTO eventoDTO) throws Exception {
        Evento evento = new Evento();
        evento.setNombre(eventoDTO.nombre());
        evento.setDescripcion(eventoDTO.descripcion());
        evento.setFecha(eventoDTO.fecha());
        // Setea otros atributos necesarios
        return eventoRepo.save(evento);
    }

    @Override
    public String eliminarEvento(String id) throws Exception {
        Evento evento = eventoRepo.findById(id).orElseThrow(() -> new Exception("Evento no encontrado."));
        eventoRepo.delete(evento);
        return "Evento eliminado con éxito.";
    }

    @Override
    public List<EventoDTO> listarEventos() throws Exception {
        List<Evento> eventos = eventoRepo.findAll();
        return eventos.stream()
                .map(evento -> new EventoDTO(
                        evento.getId(),
                        evento.getNombre(),
                        evento.getDireccion(),
                        evento.getCiudad(),
                        evento.getDescripcion(),
                        evento.getTipo(),
                        evento.getImagenPortada(),
                        evento.getImagenLocalidades(),
                        evento.getLocalidades().stream() // Mapea las localidades a LocalidadDTO
                                .map(localidad -> new LocalidadDTO(
                                        localidad.getId(),
                                        localidad.getNombre(),
                                        localidad.getPrecio(),
                                        localidad.getEntradas().stream() // Mapea las entradas a EntradaDTO
                                                .map(entrada -> new EntradaDTO(
                                                        entrada.getId(),
                                                        entrada.getNumeroAsiento(),
                                                        entrada.isDisponible()
                                                ))
                                                .collect(Collectors.toList()), // Colecciona la lista de EntradaDTO
                                        localidad.getEventoId()
                                ))
                                .collect(Collectors.toList()), // Colecciona la lista de LocalidadDTO
                        evento.getFecha()
                ))
                .collect(Collectors.toList()); // Colecciona la lista de EventoDTO
    }



    @Override
    public List<EventoDTO> filtrarEventoPorNombre(String nombre) throws Exception {
        List<Evento> eventos = eventoRepo.findByNombreContainingIgnoreCase(nombre);
        return eventos.stream()
                .map(evento -> new EventoDTO(
                        evento.getId(),
                        evento.getNombre(),
                        evento.getDireccion(),
                        evento.getCiudad(),
                        evento.getDescripcion(),
                        evento.getTipo(),
                        evento.getImagenPortada(),
                        evento.getImagenLocalidades(),
                        evento.getLocalidades().stream() // Mapea las localidades a LocalidadDTO
                                .map(localidad -> new LocalidadDTO(
                                        localidad.getId(),
                                        localidad.getNombre(),
                                        localidad.getPrecio(),
                                        localidad.getEntradas().stream() // Mapea las entradas a EntradaDTO
                                                .map(entrada -> new EntradaDTO(
                                                        entrada.getId(),
                                                        entrada.getNumeroAsiento(),
                                                        entrada.isDisponible()
                                                ))
                                                .collect(Collectors.toList()), // Colecciona la lista de EntradaDTO
                                        localidad.getEventoId()
                                ))
                                .collect(Collectors.toList()), // Colecciona la lista de LocalidadDTO
                        evento.getFecha() // Obtén la fecha del evento
                ))
                .collect(Collectors.toList()); // Colecciona la lista de EventoDTO
    }


    @Override
    public Evento obtenerEventoPorId(String id) throws Exception {
        return eventoRepo.findById(id).orElseThrow(() -> new Exception("Evento no encontrado."));
    }

    @Override
    public List<Evento> obtenerTodosLosEventos() throws Exception {
        return eventoRepo.findAll();
    }

    @Override
    public Evento actualizarEvento(String id, EventoDTO eventoDTO) throws Exception {
        Evento eventoExistente = eventoRepo.findById(id).orElseThrow(() -> new Exception("Evento no encontrado."));

        // Actualiza los atributos básicos del evento
        eventoExistente.setNombre(eventoDTO.nombre());
        eventoExistente.setDireccion(eventoDTO.direccion());
        eventoExistente.setCiudad(eventoDTO.ciudad());
        eventoExistente.setDescripcion(eventoDTO.descripcion());
        eventoExistente.setTipo(eventoDTO.tipoEvento());
        eventoExistente.setImagenPortada(eventoDTO.posterUrl());
        eventoExistente.setImagenLocalidades(eventoDTO.distribucionLocalidadesUrl());
        eventoExistente.setFecha(eventoDTO.fecha());

        // Actualiza las localidades asociadas
        List<Localidad> localidadesActualizadas = eventoDTO.localidades().stream()
                .map(localidadDTO -> {
                    Localidad localidadExistente = localidadRepo.findById(localidadDTO.id()).orElseThrow(() -> new RuntimeException("Localidad no encontrada."));

                    // Actualiza los atributos de la localidad
                    localidadExistente.setNombre(localidadDTO.nombre());
                    localidadExistente.setPrecio(localidadDTO.precio());
                    localidadExistente.setEntradas(localidadDTO.entradas().stream()
                            .map(entradaDTO -> {
                                Entrada entradaExistente = entradaRepo.findById(entradaDTO.id()).orElseThrow(() -> new RuntimeException("Entrada no encontrada."));
                                entradaExistente.setNumeroAsiento(entradaDTO.numeroAsiento());
                                entradaExistente.setDisponible(entradaDTO.disponible());
                                return entradaRepo.save(entradaExistente);
                            })
                            .collect(Collectors.toList()));

                    return localidadRepo.save(localidadExistente);
                })
                .collect(Collectors.toList());

        eventoExistente.setLocalidades(localidadesActualizadas);

        return eventoRepo.save(eventoExistente);
    }


    @Override
    public List<Localidad> obtenerLocalidadesPorEvento(String eventoId) throws Exception {
        Evento evento = eventoRepo.findById(eventoId).orElseThrow(() -> new Exception("Evento no encontrado."));
        return localidadRepo.findByEventoId(evento.getId());
    }

    @Override
    public Localidad agregarLocalidad(String eventoId, LocalidadDTO localidadDTO) throws Exception {
        Evento evento = eventoRepo.findById(eventoId).orElseThrow(() -> new Exception("Evento no encontrado."));

        Localidad localidad = new Localidad();
        localidad.setNombre(localidadDTO.nombre());
        localidad.setPrecio(localidadDTO.precio());
        List<Entrada> entradas = localidadDTO.entradas().stream()
                .map(entradaDTO -> {
                    Entrada entrada = new Entrada();
                    entrada.setId(entradaDTO.id());
                    entrada.setNumeroAsiento(entradaDTO.numeroAsiento());
                    entrada.setDisponible(entradaDTO.disponible());
                    return entrada;
                })
                .collect(Collectors.toList());
        localidad.setEntradas(entradas);
        evento.agregarLocalidad(localidad); // Asocia la localidad con el evento

        return localidadRepo.save(localidad);
    }
}
