package com.webook.tests;

import com.webook.base.BaseTest;
import com.webook.models.User;
import com.webook.pages.LandingPage;
import com.webook.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest {

    @Test(description = "Should Be Able To Register")
    public void shouldBeAbleToRegister(){
        user = new User();
        LandingPage.getInstance().load(driver);
        LandingPage.getInstance().clickLogin(driver);
        LoginPage.getInstance().clickCreateAnAccount(driver);
        LoginPage.getInstance().register(user, driver);
        Assert.assertFalse(LandingPage.getInstance().isLoginButtonDisplayed(driver));
    }
}
