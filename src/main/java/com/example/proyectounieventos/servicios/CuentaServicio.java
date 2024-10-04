package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.*;

public interface CuentaServicio {

    String crearCuenta (CuentaDTO cuentaDTO) throws Exception;

    String editarCuenta (CuentaDTO cuentaDTO) throws Exception;

    String eliminarCuenta (String cuentaID) throws Exception;

    String eliminarCuenta(CuentaDTO cuentaDTO) throws Exception;

    InformacionCuentaDTO obtenerInformacionCuenta (String cuentaID) throws Exception;

    String enviarCodigoRecuperacionPassword (String correo) throws Exception;

    String cambiarPassword (CambiarPasswordDTO cambiarPasswordDTO) throws Exception;

    String iniciarSesion (LoginDTO loginDTO) throws Exception;



}
