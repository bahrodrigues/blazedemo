package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage extends CommomPage{

    //construtor

    public ReservePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //elementos mapeados
    @FindBy(css = "h3")
    WebElement fightsHeader; // titulo da pagina


    //funciona so para selecionar botao fixo
    @FindBy(css = "tr:nth-child(2) .btn")
    WebElement btnSelectFlight;

    //funciona para selecionar botoes em tabelas
    public By byOrder(int ordem_do_voo){
        return By.xpath("//table[@class='table']/tbody/tr[" + ordem_do_voo + "]//input[@type='submit']");
    }

    //ações dos elementos mapeados
    //o mapeamento não tem asserts

    public String lerTituloVoos(){
        return fightsHeader.getText();
    }

    //funciona so para selecionar botao fixo
    public void selecionarVoo(){
        btnSelectFlight.click();
    }

    //funciona para selecionar botoes em tabelas
    public void selecionarVooDinamico(int ordem_do_voo){
        driver.findElement(byOrder(ordem_do_voo));
    }

    
}
