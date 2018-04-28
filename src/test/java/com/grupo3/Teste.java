/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author luisfelipe
 */
public class Teste {
    
    private  WebDriver driver;
    
    public Teste(){
        
    }
     public void conecta(String url) {
        /**
         * se caso alguem quiser usar diferente
         */
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        driver = new FirefoxDriver();
        /*System.setProperty("webdriver.chrome.driver", "../drivers/chrome");
        driver = new ChromeDriver();*/   
        driver.get(url);
    }


    public void encerra() {
        driver.close();
    }
    
    public WebDriver getDriver(){
        return this.driver;
    }
}
