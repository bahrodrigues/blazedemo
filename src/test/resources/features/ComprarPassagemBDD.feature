#language: pt
Funcionalidade: Comprar Passagem
    Escolher e comprar passagens aereas - essa forma de escrever se chama Gherkin

    Cenario: Comprar com Sucesso
        Dado que acesso o site "https://blazedemo.com/"
        Quando escolho origem "Boston" e destino "Cairo" 
        E clico no botao 'Find Flights'
        Entao visualizo a lista de voos

    Esquema do Cenario: Comprar com Sucesso DDT
        Dado que acesso o site "https://blazedemo.com/"
        Quando escolho a <origem> e <destino> 
        E clico no botao 'Find Flights'
        Entao visualizo a lista de voos
    Exemplos:
    | origem      | destino  |
    | "São Paolo" | "Cairo"  |
    | "Boston"    | "London" |


    Esquema do Cenario: Login Positivo
        Dado que acesso a pagina de Login
        Quando preencho o <email> e a <senha> 
        E clico no botao Login
        Entao exibe a mensagem de Login com Sucesso 
        Exemplos:
        |email             |senha      |
        |cliente@teste.com | Laranja25 | #1 VV

    Esquema do Cenario: Login Negativo
        Dado que acesso a pagina de Login
        Quando preencho o <email> e a <senha> 
        E clico no botao Login
        Entao exibe a mensagem de email ou senha incorretos

        Exemplos:
        |email                |senha      |
        |cliente@teste.com    | Laranja24 | #2 VF
        |cliente123@teste.com | Laranja25 | #3 FV
        |cliente123@teste.com | Laranja24 | #3 FF

    Esquema do Cenario: Login 
        Dado que acesso a pagina de Login
        Quando preencho o <email> e a <senha> 
        E clico no botao Login
        Entao exibe a <mensagem> 
        Exemplos:
        |email                |senha      |tipo |mensagem                 |
        |cliente@teste.com    | Laranja25 | P   |Login com sucesso        | #1 VV
        |cliente@teste.com    | Laranja24 | N   |email e senha incorretos |#2 VF
        |cliente123@teste.com | Laranja25 | N   |email e senha incorretos |#3 FV
        |cliente123@teste.com | Laranja24 | N   |email e senha incorretos |#3 FF


