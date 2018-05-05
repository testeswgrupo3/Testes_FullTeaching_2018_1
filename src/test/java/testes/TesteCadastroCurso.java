package testes;


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
import pojos.PojoPaginaInicial;
import pojos.PojoPaginaInicialProfessor;

public class TesteCadastroCurso extends Teste{
    
    private static final String URL = Teste.DOMINIO +"courses";
    public TesteCadastroCurso() {
        
    }
    
    @Before
    public void before() {
        /**
         * Levando em conta o que foi defino no testlik como pré requisito para cada tipo de teste
         * Neste em questão tem como pré requisito estar logado no sistema em uma conta de professor
         */
        super.conectar(Teste.DOMINIO);
        PojoPaginaInicial paginaInicial = PageFactory.initElements(super.getDriver(), PojoPaginaInicial.class);
        paginaInicial.logar("teacher@gmail.com","pass");
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
    public void testCadastroCurso() throws Exception {
        PojoPaginaInicialProfessor paginaInicialProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        Random aleatorio = new Random(0);
        assertTrue("CURSO NAO FOI CADASTRADO",paginaInicialProfessor.cadastarNovoCurso("Curso"+aleatorio.nextInt()));
    }
    
    @Test
    public void testEditarCurso() throws Exception {
        PojoPaginaInicialProfessor paginaInicialProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        assertTrue("FALHA AO EDITAR O CURSO",paginaInicialProfessor.editarPrimeiroCurso("curso editado 333"));
    }
    
    @Test
    public void cadastrarCursoRepetido() throws Exception {
        PojoPaginaInicialProfessor paginaInicialProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        Random aleatorio = new Random(10);
        int num = aleatorio.nextInt();
        Thread.sleep(1000);
        assertTrue("CURSO NAO FOI CADASTRADO",paginaInicialProfessor.cadastarNovoCurso("Curso"+num));
        Thread.sleep(3000);
        assertFalse("CURSO REPETIDO CADASTRADO",paginaInicialProfessor.cadastarNovoCurso("Curso"+num));
    }
    
    
}
