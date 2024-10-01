package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CompraRepo extends MongoRepository<Compra, String> {


}
