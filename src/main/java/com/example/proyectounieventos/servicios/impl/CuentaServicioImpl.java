package com.example.proyectounieventos.servicios.impl;

import com.example.proyectounieventos.dto.*;
import com.example.proyectounieventos.modelo.documentos.Cuenta;
import com.example.proyectounieventos.modelo.vo.*;
import com.example.proyectounieventos.repositorios.*;
import com.example.proyectounieventos.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class CuentaServicioImpl implements CuentaServicio {

    @Autowired
    private CuentaRepo cuentaRepo;
    private UsuarioRepo usuarioRepo;

    @Override
    public String crearCuenta(CrearCuentaDTO cuentaDTO) throws Exception {

        if (cuentaRepo.findByEmail(cuentaDTO.getCorreoElectronico()).isPresent()) {
            throw new IllegalArgumentException("El correo ya está en uso.");
        }

        // Crear la entidad Usuario a partir del DTO
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCedula(cuentaDTO.cedula());
        nuevoUsuario.setNombreCompleto(cuentaDTO.nombreCompleto());
        nuevoUsuario.setDireccion(cuentaDTO.direccionResidencia());
        nuevoUsuario.setTelefono(cuentaDTO.numeroTelefono());
        nuevoUsuario.setCorreoElectronico(cuentaDTO.correoElectronico());
        nuevoUsuario.setContrasenia(cuentaDTO.contrasenia());
        nuevoUsuario.setActivo(true);
        nuevoUsuario.setCuentaVerificada(false);

        // Guardar el Usuario
        usuarioRepo.save(nuevoUsuario);

        // Crear el estado de cuenta inicial
        EstadoCuenta estadoCuenta = new EstadoCuenta();
        estadoCuenta.setUsuarioId(nuevoUsuario.getUsuarioId());
        estadoCuenta.setSaldo(0.0);  // Saldo inicial
        estadoCuenta.setComprasRealizadas(new ArrayList<>());  // Lista vacía de compras
        estadoCuenta.setCuponesDisponibles(new ArrayList<>()); // Lista vacía de cupones

        //Mapeo DTO A Cuenta
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setEmail(cuentaDTO.correoElectronico());
        nuevaCuenta.setContrasenia(cuentaDTO.contrasenia());
        nuevaCuenta.setFechaRegistro(LocalDateTime.now());
        nuevaCuenta.setUsuario(nuevoUsuario);  // Asocia el Usuario con la Cuenta
        nuevaCuenta.setEstado(estadoCuenta);   // Asocia el EstadoCuenta con la Cuenta


        // Guardar la nueva Cuenta
        cuentaRepo.save(nuevaCuenta);


        return "Cuenta creada con exito";
    }

    @Override
    public String editarCuenta(EditarCuentaDTO cuentaDTO) throws Exception {
        return "";
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
