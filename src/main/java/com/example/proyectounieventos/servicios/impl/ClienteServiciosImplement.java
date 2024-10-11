package com.example.proyectounieventos.servicios.impl;

import com.example.proyectounieventos.modelo.documentos.Usuario;
import com.example.proyectounieventos.modelo.enums.EstadoCompra;
import com.example.proyectounieventos.modelo.documentos.Compra;
import com.example.proyectounieventos.modelo.documentos.Evento;
import com.example.proyectounieventos.modelo.vo.DetalleCompra;
import com.example.proyectounieventos.modelo.documentos.Cliente;
import com.example.proyectounieventos.repositorios.CompraRepo;
import com.example.proyectounieventos.repositorios.EventoRepo;
import com.example.proyectounieventos.repositorios.ClienteRepo;
import com.example.proyectounieventos.repositorios.UsuarioRepo;
import com.example.proyectounieventos.servicios.ClienteServicios;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiciosImplement implements ClienteServicios {

    private final EventoRepo eventoRepository;
    private final CompraRepo compraRepository;
    private final ClienteRepo clienteRepository;
    private final UsuarioRepo usuarioRepository;

    @Autowired
    public ClienteServiciosImplement(EventoRepo eventoRepository,
                                     CompraRepo compraRepository,
                                     ClienteRepo clienteRepository,
                                     UsuarioRepo usuarioRepository) {
        this.eventoRepository = eventoRepository;
        this.compraRepository = compraRepository;
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Evento> listarEventos(String filtro) throws Exception {
        if (filtro == null || filtro.isEmpty()) {
            return eventoRepository.findAll();
        } else {
            return eventoRepository.findByNombreContainingIgnoreCase(filtro);
        }
    }

    @Override
    public Compra crearOrdenCompra(DetalleCompra detalleCompra) throws Exception {
        if (detalleCompra == null) {
            throw new Exception("Detalle de compra no puede ser nulo.");
        }

        // Buscamos el cliente relacionado con el detalle de compra
        Cliente cliente = clienteRepository.findById(detalleCompra.getCliente().toHexString())
                .orElseThrow(() -> new Exception("Cliente no encontrado."));

        Compra nuevaCompra = new Compra();
        nuevaCompra.setDetalles(List.of(detalleCompra));
        nuevaCompra.setIdCliente(cliente.getId());

        return compraRepository.save(nuevaCompra);
    }

    @Override
    public boolean cancelarOrdenCompra(String codigoOrden) throws Exception {
        Compra compra = compraRepository.findById(codigoOrden)
                .orElseThrow(() -> new Exception("Orden de compra no encontrada."));

        // Lógica para cancelar la compra, como verificar el estado y actualizarlo
        if (compra.getEstado().equals(EstadoCompra.RECHAZADO) || compra.getEstado().equals(EstadoCompra.COMPLETADO)) {
            throw new Exception("La orden no se puede cancelar.");
        }
        compra.setEstado(EstadoCompra.RECHAZADO);
        compraRepository.save(compra);
        return true;
    }

    @Override
    public boolean redimirCupon(String codigoCupon) throws Exception {
        // Lógica para redimir un cupón
        // Aquí deberías verificar si el cupón existe y si puede ser redimido
        // Asumimos que se redime correctamente
        return true; // Cambia esto a la lógica real que determines.
    }

    @Override
    public List<Compra> listarCompras() throws Exception {
        return List.of();
    }

    @Override
    public boolean cancelarCompras() throws Exception {
        return false;
    }

    @Override
    public List<Compra> historialCompras(ObjectId idUsuario) throws Exception {
        return List.of();
    }

    @Override
    public List<Compra> listarCompras(String idUsuario) throws Exception {
        if (idUsuario == null || idUsuario.isEmpty()) {
            throw new Exception("ID de usuario no puede ser nulo o vacío.");
        }
        // Buscamos al usuario por su ID
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new Exception("Usuario no encontrado."));

        //
        return compraRepository.findByIdCliente(usuario.getCuenta().getId());
    }
}
