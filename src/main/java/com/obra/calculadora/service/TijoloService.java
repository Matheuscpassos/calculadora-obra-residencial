package com.obra.calculadora.service;

import com.obra.calculadora.model.Aresta;
import com.obra.calculadora.repository.ArestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TijoloService {

    @Autowired
    private ArestaRepository arestaRepository;

    // Calcula a quantidade de tijolos necessários para as paredes
    // Formula: area da parede / area do tijolo
    // Descontamos as areas de janelas e portas quando existirem
    public int calcularQuantidadeTijolos(List<Long> idsArestas, double alturaParede,
                                          double alturaTijolo, double comprimentoTijolo) {

        double areaTotal = 0;
        double areaTijolo = alturaTijolo * comprimentoTijolo;

        for (Long id : idsArestas) {
            Aresta aresta = arestaRepository.findById(id).orElse(null);

            if (aresta != null) {
                // Area da parede inteira
                double areaParede = aresta.getComprimento() * alturaParede;

                // Desconta a janela se tiver
                if (aresta.isTemJanela()) {
                    double areaJanela = aresta.getComprimentoJanela() * aresta.getAlturaJanela();
                    areaParede = areaParede - areaJanela;
                }

                // Desconta a porta se tiver
                if (aresta.isTemPorta()) {
                    double areaPorta = aresta.getComprimentoPorta() * aresta.getAlturaPorta();
                    areaParede = areaParede - areaPorta;
                }

                areaTotal = areaTotal + areaParede;
            }
        }

        // Arredonda para cima pois tijolo é inteiro
        int quantidade = (int) Math.ceil(areaTotal / areaTijolo);
        return quantidade;
    }
}
