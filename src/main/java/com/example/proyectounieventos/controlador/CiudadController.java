package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Ciudad;
import com.example.proyectounieventos.repositorios.CiudadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ciudad")
public class CiudadController {
    @Autowired
    private CiudadRepo ciudadRepo;

    @PostMapping
    public ResponseEntity<?> saveCiudad(@RequestBody Ciudad ciudad){
        try{
            Ciudad ciudadSave=ciudadRepo.save(ciudad);
            return new ResponseEntity<Ciudad>(ciudadSave, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
