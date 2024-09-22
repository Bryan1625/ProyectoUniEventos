package com.example.proyectounieventos.controlador;

<<<<<<< HEAD
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.repositorios.EventoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import com.example.proyectounieventos.dto.*;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
>>>>>>> Adriana

@RestController
@RequestMapping("/Evento")
public class EventoController {
<<<<<<< HEAD
    @Autowired
    private EventoRepo eventoRepo;

    @PostMapping
    public ResponseEntity<?> saveEvento(@RequestBody Evento evento){
        try{
            Evento eventoSave=eventoRepo.save(evento);
            return new ResponseEntity<Evento>(eventoSave, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
=======

    @Autowired
    private EventoServicios eventoServicios;  // Interface del servicio de evento

    @PostMapping
    public ResponseEntity<EventoDTO> crearEvento(@RequestBody EventoDTO eventoDTO) {
        try {
            Evento eventoCreado = eventoServicios.crearEvento(eventoDTO);
            EventoDTO response = mapearEventoAEventoDTO(eventoCreado);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> obtenerEventoPorId(@PathVariable String id) throws Exception {
        Evento evento = eventoServicios.obtenerEventoPorId(id);
        if (evento != null) {
            EventoDTO response = mapearEventoAEventoDTO(evento);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EventoDTO>> obtenerTodosLosEventos() throws Exception {
        List<Evento> eventos = eventoServicios.obtenerTodosLosEventos();
        List<EventoDTO> response = eventos.stream()
                .map(this::mapearEventoAEventoDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> actualizarEvento(@PathVariable String id, @RequestBody EventoDTO eventoDTO) {
        try {
            Evento eventoActualizado = eventoServicios.actualizarEvento(id, eventoDTO);
            EventoDTO response = mapearEventoAEventoDTO(eventoActualizado);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvento(@PathVariable String id) {

        try {
            eventoServicios.eliminarEvento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para mapear un Evento a un EventoDTO
    private EventoDTO mapearEventoAEventoDTO(Evento evento) {
        List<LocalidadDTO> localidades = evento.getLocalidades().stream()
                .map(localidad -> new LocalidadDTO(localidad.getNombre(), localidad.getPrecio(), localidad.getCapacidadMaxima()))
                .collect(Collectors.toList());

        return new EventoDTO(
                evento.getEventoId(),
                evento.getNombre(),
                evento.getDireccion(),
                evento.getCiudad(),
                evento.getDescripcion(),
                evento.getTipo(),
                evento.getImagenPortada(),
                evento.getImagenLocalidades(),
                localidades,
                evento.getFecha()
        );
    }
>>>>>>> Adriana
}

