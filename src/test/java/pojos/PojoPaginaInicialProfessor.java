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

public class PojoPaginaInicialProfessor {
    
    
    @FindBy(name= "ConfirmPasswd")
    private WebElement confirmPassword;
    @FindBy(id = "courses-button")
    private WebElement coursses;
    @FindBy(id = "settings-button")
    private WebElement settings;
    @FindBy(id = "arrow-drop-down")
    private WebElement dropDowArrow;
    @FindBy(id = "logout-button")
    private WebElement logoutButton;
    @FindBy(id = "contact-button")
    private WebElement contac;
    @FindBy(id = "add-course-icon")
    private WebElement addCourse; 
    @FindBy(id = "inputPostCourseName")
    private WebElement nameNewCourse; 
    @FindBy(id = "inputPutCourseName")
    private WebElement nameEditCourse; 
    @FindBy(id = "submit-post-course-btn")
    private WebElement confirmNewCourse; 
    @FindBy(id = "submit-put-course-btn")
    private WebElement confirmEditCourse; 
      
            
    @FindBy(css = "i.material-icons.course-put-icon")
    private List<WebElement> listEditarCurso;
    @FindBy(className = "collection-item")
    private List<WebElement> cursosCadastrados;
    @FindBy(className = "title")
    private List<WebElement> nomesCurso;
    
    private final WebDriver driver;

    public PojoPaginaInicialProfessor(WebDriver driver) {
        this.driver = driver;
    }
    
    public boolean cadastarNovoCurso(String nome){
        System.out.println("pojos.PojoPaginaInicialProfessor.cadastarNovoCurso()");
        addCourse.click();
        nameNewCourse.sendKeys(nome);
        confirmNewCourse.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PojoPaginaInicialProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        WebElement nomeCursoRescenCadastrado = driver.findElement(By.xpath("//*[@id='sticky-footer-div']/main/app-dashboard/div/div[3]/div/div[1]/ul/li["+cursosCadastrados.size()+"]/div/div[2]/span"));
        return nome.equals(nomeCursoRescenCadastrado.getText());
        
    }
    
    public boolean editarPrimeiroCurso(String nome){
        System.out.println("pojos.PojoPaginaInicialProfessor.editarPrimeiroCurso()");
        String nomeAnterior = nomesCurso.get(0).getText();
        System.out.println("Nome Anterior = "+nomeAnterior);
        listEditarCurso.get(0).click();
        nameEditCourse.clear();
        nameEditCourse.sendKeys(nome);
        confirmEditCourse.click();
        String novoNome = nomesCurso.get(0).getText();
        System.out.println("Novo nome = "+novoNome);
        return (novoNome.equals(nome));
    }
    
    public int selecionarCurso(String nome){
        int i = 0;
        for(WebElement c : nomesCurso){
            if(c.getText().equals(nome)){
                cursosCadastrados.get(i).click();
                 System.out.println("Curso Selecionado"+c.getText());
                return i;
            }
            i++;
        }
        System.out.println("Curso informado não cadastrado");
        return -1;
    }
    
}
