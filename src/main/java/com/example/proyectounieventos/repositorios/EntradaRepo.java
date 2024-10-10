package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.vo.Entrada;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntradaRepo extends MongoRepository<Entrada, String> {
    Optional<Entrada> findById(String s);
}
