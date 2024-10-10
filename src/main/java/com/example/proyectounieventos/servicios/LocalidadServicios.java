package com.example.proyectounieventos.servicios;

import com.example.proyectounieventos.dto.evento.LocalidadDTO;
import com.example.proyectounieventos.modelo.documentos.Localidad;

import java.util.List;

public interface LocalidadServicios {

    /**
     * Agrega una nueva localidad asociada a un evento.
     *
     * @param eventoId ID del evento al que se asociará la localidad.
     * @param localidadDTO Objeto DTO que contiene la información de la localidad a agregar.
     * @return La localidad creada.
     * @throws Exception si ocurre un error durante la creación.
     */
    Localidad agregarLocalidad(String eventoId, LocalidadDTO localidadDTO) throws Exception;

    /**
     * Elimina una localidad existente.
     *
     * @param id ID de la localidad a eliminar.
     * @return Mensaje de confirmación.
     * @throws Exception si la localidad no se encuentra.
     */
    String eliminarLocalidad(String id) throws Exception;

    /**
     * Lista todas las localidades.
     *
     * @return Lista de todas las localidades.
     * @throws Exception si ocurre un error al listar.
     */
    List<Localidad> listarLocalidades() throws Exception;

    /**
     * Actualiza una localidad existente.
     *
     * @param id ID de la localidad a actualizar.
     * @param localidadDTO Objeto DTO que contiene la nueva información de la localidad.
     * @return La localidad actualizada.
     * @throws Exception si la localidad no se encuentra.
     */
    Localidad actualizarLocalidad(String id, LocalidadDTO localidadDTO) throws Exception;

    /**
     * Obtiene una localidad por su ID.
     *
     * @param id ID de la localidad a obtener.
     * @return La localidad correspondiente.
     * @throws Exception si la localidad no se encuentra.
     */
    Localidad obtenerLocalidadPorId(String id) throws Exception;
}
