package stepsPO;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.HomePage;
import pages.ReservePage;
import pages.Base;
import pages.CommomPage;

public class ComprarPassagemPO {

    //Atributos - Ponto final/estação final
    final WebDriver driver;                  // Selenium só pode usar e devolver 
    //1 - declarar
    private HomePage homePage;               // só eu posso usar a home
    private ReservePage reservePage;         // só eu posso usar a reserve

    public String origem;
    public String destino;

    //constructor
    public ComprarPassagemPO(Base base){
        this.driver = base.driver;
    }

    // As anotações Before e After ficam no Hooks.java

    @Dado("que acesso o site {string} PO")
    public void que_acesso_o_site_po(String url) {
        homePage = new HomePage(driver); // 2 - instanciar
        homePage.acessarHomePage(url); // 3 - usar
        
        //validar se abriu a pagina correta atraves do nome da guia
        assertEquals("BlazeDemo", homePage.lerNomeGuia());
    }

    @Quando("escolho a {string} e {string} PO")
    public void escolho_a_e_po(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        homePage.selecionarDestino(origem,destino);
    }

    @E("clico no botao Find Flights PO")
    public void clico_no_botao_find_flights_po() {
        homePage.clicarFindFlights();
        //chama a pagina seguinte
        reservePage = new ReservePage(driver);
    }

    @Entao("visualizo a lista de voos PO")
    public void visualizo_a_lista_de_voos_po() {
        assertEquals("BlazeDemo - reserve", reservePage.lerNomeGuia());
        assertEquals("Flights from " + this.origem + " to " + this.destino + ":", reservePage.lerTituloVoos());
    }
}
