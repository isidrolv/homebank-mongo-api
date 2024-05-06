package com.homebank.mongoapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cuentas")
public class CuentaDTO {
    @Id
    String id;
    String numeroCuenta;
    String tipoCuenta;
    String moneda;
    Double saldo;
    LocalDateTime fechaApertura;
    LocalDateTime ultimoMovimientoDt;
    Double ultimoMovimientoMonto;
    String ultimoMovimientoTipo;
    String usuarioId;
    String estatus;
    String clienteId;
    String sucursalId;
}
