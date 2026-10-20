package com.legisup.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "votos_detalhados")
public class VotoDetalhado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "votacao_item_id", nullable = false)
    private Integer votacaoItemId;

    @Column(name = "vereador_id", nullable = false)
    private Integer vereadorId;

    @Column(nullable = false)
    private String voto;

    @Column(name = "data_voto")
    private LocalDateTime dataVoto = LocalDateTime.now();

    public VotoDetalhado() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getVotacaoItemId() { return votacaoItemId; }
    public void setVotacaoItemId(Integer votacaoItemId) { this.votacaoItemId = votacaoItemId; }

    public Integer getVereadorId() { return vereadorId; }
    public void setVereadorId(Integer vereadorId) { this.vereadorId = vereadorId; }

    public String getVoto() { return voto; }
    public void setVoto(String voto) { this.voto = voto; }

    public LocalDateTime getDataVoto() { return dataVoto; }
    public void setDataVoto(LocalDateTime dataVoto) { this.dataVoto = dataVoto; }
}