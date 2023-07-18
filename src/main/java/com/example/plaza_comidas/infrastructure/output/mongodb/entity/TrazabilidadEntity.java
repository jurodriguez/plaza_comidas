package com.example.plaza_comidas.infrastructure.output.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trazabilidad")
@Data
public class TrazabilidadEntity {

    @Id
    private String id;
    private String idPedido;
    private String idCliente;
    private String fecha;
    private String estadoAnterior;
    private String estadoNuevo;
    private String idEmpleado;
    private String correoEmpleado;
}
