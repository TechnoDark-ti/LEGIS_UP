package com.legisup.controller;

import com.legisup.model.*;
import com.legisup.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/sessoes")
@CrossOrigin(origins = "*")
public class SessaoController {

    private final SessaoPlenariaRepository sessaoRepository;
    private final PresencaVereadorRepository presencaRepository;
    private final VotacaoItemRepository votacaoItemRepository;
    private final VotoDetalhadoRepository votoDetalhadoRepository;

    public SessaoController(SessaoPlenariaRepository sessaoRepository,
                            PresencaVereadorRepository presencaRepository,
                            VotacaoItemRepository votacaoItemRepository,
                            VotoDetalhadoRepository votoDetalhadoRepository) {
        this.sessaoRepository = sessaoRepository;
        this.presencaRepository = presencaRepository;
        this.votacaoItemRepository = votacaoItemRepository;
        this.votoDetalhadoRepository = votoDetalhadoRepository;
    }

    @GetMapping
    public List<SessaoPlenaria> listarSessoes() {
        return sessaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<SessaoPlenaria> criarSessao(@RequestBody SessaoPlenaria sessao) {
        if (sessao.getDataInicio() == null) {
            sessao.setDataInicio(LocalDateTime.now());
        }
        SessaoPlenaria salva = sessaoRepository.save(sessao);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping("/{sessaoId}/presencas")
    public List<PresencaVereador> listarPresencas(@PathVariable Integer sessaoId) {
        return presencaRepository.findBySessaoId(sessaoId);
    }

    @PostMapping("/{sessaoId}/presencas")
    public ResponseEntity<PresencaVereador> registrarPresenca(@PathVariable Integer sessaoId, @RequestBody PresencaVereador presenca) {
        presenca.setSessaoId(sessaoId);
        Optional<PresencaVereador> existente = presencaRepository.findBySessaoIdAndVereadorId(sessaoId, presenca.getVereadorId());
        if (existente.isPresent()) {
            PresencaVereador p = existente.get();
            p.setPresente(presenca.getPresente());
            p.setJustificativa(presenca.getJustificativa());
            p.setJustificativaAceita(presenca.getJustificativaAceita());
            return ResponseEntity.ok(presencaRepository.save(p));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(presencaRepository.save(presenca));
    }

    @GetMapping("/{sessaoId}/votacoes")
    public List<VotacaoItem> listarVotacoesItem(@PathVariable Integer sessaoId) {
        return votacaoItemRepository.findBySessaoId(sessaoId);
    }

    @PostMapping("/{sessaoId}/votacoes")
    public ResponseEntity<VotacaoItem> criarVotacaoItem(@PathVariable Integer sessaoId, @RequestBody VotacaoItem item) {
        item.setSessaoId(sessaoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(votacaoItemRepository.save(item));
    }

    @PostMapping("/votacoes/{itemId}/votar")
    public ResponseEntity<?> registrarVoto(@PathVariable Integer itemId, @RequestBody VotoDetalhado voto) {
        voto.setVotacaoItemId(itemId);
        voto.setDataVoto(LocalDateTime.now());
        Optional<VotoDetalhado> existente = votoDetalhadoRepository.findByVotacaoItemIdAndVereadorId(itemId, voto.getVereadorId());
        if (existente.isPresent()) {
            VotoDetalhado v = existente.get();
            v.setVoto(voto.getVoto());
            v.setDataVoto(LocalDateTime.now());
            return ResponseEntity.ok(votoDetalhadoRepository.save(v));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(votoDetalhadoRepository.save(voto));
    }

    @GetMapping("/votacoes/{itemId}/votos")
    public List<VotoDetalhado> listarVotosDoItem(@PathVariable Integer itemId) {
        return votoDetalhadoRepository.findByVotacaoItemId(itemId);
    }
}