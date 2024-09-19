package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Localidad;
import com.example.proyectounieventos.repositorios.LocalidadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Localidad")
public class LocalidadController {
    @Autowired
    private LocalidadRepo localidadRepo;

    @PostMapping
    public ResponseEntity<?> saveLocalidad(@RequestBody Localidad localidad){
        try{
            Localidad localidadSave=localidadRepo.save(localidad);
            return new ResponseEntity<Localidad>(localidadSave, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
