package com.example.proyectounieventos.modelo.vo;
import com.example.proyectounieventos.modelo.enums.TipoUsuario;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "usuario")
public class Usuario {
    @Id
    private String id;
    private String cedula;
    private String nombreCompleto;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String contraseña;
    private TipoUsuario tipoUsuario;
    private boolean activo;
    private boolean cuentaVerificada;
    private List<Cupon> cupones;
}
