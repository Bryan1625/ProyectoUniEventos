package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventoRepo extends MongoRepository<Evento, String> {

    //Hace la busqueda del Evento por el ID. Los resultados se ordenan por el campo nombre en orden ascendente
    List<Evento> findByIdEventoOrderByNombreAsc(String idEvento);
}
