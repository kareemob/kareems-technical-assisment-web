package com.webook.tests;

import com.webook.base.BaseTest;
import com.webook.models.User;
import com.webook.pages.ExplorePage;
import com.webook.pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(description = "Should Be Able to Search or Filter Any Activity")
    public void shouldBeAbleToSearchFilterAnyEvent(){
        user = new User();
        LandingPage.getInstance().load(driver);
        LandingPage.getInstance().search(driver);
        Assert.assertFalse(ExplorePage.getInstance().filterByLocation(driver, "Riyadh"));
    }
}
