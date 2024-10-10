package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepo extends MongoRepository<Cliente, String> {
    Optional<Cliente> findById(String s);
}
