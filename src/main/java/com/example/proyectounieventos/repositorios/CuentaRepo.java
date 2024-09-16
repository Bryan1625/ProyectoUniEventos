package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.modelo.documentos.Cupon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CuentaRepo extends MongoRepository<Cuenta, String> {

    /////Hace la busqueda del Evento por el ID. Los resultados se ordenan por el campo nombre en orden ascendente
    List<Cuenta> findByIdCuentaOrderByNombreAsc(String idCuenta);
}
