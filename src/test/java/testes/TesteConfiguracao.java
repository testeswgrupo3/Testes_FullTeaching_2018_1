package testes;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pojos.PojoPaginaInicial;
import pojos.PojoPaginaInicialEstudante;
import util.Teste;


public class TesteConfiguracao extends Teste{
    
    private static final String URL = Teste.DOMINIO;
    public TesteConfiguracao() {
        
    }
    
    @Before
    public void before() {
        super.conectar(Teste.DOMINIO);
        PojoPaginaInicial paginaInicial = PageFactory.initElements(super.getDriver(), PojoPaginaInicial.class);
        paginaInicial.logar("student1@gmail.com","pass");
        assertTrue(paginaInicial.checkUrl(Teste.DOMINIO));
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
    public void testConfiguracao() throws Exception {
        PojoPaginaInicialEstudante paginaInicialEstudante = PageFactory.initElements(super.getDriver(), PojoPaginaInicialEstudante.class);
        paginaInicialEstudante.acessarSettings();
        assertTrue("Configurações alteradas",paginaInicialEstudante.alterarSettings1());
        Thread.sleep(1000);
        assertTrue("Configurações alteradas",paginaInicialEstudante.alterarSettings2());
        Thread.sleep(1000);
        assertTrue("Configurações alteradas",paginaInicialEstudante.alterarSettings3());
        Thread.sleep(1000);
        assertTrue("Configurações alteradas",paginaInicialEstudante.alterarSettings4());
        Thread.sleep(1000);
        assertTrue("Configurações alteradas",paginaInicialEstudante.alterarSettings5());
        Thread.sleep(1000);
    }
    
    
}
