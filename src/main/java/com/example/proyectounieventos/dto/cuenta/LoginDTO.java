package com.example.proyectounieventos.dto.cuenta;


public record LoginDTO(
        String email,
        String password
)
        // Getters y Setters
    {
    public String getEmail() {
        return email;
    }

    public CharSequence getPassword() {
        return password;
    }
}