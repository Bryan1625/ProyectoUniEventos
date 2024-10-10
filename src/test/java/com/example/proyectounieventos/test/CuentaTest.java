package com.example.proyectounieventos.test;


import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.modelo.enums.TipoCuenta;

import com.example.proyectounieventos.repositorios.CuentaRepo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest
@TestPropertySource(locations = "classpath: application-test.properties")
public class CuentaTest {

    @Autowired
    private CuentaRepo cuentaRepo;

    //private Usuario usuario;

    @Test
    public void crearCuentaTest() {

        try{
        //crear una nueva cuenta
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("juan Torres");
        cuenta.setEmail("admin@evento.com");
        cuenta.setCedula("11100");
        //cuenta.setValidacion();
            cuenta.setFechaRegistro(LocalDateTime.now());
            //cuenta.setUsuario();
            //cuenta.setEstado();
        cuenta.setTipoCuenta(TipoCuenta.ADMIN);



        //Guardar la cuenta en la base de datos
        Cuenta  cuentaGuardada = cuentaRepo.save(cuenta);

        //Verificar que la cuenta tiene un ID y fue guardado correctamente
        Assertions.assertNotNull(cuentaGuardada.getId());
        Assertions.assertEquals("admin@evento.com", cuenta.getEmail());


        /*
        Se espera que si se registra correctamente entonces el servicio
        no debe retornar 0
         */
            Assertions.assertNotEquals(0, cuentaGuardada.getId());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
