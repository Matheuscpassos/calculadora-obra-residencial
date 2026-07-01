package com.obra.calculadora.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orcamento")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_orcamento", unique = true, nullable = false)
    private String numeroOrcamento;

    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private double volumeConcretoTotal;

    private long quantidadeTijolosTotal;

    @Enumerated(EnumType.STRING)
    private StatusOrcamento status = StatusOrcamento.RASCUNHO;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comodo> comodos = new ArrayList<>();

    public Orcamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroOrcamento() {
        return numeroOrcamento;
    }

    public void setNumeroOrcamento(String numeroOrcamento) {
        this.numeroOrcamento = numeroOrcamento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public double getVolumeConcretoTotal() {
        return volumeConcretoTotal;
    }

    public void setVolumeConcretoTotal(double volumeConcretoTotal) {
        this.volumeConcretoTotal = volumeConcretoTotal;
    }

    public long getQuantidadeTijolosTotal() {
        return quantidadeTijolosTotal;
    }

    public void setQuantidadeTijolosTotal(long quantidadeTijolosTotal) {
        this.quantidadeTijolosTotal = quantidadeTijolosTotal;
    }

    public StatusOrcamento getStatus() {
        return status;
    }

    public void setStatus(StatusOrcamento status) {
        this.status = status;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }
}
