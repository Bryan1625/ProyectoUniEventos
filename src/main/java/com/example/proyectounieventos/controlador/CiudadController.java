package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Ciudad;
import com.example.proyectounieventos.repositorios.CiudadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    // Método para buscar una ciudad por nombre
    @GetMapping("/buscarPorNombre")
    public ResponseEntity<?> buscarCiudadPorNombre(@RequestParam("nombre") String nombre) {
        try {
            Optional<Ciudad> ciudad = ciudadRepo.findByNombre(nombre);
            if (ciudad.isPresent()) {
                return new ResponseEntity<Ciudad>(ciudad.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Ciudad no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
