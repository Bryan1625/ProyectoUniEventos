package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.*;
import com.example.proyectounieventos.repositorios.CuentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface CuentaServicio {


    String crearCuenta (CrearCuentaDTO cuentaDTO) throws Exception;

    String editarCuenta (EditarCuentaDTO cuentaDTO) throws Exception;

    String eliminarCuenta (String cuentaID) throws Exception;

    InformacionCuentaDTO obtenerInformacionCuenta (String cuentaID) throws Exception;

    String enviarCodigoRecuperacionPassword (String correo) throws Exception;

    String cambiarPassword (CambiarPasswordDTO cambiarPasswordDTO) throws Exception;

    String iniciarSesion (LoginDTO loginDTO) throws Exception;



}
