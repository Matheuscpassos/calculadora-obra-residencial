package com.obra.calculadora.controller;

import com.obra.calculadora.service.TijoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tijolos")
public class TijoloController {

    @Autowired
    private TijoloService tijoloService;

    // POST /tijolos/calcular
    // Recebe lista de IDs das arestas, altura da parede e dimensoes do tijolo
    // Retorna a quantidade de tijolos necessarios
    @PostMapping("/calcular")
    public int calcularTijolos(@RequestParam List<Long> idsArestas,
                                @RequestParam double alturaParede,
                                @RequestParam double alturaTijolo,
                                @RequestParam double comprimentoTijolo) {

        int quantidade = tijoloService.calcularQuantidadeTijolos(
                idsArestas, alturaParede, alturaTijolo, comprimentoTijolo);

        return quantidade;
    }
}
