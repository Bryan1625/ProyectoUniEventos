package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Carrito;
import com.example.proyectounieventos.repositorios.CarritoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
