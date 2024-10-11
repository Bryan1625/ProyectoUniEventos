package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.evento.EventoDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Reporte;
import com.example.proyectounieventos.modelo.vo.Cupon;

import java.util.List;

public interface AdminServicios {

    Evento crearEvento(Evento evento) throws Exception;

    boolean editarEvento(Evento evento) throws Exception;

    boolean eliminarEvento(String idEvento) throws Exception;

    List<Evento> listarEventos() throws Exception;

    Cupon crearCupon(Cupon cupon) throws Exception;

    boolean editarCupon(Cupon cupon) throws Exception;

    boolean eliminarCupon(String codigoCupon) throws Exception;

    Reporte generarReporteVentas(String idEvento)throws Exception;

    Reporte generarReporte(EventoDTO eventoDTO)throws Exception;

    void generarPDF () throws Exception;

    void mostrarEnWeb ()throws Exception;


}
