package com.example.proyectounieventos.implement;

import com.example.proyectounieventos.dto.cuenta.*;
import com.example.proyectounieventos.modelo.documentos.Cliente;
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
        if (cuentaDTO.cedula() == null || cuentaDTO.cedula().isEmpty()) {
            throw new Exception("La cédula es obligatoria.");
        }
        if (cuentaDTO.email() == null || !cuentaDTO.email().contains("@")) {
            throw new Exception("Correo electrónico inválido.");
        }
        if (cuentaDTO.contrasenia() == null || cuentaDTO.contrasenia().length() < 6) {
            throw new Exception("La contraseña debe tener al menos 6 caracteres.");
        }

        Usuario usuario = new Usuario();
        usuario.setUsuario(cuentaDTO.nombre());
        usuario.setPassword(hashPassword(cuentaDTO.contrasenia()));

        CodigoValidacion codigoValidacion = new CodigoValidacion();
        codigoValidacion.setCodigo(generarCodigoValidacion());
        codigoValidacion.setUsado(false);

        EstadoCuenta estadoCuenta = new EstadoCuenta();
        estadoCuenta.setActivo(true);
        estadoCuenta.setCambioEstado(new Date());

        Cuenta nuevaCuenta = Cuenta.builder()
                .id(UUID.randomUUID().toString())
                .nombre(cuentaDTO.nombre())
                .email(cuentaDTO.email())
                .cedula(cuentaDTO.cedula())
                .validacion(codigoValidacion)
                .fechaRegistro(LocalDateTime.now())
                .usuario(usuario)
                .estado(estadoCuenta)
                .build();

        cuentaRepository.save(nuevaCuenta);
        return "La cuenta ha sido creada exitosamente.";
    }

    @Override
    public String editarCuenta(ActualizarCuentaDTO actualizarCuentaDTO) throws Exception {
        Cuenta cuenta = cuentaRepository.findByCedula(actualizarCuentaDTO.cedula())
                .orElseThrow(() -> new Exception("Cuenta no encontrada."));

        cuenta.setNombre(actualizarCuentaDTO.nombreCompleto());
        cuenta.setEmail(actualizarCuentaDTO.correoElectronico());
        cuenta.setCedula(actualizarCuentaDTO.cedula());
        if(cuenta instanceof Cliente){
            Cliente cliente = (Cliente) cuenta;
            cliente.setDireccion(actualizarCuentaDTO.direccionResidencia());
        }

        cuentaRepository.save(cuenta);
        return "La cuenta ha sido actualizada exitosamente.";
    }

    @Override
    public String eliminarCuenta(String cuentaID) throws Exception {
        Cuenta cuenta = cuentaRepository.findById(cuentaID)
                .orElseThrow(() -> new Exception("Cuenta no encontrada."));
        cuentaRepository.delete(cuenta);
        return "La cuenta ha sido eliminada exitosamente.";
    }

    @Override
    public InformacionCuentaDTO obtenerInformacionCuenta(String cuentaID) throws Exception {
        Cuenta cuenta = cuentaRepository.findById(cuentaID)
                .orElseThrow(() -> new Exception("Cuenta no encontrada."));
        String direccion="";
        if(cuenta instanceof Cliente){
            Cliente cliente = (Cliente) cuenta;
            direccion = cliente.getDireccion();
        }
        return new InformacionCuentaDTO(cuenta.getId(), cuenta.getCedula(), cuenta.getNombre(), direccion, cuenta.getEmail());
    }

    @Override
    public String enviarCodigoRecuperacionPassword(String correo) throws Exception {
        Cuenta cuenta = cuentaRepository.findByEmail(correo)
                .orElseThrow(() -> new Exception("Cuenta no encontrada."));

        CodigoValidacion codigoValidacion = cuenta.getValidacion();
        // Lógica para enviar el código por correo. Aquí puedes implementar la lógica de envío de correos.
        return "El código de recuperación ha sido enviado al correo.";
    }

    @Override
    public String cambiarPassword(CambiarPasswordDTO cambiarPasswordDTO) throws Exception {
        Cuenta cuenta = cuentaRepository.findByEmail(cambiarPasswordDTO.correoElectronico())
                .orElseThrow(() -> new Exception("Cuenta no encontrada."));

        cuenta.getUsuario().setPassword(hashPassword(cambiarPasswordDTO.nuevaContrasenia()));
        cuentaRepository.save(cuenta);
        return "La contraseña ha sido cambiada exitosamente.";
    }

    @Override
    public String iniciarSesion(LoginDTO loginDTO) throws Exception {
        Cuenta cuenta = cuentaRepository.findByEmail(loginDTO.correoElectronico())
                .orElseThrow(() -> new Exception("Credenciales inválidas."));

        if (!BCrypt.checkpw(loginDTO.contrasenia(), cuenta.getUsuario().getPassword())) {
            throw new Exception("Credenciales inválidas.");
        }

        return "Inicio de sesión exitoso.";
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private String generarCodigoValidacion() {
        return UUID.randomUUID().toString();
    }
}
