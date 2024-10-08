package com.example.proyectounieventos.excepciones.Cliente;

public class HistorialComprasNoEncontradoException extends RuntimeException {

    public HistorialComprasNoEncontradoException(String message) {
        super(message);
    }

    public HistorialComprasNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}