package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.modelo.vo.DetalleCompra;

import java.util.List;

public interface CarritoServicios {


    void agregarItem (DetalleCompra detalleCompra) throws Exception;

    void eliminarItem (DetalleCompra detalleCompra) throws Exception;

    void vaciarCarrito () throws Exception;

    List<DetalleCompra> verItems () throws Exception;



}
