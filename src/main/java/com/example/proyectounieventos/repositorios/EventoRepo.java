package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventoRepo extends MongoRepository<Evento, String> {
}
