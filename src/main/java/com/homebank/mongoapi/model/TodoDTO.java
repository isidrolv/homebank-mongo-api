package com.homebank.mongoapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos")
public class TodoDTO {
    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private boolean completado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaCompletado;
    private LocalDateTime fechaVencimiento;
    private String usuarioId;
    private Long prioridad;
    private String categoria;
    private String etiquetas;
    private String notas;
    private String recordatorio;
    private Long parentId;
    private String estatus;
}
