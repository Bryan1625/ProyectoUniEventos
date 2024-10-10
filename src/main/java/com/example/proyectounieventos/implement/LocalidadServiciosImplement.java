package com.example.proyectounieventos.implement;

import com.example.proyectounieventos.dto.evento.EntradaDTO;
import com.example.proyectounieventos.dto.evento.LocalidadDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Localidad;
import com.example.proyectounieventos.modelo.vo.Entrada;
import com.example.proyectounieventos.repositorios.EventoRepo; // Asegúrate de que esta clase exista
import com.example.proyectounieventos.repositorios.LocalidadRepo; // Asegúrate de que esta clase exista
import com.example.proyectounieventos.servicios.LocalidadServicios;
import com.example.proyectounieventos.servicios.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalidadServiciosImplement implements LocalidadServicios {

    @Autowired
    private LocalidadRepo localidadRepo;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private EventoRepo eventoRepo;

    @Override
    public Localidad agregarLocalidad(String eventoId, LocalidadDTO localidadDTO) throws Exception {
        Evento evento = eventoRepo.findById(eventoId).orElseThrow(() -> new Exception("Evento no encontrado."));

        Localidad nuevaLocalidad = new Localidad();
        nuevaLocalidad.setId(sequenceGeneratorService.generateSequence(Localidad.class.getSimpleName()));
        nuevaLocalidad.setNombre(localidadDTO.nombre());
        nuevaLocalidad.setPrecio(localidadDTO.precio());
        evento.agregarLocalidad(nuevaLocalidad);

        return localidadRepo.save(nuevaLocalidad);
    }

    @Override
    public String eliminarLocalidad(String id) throws Exception {
        Localidad localidad = localidadRepo.findById(id).orElseThrow(() -> new Exception("Localidad no encontrada."));
        localidadRepo.delete(localidad);
        return "Localidad eliminada exitosamente.";
    }

    @Override
    public List<Localidad> listarLocalidades() throws Exception {
        return localidadRepo.findAll();
    }

    @Override
    public Localidad actualizarLocalidad(String id, LocalidadDTO localidadDTO) throws Exception {
        Localidad localidadExistente = localidadRepo.findById(id).orElseThrow(() -> new Exception("Localidad no encontrada."));

        localidadExistente.setNombre(localidadDTO.nombre());
        List<Entrada> entradas = localidadDTO.entradas().stream()
                .map(entradaDTO -> new Entrada(
                        entradaDTO.id(),
                        entradaDTO.numeroAsiento(),
                        entradaDTO.disponible()
                ))
                .collect(Collectors.toList());
        localidadExistente.setEntradas(entradas);
        localidadExistente.setPrecio(localidadDTO.precio());
        localidadExistente.setEventoId(localidadDTO.eventoId());

        return localidadRepo.save(localidadExistente);
    }

    @Override
    public Localidad obtenerLocalidadPorId(String id) throws Exception {
        return localidadRepo.findById(id).orElseThrow(() -> new Exception("Localidad no encontrada."));
    }
}
