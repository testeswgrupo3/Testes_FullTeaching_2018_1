/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class TesteArquivo extends Teste{
    @Before
    public void before() {
        super.conectar(Teste.DOMINIO);
        PojoPaginaInicial paginaInicial = PageFactory.initElements(super.getDriver(), PojoPaginaInicial.class);
        paginaInicial.logar("teacher@gmail.com","pass");
        assertTrue(paginaInicial.checkUrl(Teste.DOMINIO)); 
        PojoPaginaInicialProfessor paginaInicialProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        assertTrue("NAO FOI POSSIVEL CADASTRAR UM CURSO",paginaInicialProfessor.cadastarNovoCurso(data+"_testeInsercaoParticipante"));
        assertTrue("NAO FOI POSSIVEL SELECIONAR UM CURSO",paginaInicialProfessor.selecionarUltimoCursoCadastrado());
        
    }
    
    @After
    public void after() {
        encerrar();
    }
    
    @Test
    public void cadastrarNovoArquivo(){
        PojoPaginaCursosProfessor paginaCursosProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaCursosProfessor.class);
        assertTrue("NÃO FOI POSSÍVEL IR A ABA ARQUIVOS",paginaCursosProfessor.selecionarAbaArquivos());
        assertTrue("NÃO FOI POSSÍVEL CARREGAR UM NOVO ARQUIVO NO CURSO",paginaCursosProfessor.inserirNovoArquivo());
    }
}
