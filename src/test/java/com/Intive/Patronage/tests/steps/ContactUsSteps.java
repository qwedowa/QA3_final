package com.Intive.Patronage.tests.steps;

import com.Intive.Patronage.tests.DriverFactory;
import com.Intive.Patronage.tests.pages.ContactUsPage;
import com.Intive.Patronage.tests.pages.MainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ContactUsSteps extends DriverFactory {

    MainPage mainPage = new MainPage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);


    @Given("^I open automationpractice website$")
    public void iOpenAutomationpracticeWebsite() {
        mainPage.openAutomationPracticePage();
    }

    @When("^I click on ContactUS link$")
    public void iClickOnContactUSLink() {

        mainPage.contactUsLink.isDisplayed();
        mainPage.contactUsLink.click();
    }

    @And("^I click on Send button$")
    public void iClickOnSendButton() {
        contactUsPage.submitButtonContactUs.isDisplayed();
        contactUsPage.submitButtonContactUs.click();

    }

    @And("^I choose anything in Subject Heading, Email address, Order reference and Product; Message box and attachment is empty$")
    public void iChooseAnythingInSubjectHeadingEmailAddressOrderReferenceAndProductMessageBoxAndAttachmentIsEmpty() {
        contactUsPage.selectSubject(contactUsPage.subject); ;
        contactUsPage.inputText("testxyz1994@gmail.com", contactUsPage.emailAddress);
        contactUsPage.inputText("Reference", contactUsPage.orderReference);
    }

    @And("^I write anything in Message box$")
    public void iWriteAnythingInMessageBox() {
        contactUsPage.inputText("Test message", contactUsPage.message);
    }

    @And("^I fill forms, without attachment$")
    public void iFillFormsWithoutAttachment() {
        contactUsPage.inputText("Test message", contactUsPage.message);
        contactUsPage.inputText("testxyz1994@gmail.com", contactUsPage.emailAddress);
        contactUsPage.selectSubject(contactUsPage.subject); ;
        contactUsPage.inputText("Reference", contactUsPage.orderReference);
    }

    @Then("^I will send message$")
    public void iWillSendMessage() {
        contactUsPage.alertDisplayed(contactUsPage.sendSucces);
        contactUsPage.alertMessageCorrect("Your message has been successfully sent to our team.", contactUsPage.sendSucces);
    }

    @Then("^I will see error popup about invalid email$")
    public void iWillSeeErrorPopupAboutInvalidEmail() {
        //Assert.assertTrue(contactUsPage.alertPopUp.isDisplayed());
        contactUsPage.alertMessageCorrect("Invalid email address.", contactUsPage.alertText);
    }

    @Then("^I will see error popup about blank message$")
    public void iWillSeeErrorPopupAboutBlankMessage() {
        contactUsPage.alertMessageCorrect("The message cannot be blank.", contactUsPage.alertText);
    }
}
