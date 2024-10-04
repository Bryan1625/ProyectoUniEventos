package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.repositorios.CuentaRepo;
import com.example.proyectounieventos.servicios.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Cuenta")
public class CuentaController {

    @Autowired
    private CuentaRepo cuentaRepo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    // Guardar una nueva cuenta
    @PostMapping
    public ResponseEntity<?> saveCuenta(@RequestBody Cuenta cuenta) {
        try {
            // Generar ID autoincremental
            cuenta.setId(sequenceGeneratorService.generateSequence(Cuenta.class.getSimpleName()));

            Cuenta cuentaSave = cuentaRepo.save(cuenta);
            return new ResponseEntity<>(cuentaSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar cuenta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCuenta(@PathVariable String id) {
        try {
            Optional<Cuenta> cuentaOptional = cuentaRepo.findById(id);
            if (cuentaOptional.isPresent()) {
                cuentaRepo.deleteById(id);
                return new ResponseEntity<>("Cuenta eliminada con éxito", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cuenta no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Buscar cuenta por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCuentaById(@PathVariable String id) {
        try {
            Optional<Cuenta> cuenta = cuentaRepo.findById(id);
            if (cuenta.isPresent()) {
                return new ResponseEntity<>(cuenta.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cuenta no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

