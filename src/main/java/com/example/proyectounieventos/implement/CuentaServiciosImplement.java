package com.example.proyectounieventos.implement;

import com.example.proyectounieventos.dto.cuenta.*;
import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.modelo.vo.CodigoValidacion;
import com.example.proyectounieventos.modelo.vo.EstadoCuenta;
import com.example.proyectounieventos.modelo.vo.Usuario;
import com.example.proyectounieventos.repositorios.CuentaRepo;
import com.example.proyectounieventos.servicios.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service

public class CuentaServiciosImplement implements CuentaServicio {

    @Autowired
    private CuentaRepo cuentaRepository;

    @Override
    public String crearCuenta(CrearCuentaDTO cuentaDTO) throws Exception {
        // Validaciones básicas de los datos
        if (cuentaDTO.cedula() == null || cuentaDTO.cedula().isEmpty()) {
            throw new Exception("La cédula es obligatoria.");
        }
        if (cuentaDTO.email() == null || !cuentaDTO.email().contains("@")) {
            throw new Exception("Correo electrónico inválido.");
        }
        if (cuentaDTO.contrasenia() == null || cuentaDTO.contrasenia().length() < 6) {
            throw new Exception("La contraseña debe tener al menos 6 caracteres.");
        }

        // Crear el objeto Usuario desde los datos proporcionados en cuentaDTO
        // Create the Usuario object
        Usuario usuario = new Usuario();
//
//        usuario.setDireccion(cuentaDTO.direccionResidencia());
//        usuario.setTelefono(cuentaDTO.numeroTelefono());


        // Create EstadoCuenta object
        EstadoCuenta estadoCuenta = new EstadoCuenta();
        estadoCuenta.setActivo(true);
        estadoCuenta.setCambioEstado(new Date());

        // Crear un objeto Cuenta utilizando el patrón Builder
        Cuenta nuevaCuenta = Cuenta.builder()
                .email(cuentaDTO.email())
                 // Hashear la contraseña antes de guardarla// Asumiendo que por defecto es "CLIENTE"
                .fechaRegistro(LocalDateTime.now())  // Registrar la fecha actual
                .usuario(usuario)  // Asociar el objeto Usuario
                .estado(estadoCuenta)  // Asignar el estado inicial de la cuenta
                  // Generar un código de validación
                .build();

        // Guardar la nueva cuenta en la base de datos
        cuentaRepository.save(nuevaCuenta);

        // Retornar un mensaje de éxito
        return "La cuenta ha sido creada exitosamente.";
    }

    @Override
    public String editarCuenta(ActualizarCuentaDTO actualizarCuentaDTO) throws Exception {
        return "";
    }

    // Método auxiliar para hashear la contraseña (usando BCrypt)
    private String hashPassword(String contrasenia) {
        return BCrypt.hashpw(contrasenia, BCrypt.gensalt());
    }

    private CodigoValidacion generarCodigoValidacion(String usuarioId) {
        // Generar un código aleatorio (puedes personalizarlo)
        String codigo = UUID.randomUUID().toString();

        // Fecha de generación (fecha actual)
        Date fechaGeneracion = new Date();

        // Fecha de expiración (por ejemplo, 24 horas después de la generación)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaGeneracion);
        calendar.add(Calendar.HOUR, 24);  // Código válido por 24 horas
        Date fechaExpiracion = calendar.getTime();

        // Crear una nueva instancia de CodigoValidacion
        CodigoValidacion codigoValidacion = new CodigoValidacion();
        codigoValidacion.setCodigo(codigo);
        codigoValidacion.setUsado(false);

        // Retornar el objeto
        return codigoValidacion;
    }

    @Override
    public String eliminarCuenta(String cuentaID) throws Exception {
        return "";
    }

    @Override
    public InformacionCuentaDTO obtenerInformacionCuenta(String cuentaID) throws Exception {
        return null;
    }

    @Override
    public String enviarCodigoRecuperacionPassword(String correo) throws Exception {
        return "";
    }

    @Override
    public String cambiarPassword(CambiarPasswordDTO cambiarPasswordDTO) throws Exception {
        return "";
    }

    @Override
    public String iniciarSesion(LoginDTO loginDTO) throws Exception {
        return "";
    }
}
