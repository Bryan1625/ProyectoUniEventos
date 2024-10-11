package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Carrito;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoRepo extends MongoRepository<Carrito, String> {

    Optional<Carrito> findByIdUsuario(ObjectId idUsuario);

}
