package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* MongoRepository = proporciona métodos CRUD
* */
@Repository
public interface CuponRepo extends MongoRepository<Cupon, String> {

    //CRUD

    //Hace la busqueda del cupon por el ID. Los resultados se ordenan por el campo nombre en orden ascendente
    List<Cupon> findByIdCuponOrderByNombreAsc(String idCupon);
}
