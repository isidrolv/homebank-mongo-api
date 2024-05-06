package com.homebank.mongoapi.controller;

import com.homebank.mongoapi.model.ClienteDTO;
import com.homebank.mongoapi.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    private final ClientesRepository clientesRepository;

    @Autowired
    public ClientesController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> gellAllClientes() {

        return ResponseEntity.ok(clientesRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable String id) {
        Optional<ClienteDTO> byId = clientesRepository.findById(id);
        return ResponseEntity.ok(byId.orElse(null));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countClientes() {
        return ResponseEntity.ok(clientesRepository.count());
    }

    @PostMapping("/create")
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(clientesRepository.save(cliente));
    }

    @PutMapping("/update")
    public ResponseEntity<ClienteDTO> updateCliente(@RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(clientesRepository.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String id) {
        clientesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
