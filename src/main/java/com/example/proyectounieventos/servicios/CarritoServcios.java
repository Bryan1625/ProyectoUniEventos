package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.modelo.vo.DetalleCompra;

public interface CarritoServcios {


    void agregarItem (DetalleCompra detalleCompra) throws Exception;

    void eliminarItem (DetalleCompra detalleCompra) throws Exception;

    void vaciarCarrito () throws Exception;

    void verItems () throws Exception;



}
