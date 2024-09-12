package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EventoRepo extends MongoRepository<Evento, String> {

    @Query("{ 'nombre': { $regex: ?0, $options: 'i' } }")
    Page<Evento> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

}
