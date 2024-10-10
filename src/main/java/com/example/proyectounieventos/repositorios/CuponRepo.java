package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.vo.Cupon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CuponRepo extends MongoRepository<Cupon, String> {
    Optional<Cupon> findByCodigo(String codigoCupon);
}
