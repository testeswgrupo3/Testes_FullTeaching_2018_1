package testes;

import java.util.Date;
import java.util.Random;
import util.Teste;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojos.PojoPaginaCursosProfessor;
import pojos.PojoPaginaInicial;
import pojos.PojoPaginaInicialProfessor;

public class TesteForum extends Teste{
    public TesteForum() {
        
    }
    
    @Before
    public void before() {
        super.conectar(Teste.DOMINIO);
        PojoPaginaInicial paginaInicial = PageFactory.initElements(super.getDriver(), PojoPaginaInicial.class);
        paginaInicial.logar("teacher@gmail.com","pass");
        assertTrue(paginaInicial.checkUrl(Teste.DOMINIO)); 
        PojoPaginaInicialProfessor paginaInicialProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        assertTrue("NAO FOI POSSIVEL SELECIONAR UM CURSO",paginaInicialProfessor.selecionarUltimoCursoCadastrado());
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
    public void postarComentario() {
           PojoPaginaCursosProfessor paginaCursosProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaCursosProfessor.class);
           assertTrue("NÃO FOI POSSÍVEL IR A ABA FÓRUM",paginaCursosProfessor.selecionarAbaForum());
           assertTrue("NÃO FOI POSSÍVEL CRIAR O FORUM",paginaCursosProfessor.iniciarForum(data+"_postarComentario", "meu comentario"));
    }
    @Test
    public void criarForumComComentarioEmBranco() {
           PojoPaginaCursosProfessor paginaCursosProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaCursosProfessor.class);
           assertTrue("NÃO FOI POSSÍVEL IR A ABA FÓRUM",paginaCursosProfessor.selecionarAbaForum());
           assertFalse("FOI POSSÍVEL CRIAR O FORUM COM COMENTARIO EM BRANCO",paginaCursosProfessor.iniciarForum(data+"criarForumComComentarioEmBranco", ""));
    }
    @Test
    public void postarComentarioEmBranco() throws InterruptedException {
           PojoPaginaCursosProfessor paginaCursosProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaCursosProfessor.class);
           assertTrue("NÃO FOI POSSÍVEL IR A ABA FÓRUM",paginaCursosProfessor.selecionarAbaForum());
           assertTrue("NÃO FOI POSSÍVEL CRIAR O FORUM",paginaCursosProfessor.iniciarForum(data+"postarComentarioEmBranco", "primeiro comentario do fórum"));
           Thread.sleep(1000);
           assertFalse("FOI POSSÍVEL INSERIR UM COMENTÁRIO EM BRANCO",paginaCursosProfessor.inserirComentarioNoForum(""));
    }
 
    
    
}
