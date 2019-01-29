package com.Intive.Patronage.tests.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GooglePage {

    private static String GOOGLE_URL = "https://www.google.com/";
    private WebDriver driver;

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchField;

    @FindBy(how = How.ID, using = "rcnt")
    private WebElement resultsWebPart;

    @FindBy (how = How.CLASS_NAME, using = "LC20lb")
    public WebElement firstSearchResult;

    public GooglePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openGooglePage() {
        driver.get(GOOGLE_URL);
    }

    public void searchInGoogle(String searchPhrase) {
        searchField.sendKeys(searchPhrase);
        searchField.sendKeys(Keys.ENTER);
    }

    public void verifyIfResultsAreVisible() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(resultsWebPart));
    }
}
