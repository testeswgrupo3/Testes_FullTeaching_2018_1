package pojos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PojoPaginaCursosProfessor {
    @FindBy(xpath = " //*[@id='md-tab-label-0-0']/div")
    private WebElement homeCurso;
    @FindBy(xpath = " //*[@id=\"edit-course-info\"]")
    private WebElement editInfoCursoBnt;
    @FindBy(xpath = "//*[@id='md-tab-content-0-0']/div/div[2]/p-editor/div/div[2]/div[1]")
    private WebElement texBoxInfoCurso;
    @FindBy(xpath = "//*[@id='send-info-btn']")
    private WebElement sendInfoCurso;
    
    @FindBy(xpath = "//*[@id=\"md-tab-label-0-2\"]/div")
    private WebElement forumCurso;
    @FindBy(xpath = "//*[@id=\"edit-forum-icon\"]")
    private WebElement ativarForumCursoBnt;
    @FindBy(xpath = "//*[@id=\"put-delete-modal\"]/div/div/form/div[1]/label")
    private WebElement checkBoxActivateForum;
    @FindBy(xpath = " //*[@id=\"put-modal-btn\"]")
    private WebElement sendActivateFroum;
    @FindBy(xpath = "//*[@id=\"add-entry-icon\"]")
    private WebElement newForumCursoBnt;
    @FindBy(className = "message-itself")
    private List<WebElement> comentarios;
     
    @FindBy(xpath = "//*[@id=\"row-of-comments\"]/div[1]/div[2]/a/i")
    private WebElement newCommetForumCursoBnt;
    @FindBy(className = "material-icons replay-icon")
    private List<WebElement> answerComments;
    @FindBy(className = "message-itself forum-comment-msg")
    private List<WebElement> listaComents;
    @FindBy(xpath = "//*[@id=\"inputTitle\"]")
    private WebElement tituloForum;
    @FindBy(xpath = "//*[@id=\"inputComment\"]")
    private WebElement inputNewComment;
    @FindBy(xpath = "//*[@id=\"post-modal-btn\"]")
    private WebElement sendNewComment;
    @FindBy(css= "li.entry-title.waves-effect.teacher-forum")
    private List<WebElement> forumsDisponiveis;
    @FindBy(css = "div.col.l6.m6.s6")
    private List<WebElement> titulosForums;
    
    
    
    @FindBy(xpath = "//*[@id=\"md-tab-label-0-1\"]/div")
    private WebElement sessionsCurso;
    @FindBy(xpath = "//*[@id=\"md-tab-content-0-1\"]/div/div/a/i")
    private WebElement addSessionCursoBnt;
    @FindBy(css = "i.material-icons.forum-icon")
    private List<WebElement> listEditSessions;                       
    @FindBy(css = "li.session-data")
    private List<WebElement> listSessions;
    @FindBy(xpath = "//*[@id=\"inputTitle\"]")
    private WebElement tituloSessao;
    @FindBy(xpath = "//*[@id=\"inputComment\"]")
    private WebElement descricaoSessao;
    @FindBy(xpath = "//*[@id=\"inputDate\"]")
    private WebElement dataSessao;
    @FindBy(xpath = "//*[@id=\"inputTime\"]")
    private WebElement horaSessao;
    @FindBy(xpath = "//*[@id=\"post-modal-btn\"]")
    private WebElement sendNewSession;
    
    @FindBy(xpath = "//*[@id=\"md-tab-label-0-3\"]/div")
    private WebElement filesCurso;    
    @FindBy(xpath = "//*[@id=\"md-tab-content-0-3\"]/div/div[1]/a/i") 
    private WebElement addNewFileGrup;
    @FindBy(xpath = "//*[@id=\"inputTitle\"]") 
    private WebElement inputGroupName;
    @FindBy(xpath = "//*[@id=\"post-modal-btn\"]")
    private WebElement btnAddGroup;
    @FindBy(xpath = "//*[@id=\"md-tab-content-3-3\"]/div/div[1]/i")
    private WebElement editFile;
    @FindBy(xpath = "//*[@id=\"md-tab-content-0-3\"]/div/div[2]/app-file-group/div/div[1]/div[2]/a[1]")
    private WebElement listAddFilesPerGrupsAndSubgrups; 
    @FindBy(className = "button-add-file waves-effect btn-flat add-subgroup-btn")
    private List<WebElement> listAddSubgrupPerGrupsAndSubgrups;   
    @FindBy(xpath = "//*[@id=\"input-file-1\"]")
    private WebElement inputFile; 
    @FindBy(className = "btn button-small btn-uploader")
    private WebElement uploadFile; 
    @FindBy(className = "close-upload-modal-btn")
    private WebElement closeFile; 
    @FindBy(className = "chip chip-file truncate valign-wrapper disp-inline-flex")
    private List<WebElement> listFiles;    
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
   
    
    
    @FindBy(xpath = "//*[@id=\"md-tab-label-0-4\"]/div/i")
    private WebElement participantesCurso;
    @FindBy(xpath = "//*[@id=\"md-tab-content-0-4\"]/div/div[1]/a/i")
    private WebElement addParticipantesCurso;
    @FindBy(xpath = "//*[@id=\"md-tab-content-0-4\"]/div/div[1]/i")
    private WebElement editPparticipantesCurso;
    @FindBy(xpath = "//*[@id=\"inputAttenderSimple\"]")
    private WebElement emailParticipantesCurso;
    @FindBy(xpath = "//*[@id=\"put-modal-btn\"]")
    private WebElement sendConviteParticipantesCurso;
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
        if(informacoes.equals(infoCurso.getText())){
            return true;
        } else{
            return false;
          }
    }
    public boolean selecionarAbaForum(){
        try {
            forumCurso.click();
            return true;
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public boolean selecionarAbaParticipantes(){
        try {
            participantesCurso.click();
            return true;
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public boolean selecionarAbaSessions(){
        try {
            sessionsCurso.click();
            return true;
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
        public boolean selecionarAbaArquivos(){
        try {
            filesCurso.click();
            return true;
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public boolean iniciarForum(String titulo,String comentario){
        try {
            try {
                newForumCursoBnt.click();
            } catch (Exception e) {
                Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
                if(!ativarForum()) return false;
                Thread.sleep(1000);
                newForumCursoBnt.click();
            }
            tituloForum.sendKeys(titulo);
            inputNewComment.sendKeys(comentario);
            sendNewComment.click();
            Thread.sleep(1000);
            forumsDisponiveis.get(forumsDisponiveis.size()-1).click();
            WebElement tituloForum = driver.findElement(By.xpath("//*[@id=\"row-of-comments\"]/div[1]/div[1]/div/div[1]"));                          
            if(tituloForum.getText().equals(titulo)){
                Thread.sleep(1000);
                return comentarios.get(0).getText().equals(comentario);
            } 
            else return false;
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public boolean ativarForum(){
        try {
            ativarForumCursoBnt.click();
            checkBoxActivateForum.click();
            sendActivateFroum.click();
            return true;
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    public boolean selecionarUltimoForum(){
        try {
            forumsDisponiveis.get(forumsDisponiveis.size()-1).click();
            return true;
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } 
    }
    
    public boolean inserirComentarioNoForum(String comentario){
        try {
            newCommetForumCursoBnt.click();
            inputNewComment.sendKeys(comentario);
            sendNewComment.click();
            return comentarios.get(comentarios.size()-1).getText().equals(comentario);
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    public boolean inserirNovoParticipante(String email){
         try {
            addParticipantesCurso.click();
            emailParticipantesCurso.sendKeys(email);
            sendConviteParticipantesCurso.click();
            Thread.sleep(1000);
            return listEmailParticipantes.get(listEmailParticipantes.size()-1).getText().equals(email);
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    public boolean inserirNovoArquivo(){
         try {
            addNewFileGrup.click();
            inputGroupName.sendKeys("Teste Grupo");
            btnAddGroup.click();
            Thread.sleep(3000);
            int ant = listFiles.size();
            listAddFilesPerGrupsAndSubgrups.click();
            inputFile.sendKeys("drivers/teste");

            uploadFile.click();
            Thread.sleep(10000);
            closeFile.click();
            if(listFiles.size() > ant)
                return true;
            return false;
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    public boolean criarNovaSessao(String titulo,String descricao,String data,String hora){
       try {
           int tamanhoAnterior = listSessions.size();
           addSessionCursoBnt.click();
           tituloSessao.sendKeys(titulo);
           descricaoSessao.sendKeys(descricao);
           dataSessao.sendKeys("2018-03-22");
           horaSessao.sendKeys(hora);
           sendNewSession.click();
           Thread.sleep(1000);
           if(tamanhoAnterior==(listSessions.size()-1)) return true;
           else return false;
        } catch (Exception e) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } 
    }
    
    
    
}
