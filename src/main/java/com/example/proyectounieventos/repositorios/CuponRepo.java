package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/*
* MongoRepository = proporciona métodos CRUD
* */
public interface CuponRepo extends MongoRepository<Cupon, String> {

    //Hace la busqueda del cupon por el ID. Los resultados se ordenan por el campo nombre en orden ascendente
    List<Cupon> findByIdCuponOrderByNombreAsc(String idCupon);
}
