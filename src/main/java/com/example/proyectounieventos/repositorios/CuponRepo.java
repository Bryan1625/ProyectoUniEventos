package com.example.proyectounieventos.repositorios;

<<<<<<< HEAD
import com.example.proyectounieventos.modelo.vo.Cupon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuponRepo extends MongoRepository<Cupon, String> {
=======
import com.example.proyectounieventos.modelo.documentos.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/*
* MongoRepository = proporciona métodos CRUD
* */
public interface CuponRepo extends MongoRepository<Cupon, String> {

    //Hace la busqueda del cupon por el ID. Los resultados se ordenan por el campo nombre en orden ascendente
    List<Cupon> findByIdCuponOrderByNombreAsc(String idCupon);
>>>>>>> 38c2c1b (se edito algunas clases de modelo, repositorios y servicios)
}
