package pojos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PojoPaginaInicial {
    @FindBy(name= "password")
    private WebElement password;
    @FindBy(name= "email")
    private WebElement email;
    @FindBy(name= "nickName")
    private WebElement name;
    @FindBy(name= "confirmPassword")
    private WebElement confirmPassword;
    @FindBy(id = "courses-button")
    private WebElement login;
    @FindBy(id = "sign-up-btn")
    private WebElement signupConfirmarNovaConta;
    @FindBy(id = "log-in-btn")
    private WebElement loginBnt;
    @FindBy(id = "signUpButton")
    private WebElement signupInformarNovaConta;
    @FindBy(id = "download-button")
    private WebElement wellcomeBnt;
    @FindBy(xpath = "//*[@id=\"arrow-drop-down\"]")
    private WebElement menuLogout;
    @FindBy(xpath = "//*[@id=\"logout-button\"]")
    private WebElement logout;
    
    
    
    private final WebDriver driver;
    private String url;
    public PojoPaginaInicial(WebDriver driver){
        this.driver=driver;
    }
    public void logar(String email, String senha){
        this.wellcomeBnt.click();
        this.email.sendKeys(email);
        this.password.sendKeys(senha);
        this.loginBnt.click();
    }
    
     public boolean checkUrl(String url){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PojoPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return !(driver.getCurrentUrl().equals(url));
    }
     
}
