package com.obra.calculadora.controller;

import com.obra.calculadora.model.Vertice;
import com.obra.calculadora.repository.VerticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vertices")
public class VerticeController {

    @Autowired
    private VerticeRepository verticeRepository;

    @GetMapping
    public List<Vertice> listarTodos() {
        return verticeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vertice buscarPorId(@PathVariable Long id) {
        return verticeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Vertice salvar(@RequestBody Vertice vertice) {
        return verticeRepository.save(vertice);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        verticeRepository.deleteById(id);
    }
}
