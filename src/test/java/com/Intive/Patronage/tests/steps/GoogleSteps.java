package com.Intive.Patronage.tests.steps;
import com.Intive.Patronage.tests.pages.GooglePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.Intive.Patronage.tests.DriverFactory;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleSteps extends DriverFactory {

    GooglePage googlePage = new GooglePage(driver);

    @Given("^User is on Google page$")
    public void userIsOnGooglePage()  {
        googlePage.openGooglePage();
    }

    @When("^I search Google with phrase \"([^\"]*)\"$")
    public void iSearchGoogleWithPhrase(String searchPhrase){
        googlePage.searchInGoogle(searchPhrase);
    }

    @Then("^I can see results$")
    public void iCanSeeResults() throws Throwable {
        googlePage.verifyIfResultsAreVisible();
    }

    @Then("^I am on Intive main page$")
    public void iAmOnIntiveMainPage()  {
        String actualURL = driver.getCurrentUrl();
        assertThat("User should be on Intive main page", actualURL.equals("https://www.intive.com/"));
    }

    @And("^I open first link from search$")
    public void iOpenFirstLinkFromSearch() {
        googlePage.firstSearchResult.click();
    }
}
