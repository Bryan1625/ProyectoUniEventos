package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.evento.EventoDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Reporte;
import com.example.proyectounieventos.modelo.vo.Cupon;

import java.util.List;

public interface AdminServicios {

    Reporte generarReporteVentas(String idEvento)throws Exception;

    Reporte generarReporte(EventoDTO eventoDTO)throws Exception;

    void generarPDF () throws Exception;

    void mostrarEnWeb ()throws Exception;


}
