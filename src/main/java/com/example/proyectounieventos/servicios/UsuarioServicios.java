package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.modelo.documentos.Usuario;

public interface UsuarioServicios {
    boolean buscarUsuario(String usuario, String password) throws Exception;
    boolean validarUsuario(Usuario usuario, String password) throws Exception;
}
