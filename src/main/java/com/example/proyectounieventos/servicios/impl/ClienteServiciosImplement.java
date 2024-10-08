package com.example.proyectounieventos.servicios.impl;

import com.example.proyectounieventos.excepciones.Cliente.*;
import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.enums.EstadoCompra;
import com.example.proyectounieventos.modelo.enums.EstadoCupon;
import com.example.proyectounieventos.modelo.vo.Cupon;
import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import com.example.proyectounieventos.repositorios.CompraRepo;
import com.example.proyectounieventos.repositorios.CuponRepo;
import com.example.proyectounieventos.repositorios.EventoRepo;
import com.example.proyectounieventos.servicios.ClienteServicios;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class ClienteServiciosImplement implements ClienteServicios {

    @Autowired
    private EventoRepo eventoRepo;

    @Autowired
    private CompraRepo compraRepo;

    @Autowired
    private CuponRepo cuponRepo;

    //
    @Override
    public List<Evento> listarEventos(String filtro) throws Exception {
        try {
            if (filtro == null || filtro.isEmpty()) {
                return eventoRepo.findAll();  // Lista todos los eventos si no hay filtro
            } else {
                return eventoRepo.findByNombreContaining(filtro);  // Busca por nombre similar
            }
        } catch (Exception e) {
            throw new Exception("Error al listar eventos: " + e.getMessage());
        }
    }
    //

    @Override
    public Compra crearOrdenCompra(DetalleCompra detalleCompra) throws Exception {
        try {
            Compra compra = new Compra();
            compra.setCodigo(UUID.randomUUID().toString());  // Generar código único
            compra.setDetalles(List.of(detalleCompra));
            compra.setValorTotal((float) detalleCompra.getTotal());
            compra.setFecha(LocalDateTime.now());
            compra.setEstado(EstadoCompra.PENDIENTE);  // Iniciar con estado "Pendiente"

            return compraRepo.save(compra);  // Guardar la compra en la base de datos
        } catch (Exception e) {
            throw new Exception("Error al crear la orden de compra: " + e.getMessage());
        }
    }
    //
    @Override
    public boolean cancelarOrdenCompra(String codigoOrden) throws Exception {
        try {
            Optional<Compra> compraOpt = compraRepo.findByCodigo(codigoOrden);
            if (compraOpt.isPresent()) {
                Compra compra = compraOpt.get();

                // Solo se puede cancelar si el estado es "PENDIENTE"
                if (compra.getEstado() == EstadoCompra.PENDIENTE) {
                    compra.setEstado(EstadoCompra.CANCELADA);
                    compraRepo.save(compra);  // Guardar la compra con estado actualizado
                    return true;
                } else {
                    // Lanza excepción si el estado no es "PENDIENTE"
                    throw new CancelacionOrdenException("La orden de compra no se puede cancelar porque ya ha sido " +
                            "procesada o cancelada. Estado actual: " + compra.getEstado());
                }
            } else {
                // Lanza excepción si no se encuentra la compra con el código proporcionado
                throw new CancelacionOrdenException("No se encontró ninguna orden de compra con el código: " + codigoOrden);
            }
        } catch (CancelacionOrdenException e) {
            throw e;  // Re-lanzamos la excepción personalizada para que sea manejada por capas superiores
        } catch (Exception e) {
            throw new Exception("Error inesperado al cancelar la orden de compra", e);
        }
    }
    //
    @Override
    public boolean redimirCupon(String codigoCupon) throws Exception {
        try {
            // Validar si el cupón existe
            Optional<Cupon> cuponOpt = cuponRepo.findByCodigo(codigoCupon);
            if (cuponOpt.isPresent()) {
                Cupon cupon = cuponOpt.get();

                // Verifica si el cupón está expirado o ya fue usado
                if (cupon.getEstadoCupon()== EstadoCupon.EXPIRADO || cupon.getEstadoCupon()==EstadoCupon.USADO) {
                    throw new CuponInvalidoException("El cupón con código " + codigoCupon + " ya está expirado o ha sido usado.");
                }

                // Marcar el cupón como usado y guardarlo
                cuponRepo.save(cupon);

                return true;  // Redención exitosa
            } else {
                // Lanza excepción si no se encuentra el cupón
                throw new CuponInvalidoException("No se encontró ningún cupón con el código: " + codigoCupon);
            }
        } catch (CuponInvalidoException e) {
            throw e;  // Re-lanzamos la excepción personalizada
        } catch (Exception e) {
            throw new Exception("Error inesperado al redimir el cupón", e);
        }
    }

    @Override
    public List<Compra> listarCompras() throws Exception {
        try {
            // Obtenemos todas las compras de la base de datos
            List<Compra> compras = compraRepo.findAll();

            if (compras.isEmpty()) {
                // Lanza excepción si no hay compras en el sistema
                throw new ComprasNoEncontradasException("No se encontraron compras registradas.");
            }

            return compras; // Retornamos la lista de compras

        } catch (ComprasNoEncontradasException e) {
            throw e; // Re-lanzamos la excepción personalizada
        } catch (Exception e) {
            throw new Exception("Error inesperado al listar las compras", e);
        }
    }

    @Override
    public boolean cancelarCompras() throws Exception {
        try {
            // Obtenemos todas las compras pendientes
            List<Compra> comprasPendientes = compraRepo.findByEstado(EstadoCompra.PENDIENTE);

            if (comprasPendientes.isEmpty()) {
                // Lanza excepción si no hay compras pendientes que cancelar
                throw new CancelacionCompraException("No se encontraron compras pendientes para cancelar.");
            }

            // Iteramos sobre las compras pendientes y las cancelamos
            for (Compra compra : comprasPendientes) {
                compra.setEstado(EstadoCompra.CANCELADA);
                compraRepo.save(compra); // Guardar cada compra actualizada
            }

            return true; // Todas las compras han sido canceladas correctamente

        } catch (CancelacionCompraException e) {
            throw e; // Re-lanzamos la excepción personalizada
        } catch (Exception e) {
            throw new Exception("Error inesperado al cancelar las compras", e);
        }
    }

    @Override
    public List<Compra> historialCompras(ObjectId idCuenta) throws Exception {
        try {
            // Obtenemos el historial de compras para un usuario específico
            List<Compra> historialCompras = compraRepo.findByIdCliente(idCuenta);

            if (historialCompras.isEmpty()) {
                // Lanza excepción si no se encuentran compras históricas
                throw new HistorialComprasNoEncontradoException("No se encontraron compras en el historial para el usuario.");
            }

            return historialCompras; // Retornamos la lista de compras del historial

        } catch (HistorialComprasNoEncontradoException e) {
            throw e; // Re-lanzamos la excepción personalizada
        } catch (Exception e) {
            throw new Exception("Error inesperado al obtener el historial de compras", e);
        }
    }


}
