package com.example.proyectounieventos.implement;

import com.example.proyectounieventos.dto.TokenDTO;
import com.example.proyectounieventos.dto.cuenta.LoginDTO;
import com.example.proyectounieventos.modelo.documentos.Cuenta;

import com.example.proyectounieventos.modelo.documentos.Usuario;
import com.example.proyectounieventos.repositorios.*;

import com.example.proyectounieventos.servicios.LoginServicio;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LoginServiciosImpl implements LoginServicio {

    @Autowired
    private LoginRepo loginRepo;

    private final String SECRET_KEY = "angular"; // Debes almacenarla en un lugar seguro

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        Optional<Cuenta> cuentaOpt = loginRepo.findByEmail(loginDTO.getEmail());

        if (cuentaOpt.isPresent()) {
            Cuenta cuenta = cuentaOpt.get();

            // Verifica si la contraseña ingresada es correcta
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //Para cifrar contraseñas
            if (passwordEncoder.matches(loginDTO.getPassword(), cuenta.getUsuario().getPassword())) {
                // Generar token JWT
                String token = Jwts.builder()
                        .setSubject(cuenta.getEmail())
                        //.claim("roles", cuenta.getTipoCuenta()) // admin o cliente
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token válido por 1 día
                        .signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes())
                        .compact();

                return new TokenDTO(token);
            }
        }

        // Si las credenciales no son válidas
        return null;
    }
}
