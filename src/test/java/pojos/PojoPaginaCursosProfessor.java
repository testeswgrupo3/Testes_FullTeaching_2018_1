/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PojoPaginaCursosProfessor {
    /**
    * Visa representar as paginas apos um professor selecionar um curso 
    * é onde aparece as diversas abas como forum, atividades, arquivos,participantes, seção
    * não sei se é necessário criar uma para cada uma dessas abas
    * @author luisfelipe
    */
    @FindBy(xpath = " //*[@id='md-tab-label-0-0']/div")
    private WebElement homeCurso;
    @FindBy(xpath = " //*[@id=\"edit-course-info\"]")
    private WebElement editInfoCursoBnt;
    @FindBy(xpath = "//*[@id='md-tab-content-0-0']/div/div[2]/p-editor/div/div[2]/div[1]")
    private WebElement texBoxInfoCurso;
    @FindBy(xpath = "//*[@id='send-info-btn']")
    private WebElement sendInfoCurso;
    /*@FindBy(xpath = "//*[@id=\"md-tab-content-1-0\"]/div/div[2]/p[1]") /// caso o curso tenha informacao vai ser carregado se nao tiver  nao encontra esse elemento
    private WebElement infoCurso;*/
    
    @FindBy(xpath = "//*[@id='md-tab-label-0-0']/div")
    private WebElement forumCurso;
    @FindBy(xpath = "//*[@id=\"edit-forum-icon\"]")
    private WebElement ativarForumCursoBnt;
    @FindBy(xpath = "//*[@id=\"add-entry-icon\"]")
    private WebElement newForumCursoBnt;
    @FindBy(className = "entry-title waves-effect")
    private List<WebElement> listaEntradasForum;
     
    @FindBy(xpath = "//*[@id=\"row-of-comments\"]/div[1]/div[2]/a/i")
    private WebElement newCommetForumCursoBnt;
    @FindBy(className = "material-icons replay-icon")
    private List<WebElement> answerComments;
    @FindBy(className = "message-itself forum-comment-msg")
    private List<WebElement> listaComents;
    
    
    @FindBy(xpath = "//*[@id='md-tab-label-0-0']/div")
    private WebElement sessionsCurso;
    @FindBy(xpath = "//*[@id=\"add-session-icon\"]")
    private WebElement addSessionCursoBnt;
    @FindBy(className = "edit-session-icon material-icons forum-icon")
    private List<WebElement> listEditSessionCursoBnt;                        ///li identifica qual sessão
    @FindBy(className = "col l7 m6 s6 session-ready")
    private WebElement listSessions;
    
    
    
    @FindBy(xpath = "//*[@id='md-tab-label-0-0']/div")
    private WebElement filesCurso;    
    @FindBy(xpath = "//*[@id=\"add-files-icon\"]")
    private WebElement addNewFileGrup;
    @FindBy(xpath = "//*[@id=\"md-tab-content-3-3\"]/div/div[1]/i")
    private WebElement editFile;
    
    @FindBy(className = "button-add-file waves-effect btn-flat add-file-btn")
    private List<WebElement> listAddFilesPerGrupsAndSubgrups;     
    @FindBy(className = "button-add-file waves-effect btn-flat add-subgroup-btn")
    private List<WebElement> listAddSubgrupPerGrupsAndSubgrups;   
    @FindBy(className = "material-icons action-file-icon")
    private List<WebElement> listEditNameGrupPerGrupsAndSubgrups;    
    @FindBy(className = "edit-file-name-icon material-icons action-file-icon")
    private List<WebElement> listEditFileNameGrupPerGrupsAndSubgrups; 
    @FindBy(className = "material-icons action-file-icon delete-filegroup-icon")
    private List<WebElement> listRemvGrupPerGrupsAndSubgrups; 
    
    @FindBy(xpath = "//*[@id=\"input-file-title\"]")
    private WebElement InputNameGrupFile;
    @FindBy(xpath = "//*[@id=\"put-modal-btn\"]")
    private WebElement SendNameGrupFile;
    //*[@id="input-file-title"]
    /**
     * kkkk Como dar um selct file não sei
     */
    
    
    @FindBy(xpath = "//*[@id='md-tab-label-0-0']/div")
    private WebElement participantesCurso;
    @FindBy(xpath = "//*[@id=\"add-attenders-icon\"]")
    private WebElement addParticipantesCurso;
    @FindBy(xpath = "//*[@id=\"edit-attenders-icon\"]")
    private WebElement editPparticipantesCurso;
   
    @FindBy(xpath = "//*[@id=\"input-attender-simple\"]")
    private WebElement emailParticipantesCurso;
    @FindBy(xpath = "//*[@id=\"put-modal-btn\"]")
    private WebElement convidarParticipantesCurso;
  
    @FindBy(className = "p-name")
    private List<WebElement> listEmailParticipantes; 
    @FindBy(className = "material-icons del-attender-icon")
    private List<WebElement> listRemoveParticipantes; 
    
    private final WebDriver driver;
        
    public PojoPaginaCursosProfessor(WebDriver driver){
        this.driver=driver;
    }
    public boolean inserirInformacoes(String informacoes){
        editInfoCursoBnt.click();
        texBoxInfoCurso.clear();
        texBoxInfoCurso.sendKeys(informacoes);
        sendInfoCurso.click();
        WebElement infoCurso = driver.findElement(By.xpath("//*[@id=\"md-tab-content-0-0\"]/div/div[2]/p[1]"));
        System.out.println("CVDSAGDSFDSAFDSFSDAFDSFSADFSDFSDAFSADFDSF  "+infoCurso.getText());
        if(informacoes.equals(infoCurso.getText())){
            return true;
        } else{
            return false;
          }
    }
    
}
