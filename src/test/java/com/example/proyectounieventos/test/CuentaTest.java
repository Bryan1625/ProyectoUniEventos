package com.example.proyectounieventos.test;

import com.example.proyectounieventos.dto.CuentaDTO;
import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.modelo.enums.TipoUsuario;
import com.example.proyectounieventos.modelo.vo.EstadoCuenta;
import com.example.proyectounieventos.modelo.vo.Usuario;
import com.example.proyectounieventos.repositorios.CuentaRepo;
import com.example.proyectounieventos.servicios.CuentaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class CuentaTest {

    @Autowired
    private CuentaRepo cuentaRepo;

    @Test
    public void crearCuentaTest() {
        // Crear una nueva cuenta
        Cuenta cuenta = new Cuenta();
        cuenta.setEmail("usuario@example.com");
        //cuenta.setUsuario();
        cuenta.setTipoUsuario(TipoUsuario.CLIENTE);
        //cuenta.setEstado(EstadoCuenta.ACTIVO);

        // Guardar la cuenta en la base de datos
        Cuenta cuentaGuardada = cuentaRepo.save(cuenta);

        // Verificar que la cuenta tiene un ID y fue guardada correctamente
        Assertions.assertNotNull(cuentaGuardada.getCuentaId());
        Assertions.assertEquals("usuario@example.com", cuenta.getEmail());



    }



}


