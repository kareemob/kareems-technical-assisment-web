package com.webook.pages;

import com.webook.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

public class LandingPage {
    //Elements
    private static LandingPage landingPage;
    private WebDriverWait wait;
    private final By signupButton = By.cssSelector("[data-testid='header_nav_login_button']");
    private final By searchInput = By.cssSelector("[data-testid='home_search_input']");

    //Constructor
    private LandingPage(){}

    //Methods
    public static LandingPage getInstance() {
        if (landingPage == null) {
            landingPage = new LandingPage();
        }
        return landingPage;
    }

    public void load(WebDriver driver) {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
    }

    public void clickLogin(WebDriver driver) {
        driver.findElement(signupButton).click();
    }

    public Boolean isLoginButtonDisplayed(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(signupButton)).isDisplayed();
        }catch (RuntimeException exception){
            return false;
        }
    }

    public void search(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys("Experience", Keys.ENTER);
    }
}
