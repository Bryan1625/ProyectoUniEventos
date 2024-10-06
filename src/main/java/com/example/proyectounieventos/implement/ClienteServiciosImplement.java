package com.example.proyectounieventos.implement;

import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import com.example.proyectounieventos.servicios.ClienteServicios;

import java.util.List;

public class ClienteServiciosImplement implements ClienteServicios {
    @Override
    public List<Evento> listarEventos(String filtro) throws Exception {
        return List.of();
    }

    @Override
    public Compra crearOrdenCompra(DetalleCompra detalleCompra) throws Exception {
        return null;
    }

    @Override
    public boolean cancelarOrdenCompra(String codigoOrden) throws Exception {
        return false;
    }

    @Override
    public boolean redimirCupon(String codigoCupon) throws Exception {
        return false;
    }

    @Override
    public List<Compra> listarCompras(String idUsuario) throws Exception {
        return List.of();
    }
}
