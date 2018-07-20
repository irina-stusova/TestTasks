package com.penske.products.fleetinsight.tests.definitions.qaFleetInsight;

import com.penske.core.framework.Browser;
import com.penske.products.fleetinsight.footer.Footer;
import com.penske.products.fleetinsight.footer.PrivacyPolicyTakeover;
import com.penske.products.fleetinsight.footer.TermsAndConditionsTakeover;
import com.penske.products.fleetinsight.footer.takeoverContactUs.ContactUsTakeover;
import com.penske.products.fleetinsight.loginPage.LoginForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.time.Year;


public class FooterStepDefs {
    private Footer footer = new Footer();
    private LoginForm loginForm = new LoginForm();
    private ContactUsTakeover contactUsTakeover = new ContactUsTakeover();
    private PrivacyPolicyTakeover privacyPolicyTakeover = new PrivacyPolicyTakeover();
    private TermsAndConditionsTakeover termsAndConditionsTakeover = new TermsAndConditionsTakeover();

    ////<editor-fold desc="When">
    @When("^I click the \"([^\"]*)\" button$")
    public void iClickTheButton(String buttonName) {
        contactUsTakeover.clickButton(buttonName);
    }
    ////</editor-fold>
    ////<editor-fold desc="And">
    @And("^I click the \"([^\"]*)\" link$")
    public void iClickTheLink(String linkName) {
        footer.clickLink(linkName);
    }

    @And("^I check correctness of the copyright year$")
    public void iCheckCorrectnessOfTheCopyrightYear() {
        String actualCopyrightYear = footer.getCopyrightYear();
        String currentYear = Year.now().toString();
        Assert.assertEquals(actualCopyrightYear, currentYear, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualCopyrightYear, currentYear));
    }

    @And("^I login to the App with UserId \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void iLoginToTheAppWithUserIdAndPassword(String userId, String password) {
        loginForm.login(userId, password);
    }
    ////</editor-fold>
    ////<editor-fold desc="Then">
    @Then("^I check new browser tab is opened and \"?(equals to|contains)\"? expected url:$")
    public void iCheckNewBrowserTabIsOpenedHasExpectedUrl(String state, String url) {
        Browser.switchToTab(1);
        String actualUrl = Browser.getCurrentUrl();
        if (state.equalsIgnoreCase("equals to")) {
            Assert.assertEquals(actualUrl, url,
                    String.format("Actual Url '%s' is not equal to expected '%s'", actualUrl, url));
        } else {
            Assert.assertTrue(actualUrl.contains(url),
                    String.format("Actual Url '%s' does not contain expected '%s'", actualUrl, url));
        }
    }

    @Then("^I get the page opened in the same browser window and check correctness of the url \"([^\"]*)\"$")
    public void iGetThePageOpenedInTheSameBrowserWindow(String expectedUrl) {
        String currentUrl = Browser.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", currentUrl, expectedUrl));
    }

    @Then("^I check the Roadside Assistance Support phone number \"([^\"]*)\"$")
    public void iCheckTheRoadsideAssistanceSupportPhoneNumber(String expectedPhoneNumber) {
        String actualPhoneNumber = footer.getSupportPhone();
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
    }

    @Then("^I close the \"([^\"]*)\" takeover$")
    public void iCloseTheTakeover(String takeoverName) {
        switch (takeoverName) {
            case "Privacy Policy":
                privacyPolicyTakeover.clickCloseButton();
                break;
            case "Terms and Conditions":
                termsAndConditionsTakeover.clickCloseButton();
                break;
            default:
                throw new RuntimeException(String.format("No such takeover name %s", takeoverName));
        }
    }

    @Then("^I get the Login page shown \"([^\"]*)\"$")
    public void iGetTheLoginPageShown(String expectedUrl) {
        String currentUrl = Browser.getCurrentUrl().substring(0, 46);
        Assert.assertEquals(currentUrl, expectedUrl, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", currentUrl, expectedUrl));
    }
    ////</editor-fold>
}
