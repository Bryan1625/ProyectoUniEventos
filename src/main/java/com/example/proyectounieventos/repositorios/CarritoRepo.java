package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Carrito;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepo extends MongoRepository<Carrito, String> {
}
