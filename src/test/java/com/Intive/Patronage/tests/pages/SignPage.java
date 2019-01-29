package com.Intive.Patronage.tests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;

public class SignPage {

    private WebDriver driver;
    private static String SIGN_URL = "http://automationpractice.com/index.php?controller=my-account";
    public void signInPage() {
        driver.get(SIGN_URL);
    }


    @FindBy(how = How.CLASS_NAME, using = "alert-danger")
    public WebElement errorPopUp;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement password;

    @FindBy(how = How.ID, using = "submitAccount")
    public WebElement submitAccount;

    @FindBy(how = How.ID, using = "SubmitCreate")
    public WebElement submitCreate;

    @FindBy(how = How.ID, using = "create_account_error")
    public WebElement createError;

    @FindBy(how = How.ID, using = "email_create")
    public WebElement emailCreate;

    @FindBy(how = How.ID, using = "account-creation_form")
    public WebElement creationForm;

    @FindBy(how = How.ID, using = "email")
    public WebElement email;

    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement submitLogin;

    public SignPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void alertDisplayed(WebElement element) { element.isDisplayed(); }

    public void clickOnButton(WebElement element) { element.click(); }

    public void inputText(String text, WebElement element) {
        element.sendKeys(text);
    }

    public void MyAccountPage()  {
        String actualURL = driver.getCurrentUrl();
        assertThat("User should be on my account page", actualURL.equals("http://automationpractice.com/index.php?controller=my-account"));
    }

    public void AlertMessageCorrect(String message, WebElement element) {
        String receivedMessage = element.getText();
        Assert.assertEquals(message, receivedMessage);
    }
}