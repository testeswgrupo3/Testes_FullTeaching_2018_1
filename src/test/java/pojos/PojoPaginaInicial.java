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
    @FindBy(css = "div.rc-anchor.rc-anchor-normal.rc-anchor-light")
    private WebElement check;
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
     
    public boolean cadastrarNovoAluno(String email,String nome,String senha,String confirmacaoSenha) {
        try {
            signupInformarNovaConta.click();
            this.email.sendKeys(email);
            this.name.sendKeys(nome);
            this.password.sendKeys(senha);
            this.confirmPassword.sendKeys(confirmacaoSenha);
            this.check.click();
            this.signupConfirmarNovaConta.click();
            Thread.sleep(1000);
            menuLogout.click();
            logout.click();
            Thread.sleep(1000);
            return true;   
        } catch (Exception ex) {
            Logger.getLogger(PojoPaginaInicial.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
