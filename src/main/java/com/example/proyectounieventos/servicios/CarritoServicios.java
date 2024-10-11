package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import org.bson.types.ObjectId;

import java.util.List;

public interface CarritoServicios {


    void agregarItem (DetalleCompra detalleCompra, ObjectId idUsuario) throws Exception;

   void actualizarValorTotal(ObjectId idCliente) throws Exception;

    void eliminarItem (DetalleCompra detalleCompra) throws Exception;

    void vaciarCarrito () throws Exception;

    List<DetalleCompra> verItems(ObjectId idCliente) throws Exception;



}
