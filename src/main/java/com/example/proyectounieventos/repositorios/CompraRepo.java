package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompraRepo extends MongoRepository<Compra, String> {


}
