package com.obra.calculadora.controller;

import com.obra.calculadora.service.ConcreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concreto")
public class ConcreteController {

    @Autowired
    private ConcreteService concreteService;

    // POST /concreto/calcular
    // Recebe lista de IDs das arestas e a altura da viga baldrame
    // Retorna o volume total de concreto em metros cúbicos
    @PostMapping("/calcular")
    public double calcularVolume(@RequestParam List<Long> idsArestas,
                                  @RequestParam double alturaViga) {

        double volume = concreteService.calcularVolumeConcreto(idsArestas, alturaViga);
        return volume;
    }
}
