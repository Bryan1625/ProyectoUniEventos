package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.dto.evento.EntradaDTO;
import com.example.proyectounieventos.dto.evento.LocalidadDTO;
import com.example.proyectounieventos.modelo.documentos.Localidad;
import com.example.proyectounieventos.servicios.EventoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventos/{eventoId}/localidades")
public class LocalidadController {

    @Autowired
    private EventoServicios eventoServicios;  // Servicio para manejar la lógica de eventos y localidades

    @PostMapping
    public ResponseEntity<LocalidadDTO> agregarLocalidad(@PathVariable String eventoId, @RequestBody LocalidadDTO localidadDTO) {
        try {
            Localidad nuevaLocalidad = eventoServicios.agregarLocalidad(eventoId, localidadDTO);
            return new ResponseEntity<>(mapearLocalidadALocalidadDTO(nuevaLocalidad), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<LocalidadDTO>> obtenerLocalidadesPorEvento(@PathVariable String eventoId) {
        try {
            List<Localidad> localidades = eventoServicios.obtenerLocalidadesPorEvento(eventoId);
            List<LocalidadDTO> response = localidades.stream()
                    .map(this::mapearLocalidadALocalidadDTO)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public LocalidadDTO mapearLocalidadALocalidadDTO(Localidad localidad) {
        // Mapeo de entradas de Localidad a EntradaDTO
        List<EntradaDTO> entradaDTOs = localidad.getEntradas().stream()
                .map(entrada -> new EntradaDTO(entrada.getId(), entrada.getNumeroAsiento(), entrada.isDisponible())) // Asumiendo que EntradaDTO tiene estos atributos
                .collect(Collectors.toList());

        return new LocalidadDTO(localidad.getId(), localidad.getNombre(), localidad.getPrecio(), entradaDTOs, localidad.getEventoId());
    }
}

