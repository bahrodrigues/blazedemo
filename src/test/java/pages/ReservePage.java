package pages;

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


    //ações dos elementos mapeados
    //o mapeamento não tem asserts
    public String lerTituloVoos(){
        return fightsHeader.getText();
    }
}
