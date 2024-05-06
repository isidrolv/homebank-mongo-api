package com.homebank.mongoapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clientes")
public class ClienteDTO {
    @Id
    String id;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String email;
    String telefono;
    String direccion;
    String ciudad;
    String estado;
    String codigoPostal;
    String pais;
    LocalDate fechaNacimiento;
    Genero genero;
    String ocupacion;
    String empresa;
    String puesto;
    String ingresoAnual;
}
