package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Compra;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface CompraRepo extends MongoRepository<Compra, String> {

    // Buscar compras entre dos fechas
    List<Compra> findByFechaBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Buscar compras por ID del cliente
    List<Compra> findByIdCliente(ObjectId idCliente);


}
