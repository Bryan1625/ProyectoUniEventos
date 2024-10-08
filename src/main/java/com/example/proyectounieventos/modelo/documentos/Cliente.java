package com.example.proyectounieventos.modelo.documentos;

import com.example.proyectounieventos.modelo.enums.TipoCuenta;
import com.example.proyectounieventos.modelo.vo.CodigoValidacion;
import com.example.proyectounieventos.modelo.vo.EstadoCuenta;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Cliente")
@NoArgsConstructor
@Getter
@Setter
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Cuenta {

    private String direccion;
}
