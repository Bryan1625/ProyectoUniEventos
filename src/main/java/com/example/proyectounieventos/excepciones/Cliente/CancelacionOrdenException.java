package com.example.proyectounieventos.excepciones.Cliente;

public class CancelacionOrdenException extends RuntimeException{

    public CancelacionOrdenException(String message) {
        super(message);
    }

    public CancelacionOrdenException(String message, Throwable cause) {
        super(message, cause);
    }
}
