package com.example.proyectounieventos.controlador;

import com.example.proyectounieventos.modelo.documentos.Usuario;
import com.example.proyectounieventos.repositorios.UsuarioRepo;
import com.example.proyectounieventos.servicios.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        try {
            // Generar un ID secuencial personalizado
            String secuencia = sequenceGeneratorService.generateSequence("usuario_sequence");
            String prefijo = "U"; // Prefijo del ID

            // El ID generado tendrá el formato "U100", "U101", etc.
            String idPersonalizado = prefijo + (100 + Long.parseLong(secuencia));

            // Asignar el ID generado al usuario
            usuario.setId(idPersonalizado);

            // Cifrar la contraseña del usuario antes de almacenarla
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(hashedPassword); // Almacenar la contraseña cifrada

            // Guardar el usuario en la base de datos
            Usuario nuevoUsuario = usuarioRepo.save(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
