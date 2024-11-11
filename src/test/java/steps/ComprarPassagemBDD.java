package steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class ComprarPassagemBDD {
    
    WebDriver driver; // objeto do selenium webdriver
    String origem;
    String destino;

    @Before
    public void iniciar(){
        WebDriverManager.chromedriver().setup(); //garantir o driver correto para o chrome
        driver = new ChromeDriver(); //instacia como chromedriver
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000)); //definir o tempo de espera implicita de 5 segundos
    }

    @After
    public void finalizar(){
        driver.quit(); //destruir o objeto do selenium webdriver
    }

    @Dado("que acesso o site {string}")
    public void que_acesso_o_site(String url) {
        driver.get(url);

    }

    @Quando("escolho origem {string} e destino {string}")
    @Quando("escolho a {string} e {string}")
    public void escolho_origem_e_destino(String origem, String destino) {
        {
            this.origem = origem; 
            WebElement comboOrigem = driver.findElement(By.name("fromPort"));
            comboOrigem.click();
            comboOrigem.findElement(By.xpath("//option[. = '" + origem + "']")).click();
        }
        {
            this.destino = destino;
            WebElement comboDestino = driver.findElement(By.name("toPort"));
            comboDestino.click();
            comboDestino.findElement(By.xpath("//option[. = '" + destino + "']")).click();
        }
    }

    @E("clico no botao {string}")
    public void clico_no_botao(String findFlights) {
        {
           driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        }
    }

    @Entao("visualizo a lista de voos")
    public void visualizo_a_lista_de_voos() {
        assertEquals("Flights from " + origem + " to " + destino + ":", driver.findElement(By.cssSelector("h3")).getText());
    }

}
