package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.cuenta.*;
import com.example.proyectounieventos.dto.usuario.CambiarPasswordDTO;


public interface CuentaServicio {


    String crearCuenta (CrearCuentaDTO cuentaDTO) throws Exception;

    String editarCuenta (ActualizarCuentaDTO actualizarCuentaDTO) throws Exception;

    String eliminarCuenta (String cuentaID) throws Exception;

    InformacionCuentaDTO obtenerInformacionCuenta (String cuentaID) throws Exception;

    String enviarCodigoRecuperacionPassword (String correo) throws Exception;

    String cambiarPassword (CambiarPasswordDTO cambiarPasswordDTO) throws Exception;


    void enviarCodigo (String correo)throws Exception;

    String iniciarSesion (LoginDTO loginDTO) throws Exception;



}