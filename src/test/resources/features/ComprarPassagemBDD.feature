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

