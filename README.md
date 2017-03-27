# mars
Mars project - Robot test

## Sobre 

Projeto de simulação da movimentação de robôs em Marte para o processo seletivo da Conta Azul.

### Exemplos de requisições:

Entrada: curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
Saída esperada: (2, 0, S)

Entrada: curl -s --request POST http://localhost:8080/rest/mars/MML
Saída esperada: (0, 2, W)
