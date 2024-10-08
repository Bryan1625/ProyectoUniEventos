package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Carrito;
import com.example.proyectounieventos.repositorios.CarritoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Carrito")
public class CarritoController {
    @Autowired
    private CarritoRepo carritoRepo;

    @PostMapping
    public ResponseEntity<?> saveCarrito(@RequestBody Carrito carrito){
        try{
            Carrito carritoSave=carritoRepo.save(carrito);
            return new ResponseEntity<Carrito>(carritoSave, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Método para eliminar un carrito por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCarrito(@PathVariable("id") String id) {
        try {
            if (carritoRepo.existsById(id)) {
                carritoRepo.deleteById(id);
                return new ResponseEntity<String>("Carrito eliminado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Carrito no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
