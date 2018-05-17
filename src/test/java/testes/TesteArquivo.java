/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pojos.PojoPaginaCursosProfessor;
import pojos.PojoPaginaInicial;
import pojos.PojoPaginaInicialProfessor;
import util.Teste;
import static util.Teste.data;

/**
 *
 * @author luisfelipe
 */
public class TesteArquivo extends Teste{
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
