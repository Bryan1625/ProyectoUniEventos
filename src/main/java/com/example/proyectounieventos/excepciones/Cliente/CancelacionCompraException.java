package com.example.proyectounieventos.excepciones.Cliente;

public class CancelacionCompraException extends RuntimeException {

    public CancelacionCompraException(String message) {
        super(message);
    }

    public CancelacionCompraException(String message, Throwable cause) {
        super(message, cause);
    }
}
