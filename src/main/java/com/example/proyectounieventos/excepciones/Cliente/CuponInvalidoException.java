package com.example.proyectounieventos.excepciones.Cliente;


public class CuponInvalidoException extends RuntimeException {

    public CuponInvalidoException(String message) {
        super(message);
    }

    public CuponInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
