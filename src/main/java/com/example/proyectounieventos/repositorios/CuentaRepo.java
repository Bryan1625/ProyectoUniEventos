package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CuentaRepo extends MongoRepository<Cuenta, String> {

    Optional<Cuenta> findByEmail(String s);
    Optional<Cuenta> findByCedula(String c);
    
}
