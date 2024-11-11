// 1 - imports  bibliotecas
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; //biblioteca principal do selenium
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// 2 - classe informacoes

public class passagemTest {
    
    //2.1 atributos
    private WebDriver driver; //objeto do selenium

    //2.2 funções e métodos

    //antes do teste
    @BeforeEach
    public void setup() {
        driver = new ChromeDriver(); // instanciar o onbjeto do selenium como ChromeDriver
        driver.manage().window().maximize(); // maxima a janela do browser
    }

    //depois do teste
    @AfterEach 
    public void finish() {
       driver.quit(); // destroi o objeto selenium
    }
    
    //teste
    @Test
    public void comprarPassagem() {
        driver.get("https://blazedemo.com/"); //abre o site blazedemo
        // seleciona origem, destino e aperta o botão "Find flights"

        // origem
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Boston']")).click();
        }
        
        // destino
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.click();
            dropdown.findElement(By.xpath("//option[. = 'Roma']")).click();
        }
 
        // clicar no botão 'find fligths'
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        // transição de página

        // verifica se foi feito o login e se trocou de pagina
        assertEquals("Flights from Boston to Roma:", driver.findElement(By.cssSelector("h3")).getText());

        driver.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();

        //transicao de pagina

        assertEquals("Your flight from TLV to SFO has been reserved.", driver.findElement(By.cssSelector("h2")).getText()); 

        driver.findElement(By.name("inputName")).sendKeys("Bárbara Rodrigues");
        driver.findElement(By.name("address")).sendKeys("Rua dos Caracois, 123");
        driver.findElement(By.name("city")).sendKeys("Caracol");
        driver.findElement(By.name("state")).sendKeys("MG");
        driver.findElement(By.name("zipCode")).sendKeys("54321");
        WebElement cardtype = driver.findElement(By.name("cardType"));
        cardtype.click();
        cardtype.findElement(By.cssSelector("option:nth-child(2)")).click();
        driver.findElement(By.name("creditCardNumber")).sendKeys("624289428");
        driver.findElement(By.name("creditCardMonth")).clear();
        driver.findElement(By.name("creditCardMonth")).sendKeys("09");
        driver.findElement(By.name("creditCardYear")).clear();
        driver.findElement(By.name("creditCardYear")).sendKeys("2030");
        driver.findElement(By.name("nameOnCard")).sendKeys("Bárbara R.");
        driver.findElement(By.name("rememberMe")).click();
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    
    
    } // final da classe passagemTest

} //
