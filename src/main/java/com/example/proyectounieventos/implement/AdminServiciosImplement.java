package com.example.proyectounieventos.implement;

import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Reporte;
import com.example.proyectounieventos.modelo.vo.Cupon;
import com.example.proyectounieventos.servicios.AdminServicios;

import java.util.List;

public class AdminServiciosImplement implements AdminServicios {
    @Override
    public Evento crearEvento(Evento evento) throws Exception {
        return null;
    }

    @Override
    public boolean editarEvento(Evento evento) throws Exception {
        return false;
    }

    @Override
    public boolean eliminarEvento(String idEvento) throws Exception {
        return false;
    }

    @Override
    public List<Evento> listarEventos() throws Exception {
        return List.of();
    }

    @Override
    public Cupon crearCupon(Cupon cupon) throws Exception {
        return null;
    }

    @Override
    public boolean editarCupon(Cupon cupon) throws Exception {
        return false;
    }

    @Override
    public boolean eliminarCupon(String codigoCupon) throws Exception {
        return false;
    }

    @Override
    public Reporte generarReporteVentas(String idEvento) throws Exception {
        return null;
    }
}
