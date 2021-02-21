#language: pt

Funcionalidade: Cadastro
    Sendo um visitante do site
    Quero fazer o meu cadastro
    Para que eu possa comprar um produto

    Cenario: Cadastro com Sucesso

        Dado que acesso a pagina principal, clico em Sign in pra realizar o cadastro
            E preencho um novo email
        Quando preencho o formulario com os campos obrigatorios
        Entao devo ser redirecionado para a pagina "MY ACCOUNT"

    Cenario: Tentar Cadastrar sem Preencher os Campos Obrigatorios

         Dado que acesso a pagina principal, clico em Sign in pra realizar o cadastro
            E preencho um novo email
        Quando tento dar prosseguimento do cadastro sem ter digitado os campos obrigatorios
        Entao devo ver o erro: "There are 8 errors"

    Esquema do Cenario: Tentar Cadastrar com Email Incorreto ou Cadastrado

        Dado que acesso a pagina principal, clico em Sign in pra realizar o cadastro
        Quando preencho o campo email com: "<email_input>"
        Entao devo ver uma mensagem de alerta "<mensagem_output>"

        Exemplos:
            | email_input                   | mensagem_output                                                                                                      |
            |                               | Invalid email address.                                                                                               |
            | gustavo.com                   | Invalid email address.                                                                                               |
            | gustavo!teste.com             | Invalid email address.                                                                                               |
            | gustavo@testecom              | Invalid email address.                                                                                               |
            | gustavo@mercadoeletronico.com | An account using this email address has already been registered. Please enter a valid password or request a new one. |
            