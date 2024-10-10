package com.example.proyectounieventos.repositorios;


import com.example.proyectounieventos.modelo.vo.Cupon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CuponRepo extends MongoRepository<Cupon, String> {

/*
* MongoRepository = proporciona métodos CRUD
* */
    //Hace la busqueda del cupon por el ID. Los resultados se ordenan por el campo nombre en orden ascendente
    List<Cupon> findByIdCuponOrderByNombreAsc(String idCupon);
}
