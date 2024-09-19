package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.repositorios.EventoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Evento")
public class EventoController {
    @Autowired
    private EventoRepo eventoRepo;

    @PostMapping
    public ResponseEntity<?> saveEvento(@RequestBody Evento evento){
        try{
            Evento eventoSave=eventoRepo.save(evento);
            return new ResponseEntity<Evento>(eventoSave, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
