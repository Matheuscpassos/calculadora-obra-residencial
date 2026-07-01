package com.obra.calculadora.repository;

import com.obra.calculadora.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    Optional<Orcamento> findByNumeroOrcamento(String numeroOrcamento);

    List<Orcamento> findByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}
