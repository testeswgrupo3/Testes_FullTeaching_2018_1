package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Teste {

    private WebDriver driver;
    public static final String DOMINIO = "https://localhost:5000/";
    
    public void conectar(String url) {
        /**
         * se caso alguem quiser usar diferente
         */
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        driver = new FirefoxDriver();
        /*System.setProperty("webdriver.chrome.driver", "drivers/chrome");
        driver = new ChromeDriver();*/
        driver.get(url);
    }

    public void encerrar() {
        driver.close();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
