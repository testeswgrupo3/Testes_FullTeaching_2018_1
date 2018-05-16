# Testes no Sistema FullTeaching

Este trabalho tem como objetivo implementar casos de teste com a finalidade de testar o sistema [FullTeachin](https://atlantis.isti.cnr.it:5000/), um aplicativo da web educacional para facilitar as aulas on-line tanto para professores quanto para alunos, mais iformações acesse o [reposório](https://github.com/pabloFuente/full-teaching) do desenvolvedor.

## Grupo 3
1. Igor Fabri
2. Paulo Henrique Dias de Oliveira
3. Filipe Barreto
4. Lucia Pereira
5. Luis Felipe

 ## Casos de Testes Definidos Para Inplementação
  - ### Utilizando a Ferramenta Testlink
    - [x] Realizar login com dados corretos
    - [x] Realizar login com dados inválidos
    - [x] Cadastrar um curso
    - [x] Cadastrar curso repetido
    - [x] Editar curso
    - [x] Inserir informações
    - [x] Cadastrar atividade
    - [x] Cadastrar varias atividades no mesmo dia
    - [ ] Visualizar atividade em um curso
    - [x] Postar comentário no fórum
    - [x] Postar comentário em branco no fórum
    - [ ] Editar um comentário no fórum (funcionalidade inexistente)
    - [ ] Enviar arquivo em curso
    - [ ] Enviar arquivo em curso com mais de 5mb
    - [x] Cadastrar participante no curso
    - [x] Aterar configurações

  - ### Análise Classes de Equivalência
    - [ ] Enviar arquivo em curso com tamanho igual a 3mb
    - [ ] Enviar arquivo em curso com tamanho igual a 6mb
    - [x] Cadastrar atividade em uma data inferior a atual

  - ### Análise de Valor Limite
    - [ ] Enviar arquivo em curso com 0.01mb de tamanho
    - [ ] Enviar arquivo em curso com 4.99mb de tamanho
    - [ ] Enviar arquivo em curso com menos de 5mb de tamanho
