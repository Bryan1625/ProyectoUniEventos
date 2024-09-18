package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.repositorios.CuentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cuenta")

public class CuentaController {

    @Autowired
    private CuentaRepo cuentaRepo;

    @PostMapping
    public ResponseEntity<?> cuentaSave(@RequestBody Cuenta cuenta){
        try{
            Cuenta cuentaSave= cuentaRepo.save(cuenta);
            return new ResponseEntity<Cuenta>(cuentaSave, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
