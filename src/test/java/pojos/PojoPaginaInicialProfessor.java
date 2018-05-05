/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;


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
    @FindBy(id = "submit-post-course-btn")
    private WebElement confirmNewCourse; 
    
      
            
    @FindBy(css = "div[class^='collection-item'].row session-list-item valign-wrapper.col l2 m2 s2 right-align no-padding-lateral.material-icons course-put-icon")
    private WebElement editFirsCourse;
   
    private final WebDriver driver;

    public PojoPaginaInicialProfessor(WebDriver driver) {
        this.driver = driver;
    }
    
    public void cadastarNovoCurso(String nome){
        addCourse.click();
        nameNewCourse.sendKeys(nome);
        confirmNewCourse.click();
    }
    public void editarPrimeiroCurso(String nome){
        editFirsCourse.click();
        nameNewCourse.sendKeys(nome);
        confirmNewCourse.click();
    }
    
}
