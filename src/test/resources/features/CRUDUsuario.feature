#language: pt

  Funcionalidade: Crud do cadastro de processos

    Contexto:
      Dado que o usuário está na pagina inicial
      E  que o usuario clica no menu Processos
      E o usuario clica no botão Novo
      E o usuário preencha os campos obrigatórios
      Quando o usuário clicar no botão salvar

@ignore
    Cenario: adicionar um novo Processo
      Então o usuario deveria ver a mensagem "Processo foi criado com sucesso."
@ignore
    Cenario: Excluir um novo Processo
      E criado um processo "Processo foi criado com sucesso."
      E clicar em voltar
      E o usuario clicar em excluir no registro criado
      E clicar em confirmar na mensagem de deletar
      Então o registro não dever ser apresentado na lista de processo

    Cenario: Consultar Processo
      E criado um processo "Processo foi criado com sucesso."
      E clicar em voltar
      E clicar em Mostrar no registro criado
      Entao Deve ser apresentado o registro criado








