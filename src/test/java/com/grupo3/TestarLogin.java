
package com.grupo3;
import com.util.Teste;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TestarLogin extends Teste{
    
    
    private final String url = "https://accounts.google.com/signup/v2/webcreateaccount?service=accountsettings&continue=https%3A%2F%2Fmyaccount.google.com%2Fintro%3Futm_source%3DOGB%26utm_medium%3Dapp&flowName=GlifWebSignIn&flowEntry=SignUp";
    private final String url2 = Teste.DOMINIO;
    @Before
    public void before() {
        super.conectar(url);
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
    public void testarCerto(){
        CadastroGmailPojo cadastroGmail = PageFactory.initElements(super.getDriver(), CadastroGmailPojo.class);
        cadastroGmail.logar("Geyko", "Jorno", "gjkon21", "gj098&&&#");
        assertFalse(cadastroGmail.checkUrl(this.url));
       
    }
    
    @Test
    public void testarErrado(){
        CadastroGmailPojo cadastroGmail = PageFactory.initElements(super.getDriver(), CadastroGmailPojo.class);
        cadastroGmail.logar("Diogo", "Souza", "diogosos", "gj098&&&#");
        assertTrue(cadastroGmail.checkUrl(this.url));
    }

    
}
