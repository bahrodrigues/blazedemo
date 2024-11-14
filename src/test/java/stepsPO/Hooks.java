package stepsPO;

import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Base;

public class Hooks{
    Base base;

    // constructor

    public Hooks(Base base){
        this.base = base;
    }

    @Before
    public void iniciarPO(){
        WebDriverManager.chromedriver().setup();
        base.driver = new ChromeDriver();
        base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100000));
        base.driver.manage().window().maximize();
    }

    @After
    public void finalizarPO(){
        base.driver.quit();
    }

}