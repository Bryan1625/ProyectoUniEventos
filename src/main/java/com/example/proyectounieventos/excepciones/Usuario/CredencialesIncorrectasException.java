package com.example.proyectounieventos.excepciones.Usuario;

public class CredencialesIncorrectasException extends RuntimeException {
    public CredencialesIncorrectasException(String mensaje) {
        super(mensaje);
    }
}
