#language: pt
Funcionalidade: Comprar Passagem PO
    Escolher e comprar passagens aereas - essa forma de escrever se chama Gherkin

    Esquema do Cenario: Comprar com Sucesso PO
        Dado que acesso o site "https://blazedemo.com/" PO
        Quando escolho a <origem> e <destino> PO
        E clico no botao Find Flights PO
        Entao visualizo a lista de voos PO
        Quando clico na <ordem_do_voo> PO
    Exemplos:
    | origem      | destino  | ordem_do_voo |
    | "São Paolo" | "Cairo"  | 2            |
    | "Boston"    | "London" | 5            |

