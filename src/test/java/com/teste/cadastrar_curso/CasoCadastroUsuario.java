package com.teste.cadastrar_curso;

import com.util.Teste;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CasoCadastroUsuario {
    
    @FindBy(id = "download-button")
    private WebElement botaoLogin;
    @FindBy(name = "email")
    private WebElement inputEmail;
    @FindBy(id = "password")
    private WebElement inputSenha;
    @FindBy(name = "log-in-btn")
    private WebElement botaoLoginSubmit;
    private final WebDriver driver;
    private final String email;
    private final String senha;

    public CasoCadastroUsuario(WebDriver driver) {
        this.driver = driver;
        this.email = "teacher@gmail.com";
        this.senha = "pass";
    }
    
    public void efetuarLogin(){        
        this.botaoLogin.click();
        
        this.inputEmail.sendKeys(this.email);
        this.inputSenha.sendKeys(this.senha);
        
        this.botaoLoginSubmit.click();
        
    }
    
}
