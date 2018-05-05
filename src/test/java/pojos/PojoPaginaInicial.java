/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author luisfelipe
 */
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
    @FindBy(className = "recaptcha-checkbox-checkmark")
    private WebElement check;
    
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
    public void cadastrarUsuário(String nome, String email, String senha,String confimacaoSenha){
        this.email.sendKeys(email);
        this.name.sendKeys(nome);
        this.password.sendKeys(senha);
        this.confirmPassword.sendKeys(confimacaoSenha);
        this.check.click();  
        this.signupConfirmarNovaConta.click();
    }
     public boolean checkUrl(String url){
        return !(driver.getCurrentUrl().equals(url));
    }
}
