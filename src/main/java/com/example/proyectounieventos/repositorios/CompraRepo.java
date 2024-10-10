package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.modelo.enums.EstadoCompra;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository

public interface CompraRepo extends MongoRepository<Compra, String> {

    // Buscar compras entre dos fechas
    List<Compra> findByFechaBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Buscar compras por ID del cliente
    List<Compra> findByIdCliente(String idCliente);


    Optional<Compra> findByCodigo(String codigoOrden);

    List<Compra> findByEstado(EstadoCompra estadoCompra);

    List<Compra> findByCliente(ObjectId idUsuario);
}
