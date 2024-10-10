package com.example.proyectounieventos.repositorios;


import com.example.proyectounieventos.modelo.documentos.Localidad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepo extends MongoRepository<Localidad, String> {

    List<Localidad> findByEventoId(String eventoId);

}