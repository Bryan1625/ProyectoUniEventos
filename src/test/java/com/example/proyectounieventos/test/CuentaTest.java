package com.example.proyectounieventos.test;


import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.modelo.enums.TipoUsuario;
import com.example.proyectounieventos.modelo.vo.CodigoValidacion;
import com.example.proyectounieventos.modelo.vo.Usuario;
import com.example.proyectounieventos.repositorios.CuentaRepo;
import com.example.proyectounieventos.modelo.*;
import com.example.proyectounieventos.repositorios.UsuarioRepo;
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
        cuenta.setEmail("admin@evento.com");
        //cuenta.setUsuario();
        cuenta.setTipoUsuario(TipoUsuario.ADMIN);
        //cuenta.setEstado();
        //cuenta.setCodigoValidacion();
        cuenta.setContrasenia("admin01");
        cuenta.setFechaRegistro(LocalDateTime.now());

        //Guardar la cuenta en la base de datos
        Cuenta  cuentaGuardada = cuentaRepo.save(cuenta);

        //Verificar que la cuenta tiene un ID y fue guardado correctamente
        Assertions.assertNotNull(cuentaGuardada.getCuentaId());
        Assertions.assertEquals("admin@evento.com", cuenta.getEmail());


        /*
        Se espera que si se registra correctamente entonces el servicio
        no debe retornar 0
         */
            Assertions.assertNotEquals(0, cuentaGuardada.getCuentaId());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
