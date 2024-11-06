#language: pt
Funcionalidade: Comprar Passagem
    Escolher e comprar passagens aereas - essa forma de escrever se chama Gherkin
    
    Cenario: Comprar com Sucesso
        Dado que acesso o site "https://blazedemo.com/"
        Quando escolho origem "Boston" e destino "Cairo" 
        E clico no botao 'Find Flights'
        Entao visualizo a lista de voos

