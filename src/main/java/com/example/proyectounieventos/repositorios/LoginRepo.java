package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LoginRepo extends MongoRepository<Cuenta, String> {

    Optional<Cuenta> findByEmail(String email);
}
