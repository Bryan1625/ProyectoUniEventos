package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.vo.Cupon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuponRepo extends MongoRepository<Cupon, String> {
}
