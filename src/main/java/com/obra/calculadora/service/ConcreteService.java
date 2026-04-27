package com.obra.calculadora.service;

import com.obra.calculadora.model.Aresta;
import com.obra.calculadora.repository.ArestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcreteService {

    @Autowired
    private ArestaRepository arestaRepository;

    // Calcula o volume total de concreto da fundação (viga baldrame)
    // Formula: Volume = Largura x Altura x Comprimento de cada parede
    public double calcularVolumeConcreto(List<Long> idsArestas, double alturaViga) {

        double volumeTotal = 0;

        for (Long id : idsArestas) {
            Aresta aresta = arestaRepository.findById(id).orElse(null);

            if (aresta != null) {
                double volume = aresta.getLargura() * alturaViga * aresta.getComprimento();
                volumeTotal = volumeTotal + volume;
            }
        }

        return volumeTotal;
    }
}
