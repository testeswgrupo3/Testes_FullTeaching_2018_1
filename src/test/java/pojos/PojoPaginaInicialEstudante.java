/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Pagina apos um estudante efetuar login
 * @author luisfelipe
 */
public class PojoPaginaInicialEstudante {
    
    @FindBy(id = "courses-button")
    private WebElement coursses;
    @FindBy(id = "settings-button")
    private WebElement settingsButton;
    @FindBy(xpath = "/html/body/app/div/main/app-settings/div/div[5]/div[1]/div/div/div/label/span")
    private WebElement settings1;
    @FindBy(xpath = "/html/body/app/div/main/app-settings/div/div[5]/div[2]/div/div/div/label/span")
    private WebElement settings2;
    @FindBy(xpath = "/html/body/app/div/main/app-settings/div/div[5]/div[3]/div/div/div/label/span")
    private WebElement settings3;
    @FindBy(xpath = "/html/body/app/div/main/app-settings/div/div[5]/div[4]/div/div/div/label/span")
    private WebElement settings4;
    @FindBy(xpath = "/html/body/app/div/main/app-settings/div/div[5]/div[5]/div/div/div/label/span")
    private WebElement settings5;
    
    private final WebDriver driver;
    private String url;
    
    public PojoPaginaInicialEstudante(WebDriver driver){
        this.driver=driver;
    }
    
    public void acessarSettings(){
        this.settingsButton.click();
    }
    
    public boolean alterarSettings1(){
        this.settings1.click();
        return true;
    }
    
    public boolean alterarSettings2(){
        this.settings2.click();
        return true;
    }
    
    public boolean alterarSettings3(){
        this.settings3.click();
        return true;
    }
    
    public boolean alterarSettings4(){
        this.settings4.click();
        return true;
    }
    
    public boolean alterarSettings5(){
        this.settings5.click();
        return true;
    }
}
