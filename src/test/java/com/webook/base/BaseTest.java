package com.webook.base;

import com.webook.factory.DriverFactory;
import com.webook.models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected User user;
    @BeforeMethod
    public void setup() {
        driver = new DriverFactory().initializeDriver();
    }

    //@AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
