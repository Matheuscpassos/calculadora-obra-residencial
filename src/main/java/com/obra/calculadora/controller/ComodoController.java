package com.obra.calculadora.controller;

import com.obra.calculadora.model.Comodo;
import com.obra.calculadora.repository.ComodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comodos")
public class ComodoController {

    @Autowired
    private ComodoRepository comodoRepository;

    @GetMapping
    public List<Comodo> listarTodos() {
        return comodoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comodo buscarPorId(@PathVariable Long id) {
        return comodoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Comodo salvar(@RequestBody Comodo comodo) {
        return comodoRepository.save(comodo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        comodoRepository.deleteById(id);
    }
}
