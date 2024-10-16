package com.example.proyectounieventos.repositorios;

import com.example.proyectounieventos.modelo.documentos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends MongoRepository<Usuario, String> {

    Usuario findByUsuario(String usuario);
}
