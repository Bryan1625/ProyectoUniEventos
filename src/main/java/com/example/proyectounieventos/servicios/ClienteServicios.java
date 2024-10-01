package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.vo.DetalleCompra;

import java.util.List;

public interface ClienteServicios {

    List<Evento> listarEventos(String filtro) throws Exception;

    Compra crearOrdenCompra(DetalleCompra detalleCompra) throws Exception;

    boolean cancelarOrdenCompra(String codigoOrden) throws Exception;

    boolean redimirCupon(String codigoCupon) throws Exception;

    List<Compra> listarCompras(String idUsuario)throws Exception;

}
