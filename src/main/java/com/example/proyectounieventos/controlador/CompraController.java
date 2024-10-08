package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.repositorios.CompraRepo;
import com.example.proyectounieventos.servicios.SequenceGeneratorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Compra")

public class CompraController {
    @Autowired
    private CompraRepo compraRepo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra){

        try{

            // Generar ID autoincremental
            compra.setId(sequenceGeneratorService.generateSequence(Compra.class.getSimpleName()));

            Compra compraSave=compraRepo.save(compra);
            return new ResponseEntity<Compra>(compraSave, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Eliminar compra por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompra(@PathVariable String id) {
        try {
            Optional<Compra> compraOptional = compraRepo.findById(id);
            if (compraOptional.isPresent()) {
                compraRepo.deleteById(id);
                return new ResponseEntity<>("Compra eliminada con éxito", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Compra no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Buscar compra por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCompraById(@PathVariable String id) {
        try {
            Optional<Compra> compra = compraRepo.findById(id);
            if (compra.isPresent()) {
                return new ResponseEntity<>(compra.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Compra no encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Filtrar compras por fechas
    @GetMapping("/filtrar/fechas")
    public ResponseEntity<?> getComprasByFecha(@RequestParam LocalDateTime fechaInicio, @RequestParam LocalDateTime fechaFin) {
        try {
            List<Compra> compras = compraRepo.findByFechaBetween(fechaInicio, fechaFin);
            if (!compras.isEmpty()) {
                return new ResponseEntity<>(compras, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontraron compras en ese rango de fechas", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Filtrar compras por ID de Cliente
    @GetMapping("/filtrar/cliente/{idCliente}")
    public ResponseEntity<?> getComprasByIdCliente(@PathVariable String idCliente) {
        try {
            List<Compra> compras = compraRepo.findByIdCliente(idCliente);
            if (!compras.isEmpty()) {
                return new ResponseEntity<>(compras, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se encontraron compras para el cliente dado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
