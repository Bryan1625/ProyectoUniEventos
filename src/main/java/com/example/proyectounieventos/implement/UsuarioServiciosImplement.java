package com.example.proyectounieventos.implement;

import com.example.proyectounieventos.excepciones.Usuario.CredencialesIncorrectasException;
import com.example.proyectounieventos.excepciones.Usuario.UsuarioNoEncontradoException;
import com.example.proyectounieventos.modelo.documentos.Usuario;
import com.example.proyectounieventos.repositorios.UsuarioRepo;
import com.example.proyectounieventos.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiciosImplement implements UsuarioServicios {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public boolean buscarUsuario(String nombreUsuario, String password) throws Exception {
        Usuario usuarioEncontrado = usuarioRepo.findByUsuario(nombreUsuario);
        if (usuarioEncontrado == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado: " + nombreUsuario);
        }
        return validarUsuario(usuarioEncontrado, password);
    }

    @Override
    public boolean validarUsuario(Usuario usuario, String password) throws Exception {
        if (!usuario.getPassword().equals(password)) {
            throw new CredencialesIncorrectasException("Contraseña incorrecta para el usuario: " + usuario.getUsuario());
        }
        return true;
    }
}
