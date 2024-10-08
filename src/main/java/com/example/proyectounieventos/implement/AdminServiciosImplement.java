package com.example.proyectounieventos.implement;

import com.example.proyectounieventos.dto.evento.EventoDTO;
import com.example.proyectounieventos.dto.localidad.LocalidadDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Localidad;
import com.example.proyectounieventos.modelo.documentos.Reporte;
import com.example.proyectounieventos.modelo.vo.Cupon;
import com.example.proyectounieventos.servicios.AdminServicios;
import com.example.proyectounieventos.servicios.CuponServicios;
import com.example.proyectounieventos.servicios.EventoServicios;

import java.util.List;

public class AdminServiciosImplement implements AdminServicios, EventoServicios, CuponServicios {


    //METODO PARA GENERAR UN REPORTE

    @Override
    public Reporte generarReporteVentas(String idEvento) throws Exception {
        return null;
    }

    @Override
    public Reporte generarReporte(EventoDTO eventoDTO) throws Exception {
        return null;
    }


    //TAREA DEL ADMINISTRADOR


    @Override
    public void generarPDF() throws Exception {
        //CODIGO PARA GENERAR EL PDF

    }

    @Override
    public void mostrarEnWeb() throws Exception {

        //CODIGO PARA MOSTRAR EN WEB EL REPORTE EN PDF

    }

    //METODO PARA CREAR CUPON

    @Override
    public void crearCupon(Cupon cupon) throws Exception {

    }

    //MEOTODO PARA BUSCARCUPON

    @Override
    public Cupon buscarCupon(String codigo) throws Exception {
        return null;
    }

    //METODO PARA EDITAR CUPON

    @Override
    public boolean editarCupon(Cupon cupon) throws Exception {
        return false;
    }

    //METODO PARA ELIMINAR CUPON POR CODIGO

    @Override
    public boolean eliminarCuponCodigo(String codigoCupon) throws Exception {
        return false;
    }

    //METODO PARA ELIMINAR CUPON POR METODO DE BUSQUEDA CUPON

    @Override
    public boolean eliminarCupon(Cupon cupon) throws Exception {
        return false;
    }


    @Override
    public Evento crearEvento(EventoDTO eventoDTO) throws Exception {
        return null;
    }


    //METODO PARA CREAR EVENTO
    @Override
    public Evento crearEvento(Evento evento) throws Exception {
        return null;
    }

    @Override
    public boolean editarEvento(Evento evento) throws Exception {
        return false;
    }

    //METODO PARA ELIMINAR EVENTO POR ID

    @Override
    public boolean eliminarEventoId(String idEvento) throws Exception {
        return false;
    }

    //METODO PARA ELIMINAR EVENTO POR METODO DE BUSQUEDA EVENTO

    @Override
    public void eliminarEvento(Evento evento) throws Exception {

    }

    @Override
    public void eliminarEvento(String id) throws Exception {

    }

    //LISTAR EVENTOS

    @Override
    public List<EventoDTO> listarEventos() throws Exception {
        return List.of();
    }

    @Override
    public List<EventoDTO> filtrarEventoPorNombre(String nombre) throws Exception {
        return List.of();
    }

    @Override
    public Evento obtenerEventoPorId(String id) throws Exception {
        return null;
    }

    @Override
    public List<Evento> obtenerTodosLosEventos() throws Exception {
        return List.of();
    }

    @Override
    public Evento actualizarEvento(String id, EventoDTO eventoDTO) throws Exception {
        return null;
    }

    @Override
    public List<Localidad> obtenerLocalidadesPorEvento(String eventoId) throws Exception {
        return List.of();
    }

    @Override
    public List<Localidad> obtenerLocalidadesPorEvento(Evento evento) throws Exception {
        return List.of();
    }

    @Override
    public boolean agregarLocalidad(Localidad localidad) throws Exception {
        return false;
    }

    @Override
    public Localidad agregarLocalidad(String eventoId, LocalidadDTO localidadDTO) throws Exception {
        return null;
    }
}
