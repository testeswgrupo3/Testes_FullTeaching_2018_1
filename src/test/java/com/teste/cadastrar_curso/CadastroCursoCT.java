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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroCursoCT extends Teste{
    
    public CadastroCursoCT() {
    }
    
    @Before
    public void before() {
        super.conectar();
    }

    @After
    public void after() {
        encerrar();
    }

    @BeforeClass
    public static void beforeClass() {
        
    }

    @AfterClass
    public static void afterClass() {
        
    }
            
    @Test
    public void testCadastroCurso() throws Exception {
        CasoCadastroUsuario cadastroUsuario = PageFactory.initElements(super.getDriver(), CasoCadastroUsuario.class);
        cadastroUsuario.efetuarLogin();
    }
    
    
    
}
