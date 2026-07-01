# Plano de Teste — Tela de Orçamento (Etapa 2)

| ID | Cenário | Passos | Resultado esperado |
|---|---|---|---|
| CT01 | Cadastro de cômodo válido | Preencher nome/dimensões e clicar "Adicionar cômodo" | Cômodo aparece na lista da tela |
| CT02 | Cadastro de parede com porta e janela | Adicionar parede marcando ambos os checkboxes | Área da porta e da janela descontadas no cálculo de tijolos |
| CT03 | Cálculo de orçamento completo | Preencher 2+ cômodos com paredes e clicar "Calcular Orçamento" | Sistema exibe número de orçamento, volume de concreto e quantidade de tijolos; registro salvo no H2 |
| CT04 | Busca por número de orçamento | Chamar `findByNumeroOrcamento` com número existente | Retorna o orçamento correto |
| CT05 | Busca por nome do usuário | Chamar `findByNomeUsuarioContainingIgnoreCase` com nome parcial | Retorna todos os orçamentos daquele usuário |
| CT06 | Campo obrigatório vazio | Tentar calcular sem preencher nome | Mensagem de validação exibida, formulário não envia |

## Evidências

Salvar prints de tela de cada cenário em `docs/evidencias/CT01.png`, `CT02.png`, etc.
Para CT04/CT05, usar o H2 Console (`http://localhost:8080/h2-console`, JDBC URL `jdbc:h2:mem:obradb`) ou rodar os testes automatizados de `OrcamentoRepositoryTest` com `mvn test` e anexar o resultado.
