package com.obra.calculadora;

import com.obra.calculadora.model.Aresta;
import com.obra.calculadora.model.Vertice;
import com.obra.calculadora.repository.ArestaRepository;
import com.obra.calculadora.repository.VerticeRepository;
import com.obra.calculadora.service.ConcreteService;
import com.obra.calculadora.service.TijoloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CalculadoraApplicationTests {

    @Autowired
    private ArestaRepository arestaRepository;

    @Autowired
    private VerticeRepository verticeRepository;

    @Autowired
    private ConcreteService concreteService;

    @Autowired
    private TijoloService tijoloService;

    @Test
    public void testarCalculoConcreto() {
        // Criando dois vertices (pilares)
        Vertice v1 = new Vertice("V1");
        Vertice v2 = new Vertice("V2");
        verticeRepository.save(v1);
        verticeRepository.save(v2);

        // Criando uma parede (aresta) de 5m de comprimento e 0.15m de largura
        Aresta parede = new Aresta();
        parede.setNome("Parede Sala");
        parede.setComprimento(5.0);
        parede.setLargura(0.15);
        parede.setEspessura(0.15);
        parede.setTemJanela(false);
        parede.setTemPorta(false);
        parede.setVerticeInicio(v1);
        parede.setVerticeFim(v2);
        arestaRepository.save(parede);

        // Calculando concreto com altura de viga de 0.4m
        List<Long> ids = new ArrayList<>();
        ids.add(parede.getId());

        double volume = concreteService.calcularVolumeConcreto(ids, 0.4);

        System.out.println("=== TESTE ETAPA 2 - VOLUME DE CONCRETO ===");
        System.out.println("Parede: " + parede.getNome());
        System.out.println("Comprimento: " + parede.getComprimento() + "m");
        System.out.println("Largura: " + parede.getLargura() + "m");
        System.out.println("Altura da viga: 0.4m");
        System.out.println("Volume calculado: " + volume + " m³");
        System.out.println("Esperado: 0.3 m³ (5 x 0.15 x 0.4)");
        System.out.println("==========================================");

        assertTrue(volume > 0);
    }

    @Test
    public void testarCalculoTijolos() {
        // Criando vertices
        Vertice v3 = new Vertice("V3");
        Vertice v4 = new Vertice("V4");
        verticeRepository.save(v3);
        verticeRepository.save(v4);

        // Criando parede com janela
        Aresta paredeComJanela = new Aresta();
        paredeComJanela.setNome("Parede Quarto com janela");
        paredeComJanela.setComprimento(4.0);
        paredeComJanela.setLargura(0.15);
        paredeComJanela.setEspessura(0.15);
        paredeComJanela.setTemJanela(true);
        paredeComJanela.setAlturaJanela(1.2);
        paredeComJanela.setComprimentoJanela(1.0);
        paredeComJanela.setTemPorta(false);
        paredeComJanela.setVerticeInicio(v3);
        paredeComJanela.setVerticeFim(v4);
        arestaRepository.save(paredeComJanela);

        List<Long> ids = new ArrayList<>();
        ids.add(paredeComJanela.getId());

        // Tijolo padrao: 0.19m x 0.09m
        int quantidade = tijoloService.calcularQuantidadeTijolos(ids, 2.8, 0.09, 0.19);

        System.out.println("=== TESTE ETAPA 3 - QUANTIDADE DE TIJOLOS ===");
        System.out.println("Parede: " + paredeComJanela.getNome());
        System.out.println("Comprimento da parede: " + paredeComJanela.getComprimento() + "m");
        System.out.println("Altura da parede: 2.8m");
        System.out.println("Janela: " + paredeComJanela.getComprimentoJanela() + "m x " + paredeComJanela.getAlturaJanela() + "m");
        System.out.println("Tijolo: 0.19m x 0.09m");
        System.out.println("Quantidade de tijolos: " + quantidade + " unidades");
        System.out.println("=============================================");

        assertTrue(quantidade > 0);
    }
}
