package com.example.proyectounieventos.servicios.impl;

import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import com.example.proyectounieventos.servicios.CarritoServicios;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoServiciosImplement implements CarritoServicios {

    private List<DetalleCompra> carrito;

    public CarritoServiciosImplement() {
        this.carrito = new ArrayList<>();
    }

    @Override
    public void agregarItem(DetalleCompra detalleCompra) throws Exception {
        if (detalleCompra == null) {
            throw new Exception("Detalle de compra no puede ser nulo.");
        }
        carrito.add(detalleCompra);
    }

    @Override
    public void actualizarValorTotal() throws Exception {

    }

    @Override
    public void eliminarItem(DetalleCompra detalleCompra) throws Exception {
        if (detalleCompra == null || !carrito.contains(detalleCompra)) {
            throw new Exception("El item no se encuentra en el carrito.");
        }
        carrito.remove(detalleCompra);
    }

    @Override
    public void vaciarCarrito() throws Exception {
        carrito.clear();
    }

    @Override
    public List<DetalleCompra> verItems() throws Exception {
        if (carrito.isEmpty()) {
            throw new Exception("El carrito está vacío.");
        }
        return new ArrayList<>(carrito);
    }
}
