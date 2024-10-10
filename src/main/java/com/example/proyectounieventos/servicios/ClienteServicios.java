package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClienteServicios {

    List<Evento> listarEventos(String filtro) throws Exception;

    Compra crearOrdenCompra(DetalleCompra detalleCompra) throws Exception;

    boolean cancelarOrdenCompra(String codigo) throws Exception;

    boolean redimirCupon(String codigoCupon) throws Exception;

    List<Compra> listarCompras()throws Exception;

    boolean cancelarCompras() throws Exception;

    List<Compra>historialCompras(ObjectId idUsuario) throws Exception;

}
