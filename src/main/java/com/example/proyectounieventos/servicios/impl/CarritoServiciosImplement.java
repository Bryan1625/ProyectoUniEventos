package com.example.proyectounieventos.servicios.impl;

import com.example.proyectounieventos.modelo.documentos.Carrito;
import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import com.example.proyectounieventos.repositorios.CarritoRepo;
import com.example.proyectounieventos.servicios.CarritoServicios;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarritoServiciosImplement implements CarritoServicios {

    private final CarritoRepo carritoRepo;

    @Autowired
    public CarritoServiciosImplement(CarritoRepo carritoRepo) {
        this.carritoRepo = carritoRepo;
    }

    @Override
    public void agregarItem(DetalleCompra detalleCompra, ObjectId idUsuario) throws Exception {
        if (detalleCompra == null) {
            throw new Exception("Detalle de compra no puede ser nulo.");
        }

        // OBTIENE el carrito usando el idUsuario
        Optional<Carrito> optionalCarrito = carritoRepo.findByIdUsuario(idUsuario);

        // Verifica si el carrito es nulo
        if (optionalCarrito.isEmpty()) {
            throw new Exception("No se encontró el carrito en la base de datos.");
        }

        Carrito carrito = optionalCarrito.get();

        // Obtiene la lista de compras (items) del carrito
        List<Compra> compras = carrito.getItems();

        // Verifica si la lista de compras está inicializada
        if (compras.isEmpty()) {
            throw new Exception("El carrito no tiene ninguna compra asociada.");
        }
        Compra compra = compras.get(0);

        // Inicializa la lista de detalles si está vacía
        if (compra.getDetalles() == null) {
            compra.setDetalles(new ArrayList<>());
        }

        // Agrega el ítem (detalle de compra) a la lista de detalles
        compra.getDetalles().add(detalleCompra);

        // Guarda el carrito en la base de datos
        carritoRepo.save(carrito);
    }


    @Override
    public void actualizarValorTotal(ObjectId idCliente) throws Exception {

        Optional<Carrito> optionalCarrito = carritoRepo.findByIdUsuario(idCliente);

        if (optionalCarrito.isEmpty()) {
            throw new Exception("No se encontró el carrito para el cliente con ID: " + idCliente.toString());
        }

        Carrito carrito = optionalCarrito.get();

        // Calcular el valor total sumando los valores de cada DetalleCompra en las compras del carrito
        double valorTotal = carrito.getItems().stream()
                .flatMap(compra -> compra.getDetalles().stream()) // Obtener todos los DetalleCompra de cada Compra
                .mapToDouble(DetalleCompra::getTotal) // Acceder directamente al campo 'total' en DetalleCompra
                .sum();

        // Actualiza el valor total en cada Compra
        carrito.getItems().forEach(compra -> compra.setValorTotal((float) valorTotal));

        // Guarda el carrito actualizado en la base de datos
        carritoRepo.save(carrito);
    }


    @Override
    public void eliminarItem(DetalleCompra detalleCompra) throws Exception {
        if (detalleCompra == null) {
            throw new Exception("El item no puede ser nulo.");
        }

        // Recupera el carrito desde la base de datos
        Carrito carrito = obtenerCarrito();
        if (!carrito.getItems().remove(detalleCompra)) {
            throw new Exception("El item no se encuentra en el carrito.");
        }

        // Guardar el carrito actualizado en la base de datos
        carritoRepo.save(carrito);
    }

    @Override
    public void vaciarCarrito() throws Exception {
        // Recupera el carrito desde la base de datos
        Carrito carrito = obtenerCarrito();
        carrito.getItems().clear(); // Vaciar los items del carrito

        // Guarda el carrito actualizado en la base de datos
        carritoRepo.save(carrito);
    }

    @Override
    public List<DetalleCompra> verItems(ObjectId idCliente) throws Exception {
        // Busca el carrito en el repositorio usando el idCliente
        Optional<Carrito> optionalCarrito = carritoRepo.findByIdUsuario(idCliente);

        // Verifica si se encontró el carrito
        if (optionalCarrito.isEmpty()) {
            throw new Exception("No se encontró el carrito para el cliente con ID: " + idCliente.toString());
        }

        Carrito carrito = optionalCarrito.get();

        // Verifica si el carrito tiene compras
        if (carrito.getItems().isEmpty()) {
            throw new Exception("El carrito está vacío.");
        }

        // Obtiene todos los DetalleCompra de las compras en el carrito
        List<DetalleCompra> detalles = carrito.getItems().stream()
                .flatMap(compra -> compra.getDetalles().stream()) // Acceder a la lista de DetalleCompra de cada Compra
                .collect(Collectors.toList());

        return detalles;
    }


    //METODO AUXILIAR
    private Carrito obtenerCarrito() throws Exception {
        Optional<Carrito> optionalCarrito = carritoRepo.findById("ID_DEL_CARRITO"); // Cambiar "ID_DEL_CARRITO" según tu lógica
        if (optionalCarrito.isEmpty()) {
            throw new Exception("No se encontró el carrito.");
        }
        return optionalCarrito.get();
    }
}

