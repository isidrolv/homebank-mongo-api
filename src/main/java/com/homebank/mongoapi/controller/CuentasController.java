package com.homebank.mongoapi.controller;

import com.homebank.mongoapi.repository.CuentasDao;
import com.homebank.mongoapi.repository.CuentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.homebank.mongoapi.model.CuentaDTO;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentasController {

    private final CuentasRepository cuentasRepository;
    private final CuentasDao cuentasDao;

    @Autowired
    public CuentasController(CuentasRepository cuentasRepository, CuentasDao cuentasDao) {
        this.cuentasRepository = cuentasRepository;
        this.cuentasDao = cuentasDao;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CuentaDTO>> getAllCuentas() {
        return ResponseEntity.ok().body(cuentasRepository.findAll());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCuentas(@RequestParam String id) {
        return ResponseEntity.ok().body(cuentasRepository.countById(id));
    }

    @GetMapping("/saldyById")
    public ResponseEntity<Double> sumCuentas(@RequestParam String clienteId) {
        return ResponseEntity.ok().body(cuentasDao.sumSaldoByClienteId(clienteId));
    }

    @PostMapping("/create")
    public ResponseEntity<CuentaDTO> createCuenta(@RequestBody CuentaDTO cuenta) {
        return ResponseEntity.ok().body(cuentasRepository.save(cuenta));
    }

    @PutMapping("/update")
    public ResponseEntity<CuentaDTO> updateCuenta(@RequestBody CuentaDTO cuenta) {
        return ResponseEntity.ok().body(cuentasRepository.save(cuenta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable String id) {
        cuentasRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
