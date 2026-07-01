package com.obra.calculadora.web;

import com.obra.calculadora.model.Aresta;
import com.obra.calculadora.model.Comodo;
import com.obra.calculadora.model.Orcamento;
import com.obra.calculadora.model.StatusOrcamento;
import com.obra.calculadora.repository.OrcamentoRepository;
import com.obra.calculadora.service.ConcreteService;
import com.obra.calculadora.service.TijoloService;
import jakarta.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component("orcamentoBean")
@ViewScoped
public class OrcamentoBean implements Serializable {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private ConcreteService concreteService;

    @Autowired
    private TijoloService tijoloService;

    private String nomeUsuario;

    private List<Comodo> comodos = new ArrayList<>();
    private Comodo comodoAtual = new Comodo();
    private Aresta paredeAtual = new Aresta();

    private double alturaViga = 0.3;
    private double alturaParede = 2.8;
    private double alturaTijolo = 0.19;
    private double comprimentoTijolo = 0.19;

    private Orcamento orcamentoCalculado;

    public void adicionarComodo() {
        comodoAtual.setParedes(new ArrayList<>());
        comodos.add(comodoAtual);
        comodoAtual = new Comodo();
    }

    public void removerComodo(Comodo comodo) {
        comodos.remove(comodo);
    }

    public void adicionarParede(Comodo comodo) {
        comodo.getParedes().add(paredeAtual);
        paredeAtual = new Aresta();
    }

    public void removerParede(Comodo comodo, Aresta parede) {
        comodo.getParedes().remove(parede);
    }

    public void calcularOrcamento() {
        Orcamento orcamento = new Orcamento();
        orcamento.setNumeroOrcamento("ORC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        orcamento.setNomeUsuario(nomeUsuario);

        comodos.forEach(c -> c.setOrcamento(orcamento));
        orcamento.setComodos(comodos);

        Orcamento salvoParcial = orcamentoRepository.save(orcamento);

        List<Long> idsArestas = comodos.stream()
                .flatMap(c -> c.getParedes().stream())
                .map(Aresta::getId)
                .collect(Collectors.toList());

        double volume = concreteService.calcularVolumeConcreto(idsArestas, alturaViga);
        int tijolos = tijoloService.calcularQuantidadeTijolos(idsArestas, alturaParede, alturaTijolo, comprimentoTijolo);

        salvoParcial.setVolumeConcretoTotal(volume);
        salvoParcial.setQuantidadeTijolosTotal(tijolos);
        salvoParcial.setStatus(StatusOrcamento.CALCULADO);

        this.orcamentoCalculado = orcamentoRepository.save(salvoParcial);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }

    public Comodo getComodoAtual() {
        return comodoAtual;
    }

    public void setComodoAtual(Comodo comodoAtual) {
        this.comodoAtual = comodoAtual;
    }

    public Aresta getParedeAtual() {
        return paredeAtual;
    }

    public void setParedeAtual(Aresta paredeAtual) {
        this.paredeAtual = paredeAtual;
    }

    public double getAlturaViga() {
        return alturaViga;
    }

    public void setAlturaViga(double alturaViga) {
        this.alturaViga = alturaViga;
    }

    public double getAlturaParede() {
        return alturaParede;
    }

    public void setAlturaParede(double alturaParede) {
        this.alturaParede = alturaParede;
    }

    public double getAlturaTijolo() {
        return alturaTijolo;
    }

    public void setAlturaTijolo(double alturaTijolo) {
        this.alturaTijolo = alturaTijolo;
    }

    public double getComprimentoTijolo() {
        return comprimentoTijolo;
    }

    public void setComprimentoTijolo(double comprimentoTijolo) {
        this.comprimentoTijolo = comprimentoTijolo;
    }

    public Orcamento getOrcamentoCalculado() {
        return orcamentoCalculado;
    }

    public void setOrcamentoCalculado(Orcamento orcamentoCalculado) {
        this.orcamentoCalculado = orcamentoCalculado;
    }
}
