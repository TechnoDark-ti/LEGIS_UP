package com.legisup.model;

import jakarta.persistence.*;

@Entity
@Table(name = "presencas_vereadores")
public class PresencaVereador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sessao_id", nullable = false)
    private Integer sessaoId;

    @Column(name = "vereador_id", nullable = false)
    private Integer vereadorId;

    private Boolean presente = false;

    private String justificativa;

    @Column(name = "atestado_documento_url")
    private String atestadoDocumentoUrl;

    @Column(name = "justificativa_aceita")
    private Boolean justificativaAceita = false;

    public PresencaVereador() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getSessaoId() { return sessaoId; }
    public void setSessaoId(Integer sessaoId) { this.sessaoId = sessaoId; }

    public Integer getVereadorId() { return vereadorId; }
    public void setVereadorId(Integer vereadorId) { this.vereadorId = vereadorId; }

    public Boolean getPresente() { return presente; }
    public void setPresente(Boolean presente) { this.presente = presente; }

    public String getJustificativa() { return justificativa; }
    public void setJustificativa(String justificativa) { this.justificativa = justificativa; }

    public String getAtestadoDocumentoUrl() { return atestadoDocumentoUrl; }
    public void setAtestadoDocumentoUrl(String atestadoDocumentoUrl) { this.atestadoDocumentoUrl = atestadoDocumentoUrl; }

    public Boolean getJustificativaAceita() { return justificativaAceita; }
    public void setJustificativaAceita(Boolean justificativaAceita) { this.justificativaAceita = justificativaAceita; }
}