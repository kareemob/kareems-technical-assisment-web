package com.webook.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private WebDriver driver;
    public WebDriver initializeDriver() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":

                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("browser is not supported");
        }
        driver.manage().window().maximize();
        return driver;

    }
}
