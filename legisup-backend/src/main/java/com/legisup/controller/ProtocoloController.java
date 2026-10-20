package com.legisup.controller;

import com.legisup.model.Protocolo;
import com.legisup.repository.ProtocoloRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/protocolos")
@CrossOrigin(origins = "*")
public class ProtocoloController {

    private final ProtocoloRepository repository;

    public ProtocoloController(ProtocoloRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Protocolo> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Protocolo> buscarPorId(@PathVariable Integer id) {
        Optional<Protocolo> protocolo = repository.findById(id);
        if (protocolo.isPresent()) {
            return ResponseEntity.ok(protocolo.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Protocolo> criar(@RequestBody Protocolo protocolo) {
        if (protocolo.getStatus() == null || protocolo.getStatus().trim().isEmpty()) {
            protocolo.setStatus("Em Tramitação");
        }
        Protocolo salvo = repository.save(protocolo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}