package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.cuenta.CrearCuentaDTO;
import com.example.proyectounieventos.dto.cuenta.CuentaDTO;
import com.example.proyectounieventos.dto.cuenta.InformacionCuentaDTO;
import com.example.proyectounieventos.dto.usuario.CambiarPasswordDTO;
import com.example.proyectounieventos.dto.usuario.UsuarioDTO;

public interface CuentaServicio {

    String crearCuenta (CrearCuentaDTO cuentaDTO) throws Exception;

    String editarCuenta (CuentaDTO cuentaDTO) throws Exception;

    String eliminarCuenta (String cuentaID) throws Exception;

    InformacionCuentaDTO obtenerInformacionCuenta (String cuentaID) throws Exception;

    String enviarCodigoRecuperacionPassword (String correo) throws Exception;

    String cambiarPassword (CambiarPasswordDTO cambiarPasswordDTO) throws Exception;

    String iniciarSesion (UsuarioDTO loginDTO) throws Exception;



}
