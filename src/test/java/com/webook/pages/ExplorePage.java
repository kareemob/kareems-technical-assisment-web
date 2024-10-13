package com.webook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplorePage {
    //Elements
    private static ExplorePage explorePage;
    private WebDriverWait wait;
    private final By filterByLocation = By.cssSelector("[placeholder='Search']");
    private final By locationSearchInput = By.cssSelector("input[placeholder='Search']");
    private By dropdownOptions;


    //Constructor
    private ExplorePage(){}

    //Methods
    public static ExplorePage getInstance() {
        if (explorePage == null) {
            explorePage = new ExplorePage();
        }
        return explorePage;
    }
    private void setLocation(String location) {
        this.dropdownOptions = By.xpath("//div[contains(text(), '" + location + "')]");
    }
    private int getLocationCount(WebDriver driver,String location) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By locationCountXpath = By.xpath("//p[normalize-space()='" + location + ", Saudi Arabia']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationCountXpath));
        List<WebElement> locations = driver.findElements(locationCountXpath);
        return locations.size();
    }

    public boolean filterByLocation(WebDriver driver, String location){
        setLocation(location);
        int eventsLocationsNumberBefore = getLocationCount(driver, location);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterByLocation)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationSearchInput)).sendKeys(location);
        driver.findElement(dropdownOptions).click();
        int eventsLocationsNumberAfter = getLocationCount(driver, location);
        return eventsLocationsNumberAfter < eventsLocationsNumberBefore;
    }
}
