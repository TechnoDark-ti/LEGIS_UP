package com.legisup.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "protocolos")
public class Protocolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_protocolo", nullable = false, unique = true)
    private String numeroProtocolo;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String ementa;

    @Column(name = "data_recebimento", insertable = false, updatable = false)
    private LocalDateTime dataRecebimento;

    @Column(nullable = false)
    private String status;

    public Protocolo() {
    }

    public Protocolo(Integer id, String numeroProtocolo, String tipo, String autor, String ementa, LocalDateTime dataRecebimento, String status) {
        this.id = id;
        this.numeroProtocolo = numeroProtocolo;
        this.tipo = tipo;
        this.autor = autor;
        this.ementa = ementa;
        this.dataRecebimento = dataRecebimento;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(String numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public LocalDateTime getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDateTime dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}