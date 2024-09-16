package com.example.proyectounieventos.repositorios;

<<<<<<< HEAD
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



    //Listar


=======
import com.example.proyectounieventos.modelo.documentos.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventoRepo extends MongoRepository<Evento, String> {

    //Hace la busqueda del Evento por el ID. Los resultados se ordenan por el campo nombre en orden ascendente
    List<Evento> findByIdEventoOrderByNombreAsc(String idEvento);
>>>>>>> 38c2c1b (se edito algunas clases de modelo, repositorios y servicios)
}
