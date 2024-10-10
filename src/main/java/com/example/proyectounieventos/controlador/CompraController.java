package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.repositorios.CompraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Compra")


public class CompraController {
    @Autowired
    private CompraRepo compraRepo;

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra){
        try{
            Compra compraSave=compraRepo.save(compra);
            return new ResponseEntity<Compra>(compraSave, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
