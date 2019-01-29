package com.Intive.Patronage.tests.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    private static String CONTACTUS_URL = "http://automationpractice.com/index.php";
    private WebDriver driver;

    @FindBy(how = How.ID, using = "submitMessage")
    public WebElement submitButtonContactUs;

    @FindBy(how = How.CLASS_NAME, using = "alert-danger")
    public WebElement alertPopUp;

    @FindBy(how = How.XPATH, using = "//ol/li[1]")
    public WebElement alertText;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailAddress;

    @FindBy(how = How.ID, using = "message")
    public WebElement message;

    @FindBy(how = How.ID, using = "id_contact")
    public WebElement subject;

    @FindBy(how = How.CLASS_NAME, using = "alert-success")
    public WebElement sendSucces;

    @FindBy(how = How.ID, using = "id_order")
    public WebElement orderReference;

    public ContactUsPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void alertDisplayed(WebElement element) { element.isDisplayed(); }

    public void alertMessageCorrect(String message, WebElement element) {
        String receivedMessage = element.getText();
        Assert.assertEquals(message, receivedMessage);
    }

    public void inputText(String text, WebElement element) {
        element.sendKeys(text);
    }

    public void selectSubject(WebElement element) {
        element.click();
        element.sendKeys(Keys.DOWN);
        element.sendKeys(Keys.RETURN);
    }
}
