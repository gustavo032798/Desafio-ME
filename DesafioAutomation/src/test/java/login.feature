#language: pt

Funcionalidade: Login
    Sendo um usuário cadastrado
    Quero acessar o site
    Para que eu possa comprar uma peça de roupa

    Cenario: Login do usuario

        Dado que acesso a pagina principal, clico em Sign in pra realizar o login
        Quando submeto minhas credenciais com "gustavo@mercadoeletronico.com" e "naotemsenha"
        Entao devo ver o meu nome "Gustavo Carrança" como usuario logado

    Esquema do Cenario: Tentar logar

        Dado que acesso a pagina principal, clico em Sign in pra realizar o login
        Quando submeto minhas credenciais com "<email_input>" e "<senha_input>"
        Entao vejo a mensagem de erro: "<mensagem_output>"

        Exemplos:
            | email_input                   | senha_input    | mensagem_output            |
            |                               |                | An email address required. |
            |                               | naotemsenha    | An email address required. |
            | gustavo@mercadoeletronico.com |                | Password is required.      |
            | gustavo@mercadoeletronico.com | senhaincorreta | Authentication failed.     |
            | gustavo@naocadastrado.com     | naotemsenha    | Authentication failed.     |
            | gustavo!mercadoeletronico.com | naotemsenha    | Invalid email address.     |