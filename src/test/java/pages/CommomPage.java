package pages;

import org.openqa.selenium.WebDriver;

public class CommomPage {
    
    public WebDriver driver; // bola quando recebe o passe
    
    // o construtor é o que conecta o exterior com interior da classe
    public CommomPage(WebDriver driver){
        this.driver = driver;
    }

    public String lerNomeGuia(){
        return driver.getTitle(); //le titulo da guia/pagina
    }
    
    // ToDo: vamos colocar funções em comum nas páginas aqui
}
