package com.obra.calculadora.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Comodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double largura;
    private double comprimento;
    private double altura;

    @ManyToMany
    private List<Aresta> paredes;

    public Comodo() {
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public List<Aresta> getParedes() {
        return paredes;
    }

    public void setParedes(List<Aresta> paredes) {
        this.paredes = paredes;
    }
}
