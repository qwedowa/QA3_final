package com.Intive.Patronage.tests.steps;

import com.Intive.Patronage.tests.DriverFactory;
import com.Intive.Patronage.tests.pages.MainPage;
import com.Intive.Patronage.tests.pages.SignPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class SignPageSteps extends DriverFactory {

    MainPage mainPage = new MainPage(driver);
    SignPage signPage = new SignPage(driver);


    @When("^I click on SignIn button$")
    public void iClickOnSignInButton() {
        signPage.signInPage();
    }

    @And("^I click on CreateAnAccount button$")
    public void iClickOnCreateAnAccountButton() {
        signPage.clickOnButton(signPage.submitCreate);
    }

    @Then("^I will see error popup about invalid email while trying to sign up$")
    public void iWillSeeErrorPopupAboutInvalidEmailWhileTryingToSignUp() {
        signPage.alertDisplayed(signPage.errorPopUp);
    }

    @And("^I write invalid email and click on CreateAnAccount button$")
    public void iWriteInvalidEmailAndClickOnCreateAnAccountButton() {
        signPage.inputText("123", signPage.emailCreate);
    }

    @And("^I write valid email and click on CreateAnAccount button$")
    public void iWriteValidEmailAndClickOnCreateAnAccountButton() {
        signPage.inputText("asdaseadea@gmail.com", signPage.emailCreate);
    }

    @Then("^I will able to create an account$")
    public void iWillAbleToCreateAnAccount() {
        signPage.creationForm.isDisplayed();
    }

    @And("^I write correct data and click on SignIn button$")
    public void iWriteCorrectDataAndClickOnSignInButton() {
        signPage.inputText("testxyz1994@gmail.com", signPage.email);
        signPage.inputText("12345", signPage.password);
        signPage.clickOnButton(signPage.submitLogin);
    }

    @Then("^I will sign in$")
    public void iWillSignIn() {
        signPage.MyAccountPage();
    }

    @And("^I write correct e-mail address and incorrect password$")
    public void iWriteCorrectEMailAddressAndIncorrectPassword() {
        signPage.inputText("testxyz1994@gmail.com", signPage.email);
        signPage.inputText("wrongpasswd", signPage.password);
        signPage.clickOnButton(signPage.submitLogin);
    }

    @Then("^I will see error popup about authentication failed$")
    public void iWillSeeErrorPopupAboutAuthenticationFailed() {
        signPage.AlertMessageCorrect("There is 1 error\nAuthentication failed.", signPage.errorPopUp);
    }

    @And("^I write incorrect e-mail address and correct password$")
    public void iWriteIncorrectEMailAddressAndCorrectPassword() {
        signPage.inputText("testxyz1", signPage.email);
        signPage.inputText("12345", signPage.password);
        signPage.clickOnButton(signPage.submitLogin);
    }

    @Then("^I will see error popup about invalid email while logging in$")
    public void iWillSeeErrorPopupAboutInvalidEmailWhileLoggingIn() {
        signPage.AlertMessageCorrect("There is 1 error\nInvalid email address.", signPage.errorPopUp);
    }

    @Given("^I open Automationpractice site$")
    public void iOpenAutomationpracticeSite() {{mainPage.openAutomationPracticePage();}
    }
}