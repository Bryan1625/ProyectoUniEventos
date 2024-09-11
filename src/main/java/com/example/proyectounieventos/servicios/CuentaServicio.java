package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.*;

public interface CuentaServicio {

    String crearCuenta (CrearCuentaDTO cuentaDTO) throws Exception;

    String editarCuenta (EditarCuentaDTO cuentaDTO) throws Exception;

    String eliminarCuenta (String cuentaID) throws Exception;

    InformacionCuentaDTO obtenerInformacionCuenta (String cuentaID) throws Exception;

    String enviarCodigoRecuperacionPassword (String correo) throws Exception;

    String cambiarPassword (CambiarPasswordDTO cambiarPasswordDTO) throws Exception;

    String iniciarSesion (LoginDTO loginDTO) throws Exception;



}
