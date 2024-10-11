package com.example.proyectounieventos.servicios.impl;

import com.example.proyectounieventos.dto.evento.EventoDTO;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.documentos.Reporte;
import com.example.proyectounieventos.modelo.vo.Cupon;
import com.example.proyectounieventos.repositorios.EventoRepo;
import com.example.proyectounieventos.repositorios.CuponRepo;
import com.example.proyectounieventos.servicios.AdminServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiciosImplement implements AdminServicios {

    @Autowired
    private EventoRepo eventoRepository;

    @Autowired
    private CuponRepo cuponRepository;

    @Override
    public Evento crearEvento(Evento evento) throws Exception {
        if (eventoRepository.existsById(evento.getId())) {
            throw new Exception("El evento ya existe.");
        }
        return eventoRepository.save(evento);
    }

    @Override
    public boolean editarEvento(Evento evento) throws Exception {
        Evento existingEvento = eventoRepository.findById(evento.getId())
                .orElseThrow(() -> new Exception("Evento no encontrado."));
        existingEvento.setNombre(evento.getNombre());
        existingEvento.setDescripcion(evento.getDescripcion());
        existingEvento.setFecha(evento.getFecha());
        existingEvento.setDireccion(evento.getDireccion());
        existingEvento.setEstadoEvento(evento.getEstadoEvento());
        existingEvento.setCiudad(evento.getCiudad());
        existingEvento.setImagenLocalidades(evento.getImagenLocalidades());
        existingEvento.setImagenPortada(evento.getImagenPortada());
        existingEvento.setLocalidades(evento.getLocalidades());
        existingEvento.setTipo(evento.getTipo());
        eventoRepository.save(existingEvento);
        return true;
    }

    @Override
    public boolean eliminarEvento(String idEvento) throws Exception {
        Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(() -> new Exception("Evento no encontrado."));
        eventoRepository.delete(evento);
        return true;
    }

    @Override
    public List<Evento> listarEventos() throws Exception {
        return eventoRepository.findAll();
    }

    @Override
    public Cupon crearCupon(Cupon cupon) throws Exception {
        if (cuponRepository.existsById(cupon.getCodigo())) {
            throw new Exception("El cupón ya existe.");
        }
        return cuponRepository.save(cupon);
    }

    @Override
    public boolean editarCupon(Cupon cupon) throws Exception {
        Cupon existingCupon = cuponRepository.findById(cupon.getCodigo())
                .orElseThrow(() -> new Exception("Cupón no encontrado."));
        existingCupon.setPorcentajeDescuento(cupon.getPorcentajeDescuento());
        existingCupon.setFechaVencimiento(cupon.getFechaVencimiento());
        cuponRepository.save(existingCupon);
        return true;
    }

    @Override
    public boolean eliminarCupon(String codigoCupon) throws Exception {
        Cupon cupon = cuponRepository.findById(codigoCupon)
                .orElseThrow(() -> new Exception("Cupón no encontrado."));
        cuponRepository.delete(cupon);
        return true;
    }

    @Override
    public Reporte generarReporteVentas(String idEvento) throws Exception {
        // Lógica para generar el reporte de ventas para el evento específico
        Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(() -> new Exception("Evento no encontrado."));

        // Implementar lógica para recolectar datos de ventas relacionados con el evento
        Reporte reporte = new Reporte();
        reporte.setEvento(evento);
        // Aquí se deberían calcular las ventas, total, etc. y agregarlo al reporte
        // Ejemplo:
        // double totalVentas = calcularTotalVentasPorEvento(evento);
        // reporte.setTotalVentas(totalVentas);

        return reporte;
    }

    @Override
    public Reporte generarReporte(EventoDTO eventoDTO) throws Exception {
        return null;
    }

    @Override
    public void generarPDF() throws Exception{}
        //METODO PARA GENERAR EL PDF DEL REPORTE

    @Override
    public void mostrarEnWeb() throws Exception {

    }
}
