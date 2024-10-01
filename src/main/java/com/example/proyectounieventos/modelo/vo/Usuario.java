package com.example.proyectounieventos.modelo.vo;
import com.example.proyectounieventos.modelo.enums.TipoUsuario;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String usuarioId;
    private String cedula;
    private String nombreCompleto;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String contrasenia;
    private TipoUsuario tipoUsuario;
    private boolean activo;
    private boolean cuentaVerificada;
    private List<Cupon> cupones;
}
