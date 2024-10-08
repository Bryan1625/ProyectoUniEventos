package com.example.proyectounieventos.excepciones.Cliente;

public class ComprasNoEncontradasException extends RuntimeException {

    public ComprasNoEncontradasException(String message) {
        super(message);
    }

    public ComprasNoEncontradasException(String message, Throwable cause) {
        super(message, cause);
    }
}
