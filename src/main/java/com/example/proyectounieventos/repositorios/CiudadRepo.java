package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Ciudad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends MongoRepository<Ciudad, String> {
}
