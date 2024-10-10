package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepo extends MongoRepository<Evento, String> {

    @Query("{ 'nombre': { $regex: ?0, $options: 'i' } }")
    List<Evento> findByNombreContainingIgnoreCase(String nombre);

    List<Evento> findByNombreContaining(String filtro);


    //Listar


}
