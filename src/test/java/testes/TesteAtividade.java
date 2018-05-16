/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import util.Teste;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pojos.PojoPaginaCursosProfessor;
import pojos.PojoPaginaInicial;
import pojos.PojoPaginaInicialProfessor;
/**
 *
 * @author luisfelipe
 */
public class TesteAtividade extends Teste {
    public TesteAtividade() {
        
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
         PojoPaginaInicialProfessor paginaInicialProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        assertTrue("NAO FOI POSSIVEL CADASTRAR UM CURSO",paginaInicialProfessor.cadastarNovoCurso(data+"_testeCadastroAtividades"));
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
    public void cadastrarAtividade() {
        PojoPaginaCursosProfessor paginaCursosProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaCursosProfessor.class);
        assertTrue("NÃO FOI POSSÍVEL IR A ABA SESSIONS",paginaCursosProfessor.selecionarAbaSessions());
        assertTrue("NÃO FOI POSSÍVEL CADASTRAR UMA NOVA ATIVIDADE",paginaCursosProfessor.criarNovaSessao(data+"cadastro_Atividade_1","Descricao da sessao","17-05-2018","20:50"));
    }
    @Test
    public void cadastrarVariasAtiviadesMesmoDia() {
        PojoPaginaCursosProfessor paginaCursosProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaCursosProfessor.class);
        assertTrue("NÃO FOI POSSÍVEL IR A ABA SESSIONS",paginaCursosProfessor.selecionarAbaSessions());
        for(int i = 0;i<5;i++){
            assertTrue("NÃO FOI POSSÍVEL CADASTRAR UMA NOVA ATIVIDADE",paginaCursosProfessor.criarNovaSessao(data+"_cadastro_Varias_Atividades_"+i,"Descricao da sessao","17-05-2018","20:"+(50+i)));
        }

    }
    
    @Test
    public void testVisualizarAtividade() throws Exception {
        PojoPaginaInicialProfessor paginaVisualizarAtividade = PageFactory.initElements(super.getDriver(), PojoPaginaInicialProfessor.class);
        Thread.sleep(1000);
        assertTrue("Visualizar atividade",paginaVisualizarAtividade.selecionarAtividade());
        Thread.sleep(1000);
        assertTrue("Visualizar atividade",paginaVisualizarAtividade.iconeAtividade());
    }
    
    @Test
    public void catastrarAtividadeDataAnterior() throws Exception {
        
        PojoPaginaCursosProfessor paginaCursosProfessor = PageFactory.initElements(super.getDriver(), PojoPaginaCursosProfessor.class);
        assertTrue("NÃO FOI POSSÍVEL IR A ABA SESSIONS",paginaCursosProfessor.selecionarAbaSessions());
        assertFalse("ATIVIDADE CADASTRADA A UMA DATA ANTERIOR A ATUAL",paginaCursosProfessor.criarNovaSessao(data+"cadastro_Atividade_1","Descricao da sessao","20-05-1996","20:50"));
    }
}
