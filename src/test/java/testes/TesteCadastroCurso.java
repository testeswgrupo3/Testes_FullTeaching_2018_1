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

public class TesteCadastroCurso extends Teste{
    
    private static final String URL = Teste.DOMINIO +"courses";
    public TesteCadastroCurso() {
        
    }
    
    @Before
    public void before() {
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
        assertTrue("CURSO NAO FOI CADASTRADO",paginaInicialProfessor.cadastarNovoCurso(data+"_testCadastroCurso_Curso"+aleatorio.nextInt()));
    }
    
    @Test
    public void testEditarCurso() throws Exception {
        PojoPaginaInicialProfessor paginaInicialProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        assertTrue("CURSO NAO FOI CADASTRADO",paginaInicialProfessor.cadastarNovoCurso(data+"_cursoParaEditar"+aleatorio.nextInt()));
        assertTrue("FALHA AO EDITAR O CURSO",paginaInicialProfessor.editarUltimoCursoCadastrado(data+"_Curso Editado"));
    }
    
    @Test
    public void cadastrarCursoRepetido() throws Exception {
        PojoPaginaInicialProfessor paginaInicialProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        int num = aleatorio.nextInt();
        String nomeCurso =data+"_cadastrarCursoRepetido_Curso"+num;
        Thread.sleep(1000);
        assertTrue("CURSO NAO FOI CADASTRADO",paginaInicialProfessor.cadastarNovoCurso(nomeCurso));
        Thread.sleep(1000);
        assertFalse("CURSO REPETIDO CADASTRADO",paginaInicialProfessor.cadastarNovoCurso(nomeCurso));
    }

    @Test
    public void inserirInformaçõesCurso() throws InterruptedException{
        PojoPaginaInicialProfessor paginaInicialProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        String nomeCurso =data+"_inserirInformaçõesCurso_Curso" + aleatorio.nextInt();
        assertTrue("CURSO NAO FOI CADASTRADO",paginaInicialProfessor.cadastarNovoCurso(nomeCurso));
        Thread.sleep(1000);
        assertTrue("NAO FOI POSSIVEL SELECIONAR UM CURSO",paginaInicialProfessor.selecionarUltimoCursoCadastrado());
        Thread.sleep(1000);
        PojoPaginaCursosProfessor paginaCursosProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaCursosProfessor.class);
        assertTrue("Não foi possível alterar informaçẽos do curso corretamente", paginaCursosProfessor.inserirInformacoes("Olha essa infomacao cara"));
    }
    
    
}
