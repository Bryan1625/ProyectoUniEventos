package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Localidad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepo extends MongoRepository<Localidad, String> {


}
