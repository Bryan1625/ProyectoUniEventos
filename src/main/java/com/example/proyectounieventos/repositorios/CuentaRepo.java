package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.modelo.documentos.Cupon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepo extends MongoRepository<Cuenta, String> {

    /////Hace la busqueda del Evento por el ID. Los resultados se ordenan por el campo nombre en orden ascendente
    List<Cuenta> findByIdCuentaOrderByNombreAsc(String idCuenta);
}
