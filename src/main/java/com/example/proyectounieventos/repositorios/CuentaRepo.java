package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Cuenta;
<<<<<<< HEAD
import com.example.proyectounieventos.modelo.enums.TipoUsuario;
import com.example.proyectounieventos.modelo.vo.EstadoCuenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepo extends MongoRepository<Cuenta, String> {

    // Método para buscar una cuenta por el correo electrónico
    Optional<Cuenta> findByEmail(String email);

    // Método para buscar una cuenta por el ID del usuario
    //Optional<Cuenta> findByUsuariocuentaId(String usuarioId);

    // Método para buscar cuentas por tipo de usuario
    List<Cuenta> findByTipoUsuario(TipoUsuario tipoUsuario);

    // Método para buscar cuentas por estado de cuenta
    List<Cuenta> findByEstado(EstadoCuenta estado);

=======
import com.example.proyectounieventos.modelo.documentos.Cupon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CuentaRepo extends MongoRepository<Cuenta, String> {

    /////Hace la busqueda del Evento por el ID. Los resultados se ordenan por el campo nombre en orden ascendente
    List<Cuenta> findByIdCuentaOrderByNombreAsc(String idCuenta);
>>>>>>> 38c2c1b (se edito algunas clases de modelo, repositorios y servicios)
}
