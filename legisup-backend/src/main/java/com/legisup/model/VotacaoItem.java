package com.legisup.model;

import jakarta.persistence.*;

@Entity
@Table(name = "votacoes_item")
public class VotacaoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sessao_id")
    private Integer sessaoId;

    @Column(name = "protocolo_id")
    private Integer protocoloId;

    @Column(nullable = false)
    private String titulo;

    @Column(name = "tipo_quorum")
    private String tipoQuorum = "Maioria Simples";

    private String status = "Pendente";

    public VotacaoItem() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getSessaoId() { return sessaoId; }
    public void setSessaoId(Integer sessaoId) { this.sessaoId = sessaoId; }

    public Integer getProtocoloId() { return protocoloId; }
    public void setProtocoloId(Integer protocoloId) { this.protocoloId = protocoloId; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTipoQuorum() { return tipoQuorum; }
    public void setTipoQuorum(String tipoQuorum) { this.tipoQuorum = tipoQuorum; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}