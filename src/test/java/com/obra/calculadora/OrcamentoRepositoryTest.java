package com.obra.calculadora;

import com.obra.calculadora.model.Orcamento;
import com.obra.calculadora.repository.OrcamentoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OrcamentoRepositoryTest {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Test
    void deveBuscarPorNumeroOrcamento() {
        Orcamento orcamento = new Orcamento();
        orcamento.setNumeroOrcamento("ORC-TESTE01");
        orcamento.setNomeUsuario("Matheus");
        orcamentoRepository.save(orcamento);

        assertTrue(orcamentoRepository.findByNumeroOrcamento("ORC-TESTE01").isPresent());
    }

    @Test
    void deveBuscarPorNomeUsuarioParcial() {
        Orcamento orcamento = new Orcamento();
        orcamento.setNumeroOrcamento("ORC-TESTE02");
        orcamento.setNomeUsuario("Matheus Passos");
        orcamentoRepository.save(orcamento);

        assertTrue(orcamentoRepository.findByNomeUsuarioContainingIgnoreCase("matheus").size() > 0);
    }
}
