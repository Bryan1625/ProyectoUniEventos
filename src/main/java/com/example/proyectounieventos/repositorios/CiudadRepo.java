package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Ciudad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CiudadRepo extends MongoRepository<Ciudad, String> {

    // Método para buscar una ciudad por su nombre
    Optional<Ciudad> findByNombre(String nombre);
}
