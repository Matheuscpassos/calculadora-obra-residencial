package com.obra.calculadora.model;

import jakarta.persistence.*;

@Entity
public class Aresta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private double largura;
    private double comprimento;
    private double espessura;

    private boolean temJanela;
    private double alturaJanela;
    private double comprimentoJanela;

    private boolean temPorta;
    private double alturaPorta;
    private double comprimentoPorta;

    @ManyToOne
    private Vertice verticeInicio;

    @ManyToOne
    private Vertice verticeFim;

    public Aresta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getEspessura() {
        return espessura;
    }

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }

    public boolean isTemJanela() {
        return temJanela;
    }

    public void setTemJanela(boolean temJanela) {
        this.temJanela = temJanela;
    }

    public double getAlturaJanela() {
        return alturaJanela;
    }

    public void setAlturaJanela(double alturaJanela) {
        this.alturaJanela = alturaJanela;
    }

    public double getComprimentoJanela() {
        return comprimentoJanela;
    }

    public void setComprimentoJanela(double comprimentoJanela) {
        this.comprimentoJanela = comprimentoJanela;
    }

    public boolean isTemPorta() {
        return temPorta;
    }

    public void setTemPorta(boolean temPorta) {
        this.temPorta = temPorta;
    }

    public double getAlturaPorta() {
        return alturaPorta;
    }

    public void setAlturaPorta(double alturaPorta) {
        this.alturaPorta = alturaPorta;
    }

    public double getComprimentoPorta() {
        return comprimentoPorta;
    }

    public void setComprimentoPorta(double comprimentoPorta) {
        this.comprimentoPorta = comprimentoPorta;
    }

    public Vertice getVerticeInicio() {
        return verticeInicio;
    }

    public void setVerticeInicio(Vertice verticeInicio) {
        this.verticeInicio = verticeInicio;
    }

    public Vertice getVerticeFim() {
        return verticeFim;
    }

    public void setVerticeFim(Vertice verticeFim) {
        this.verticeFim = verticeFim;
    }
}
