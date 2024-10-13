package com.webook.pages;

import com.webook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    //Elements
    private final By loginButton = By.cssSelector("[data-testid='auth_signup_button']");
    private final By firstNameInput = By.cssSelector("[data-testid='auth_firstname_input']");
    private final By lastNameInput = By.cssSelector("[data-testid='auth_lastname_input']");
    private final By emailInput = By.cssSelector("[data-testid='auth_signup_email_input']");
    private final By confirmEmailInput = By.cssSelector("[data-testid='auth_confirm_email_input']");
    private final By passwordInput = By.cssSelector("[data-testid='auth_signup_password_input']");
    private final By mobileNumberInput = By.cssSelector("[data-testid='auth_mobile_number_input']");
    private final By termsConditionsCheckBox = By.cssSelector("[data-testid='auth_terms_checkbox']");
    private final By createAccountButton = By.cssSelector("[data-testid='auth_signup_submit_button']");
    private WebDriverWait wait;
    private static LoginPage loginPage;

    //Constructor
    private LoginPage(){}

    //Methods

    public static LoginPage getInstance() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public void clickCreateAnAccount(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }
    public void register(User user, WebDriver driver){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(user.getFirstName());
        driver.findElement(lastNameInput).sendKeys(user.getLastName());
        driver.findElement(emailInput).sendKeys(user.getEmail());
        driver.findElement(confirmEmailInput).sendKeys(user.getEmail());
        driver.findElement(passwordInput).sendKeys(user.getPassword());
        driver.findElement(mobileNumberInput).sendKeys(user.getPhoneNumber());
        driver.findElement(termsConditionsCheckBox).click();
        driver.findElement(createAccountButton).click();
    }

}
