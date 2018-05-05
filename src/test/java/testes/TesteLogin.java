
package testes;
import pojos.PojoPaginaInicial;
import util.Teste;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TesteLogin extends Teste{
    
    
    private static final String URL = Teste.DOMINIO;
    @Before
    public void before() {
        super.conectar(URL);
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
    public void testarDadosCorretos(){
        PojoPaginaInicial paginaInicial = PageFactory.initElements(super.getDriver(), PojoPaginaInicial.class);
        paginaInicial.logar("student1@gmail.com","pass");
        assertTrue("Erro ao efetuar login",paginaInicial.checkUrl(TesteLogin.URL));
       
    } 
    @Test
    public void testarDadosIncorretos(){
        PojoPaginaInicial paginaInicial = PageFactory.initElements(super.getDriver(), PojoPaginaInicial.class);
        paginaInicial.logar("student1@gmail.com","ass");
        assertFalse("Login efetuado com sucesso",paginaInicial.checkUrl(TesteLogin.URL));
       
    }
}
