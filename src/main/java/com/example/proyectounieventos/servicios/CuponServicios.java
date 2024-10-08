package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.modelo.vo.Cupon;

public interface CuponServicios {

    void crearCupon(Cupon cupon)throws Exception;

    Cupon buscarCupon(String codigo)throws Exception;

    boolean editarCupon(Cupon cupon)throws Exception;

    boolean eliminarCuponCodigo(String codigoCupon)throws Exception;

    boolean eliminarCupon (Cupon cupon)throws Exception;
}
