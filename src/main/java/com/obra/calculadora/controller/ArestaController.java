package com.obra.calculadora.controller;

import com.obra.calculadora.model.Aresta;
import com.obra.calculadora.repository.ArestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arestas")
public class ArestaController {

    @Autowired
    private ArestaRepository arestaRepository;

    @GetMapping
    public List<Aresta> listarTodas() {
        return arestaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Aresta buscarPorId(@PathVariable Long id) {
        return arestaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Aresta salvar(@RequestBody Aresta aresta) {
        return arestaRepository.save(aresta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        arestaRepository.deleteById(id);
    }
}
