package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommomPage{
    
    // construtor
    public HomePage(WebDriver driver){
        super(driver); // driver herdado de CommomPage - super classe
        PageFactory.initElements(driver, this);
    }

    // elementos mapeados
    // mapeamento para os combos de origem e destino
    public By byLocal(String local){
        return By.cssSelector("option[value =\"" + local + "\"]"); 
        // toda vez que tem \"" a aspa vai ser ignorada na primeira vez mas ela vai ser usada na segunda vez
        // fica assim: option [value= "Rome"]
    }
        
    @FindBy(css = "input.btn.btn-primary")
    //@FindBy(css = ".btn.btn-primary")
    //@FindBy(css = "input[value]")
    WebElement btnFindFlights;

    //ações com os elementos

    public void selecionarDestino(String byOrigem, String byDestino){
        driver.findElement(byLocal(byOrigem)).click();
        driver.findElement(byLocal(byDestino)).click();
    }

    public void clicarFindFlights(){
        btnFindFlights.click();
    }

    public void acessarHomePage(String url){
        driver.get(url);
    }

}
