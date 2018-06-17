package com.company.lessons.tests;

import com.company.lessons.browser.Browser;
import com.company.lessons.qaFleetInsight.LoginPageFooter;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.company.lessons.browser.Browser.wait;

public class QaFleetInsightStepDefs {
    private LoginPageFooter loginPageFooter = new LoginPageFooter();

    @And("^I click the Contact Us link$")
    public void iClickTheContactUsLink() {
        By linkContactUs = loginPageFooter.linkContactUs();
        WebElement webElement = Browser.findElement(linkContactUs);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Browser.getInst().click(linkContactUs);
    }
    
    @Then("^I get the page opened in a new browser window and check correctness of the url \"([^\"]*)\"$")
    public void iGetThePageOpenedInANewBrowserWindow(String expectedUrl) {
        String currentUrl = Browser.getCurrentUrl();
        if (expectedUrl.equals(currentUrl)) {
            System.out.println(String.format("Expected url is opened: %s", currentUrl));
        } else {
            System.out.println(String.format("Incorrect url is opened: %s", currentUrl));
        }
    }

    @When("^I click the gopenske.com link$")
    public void iClickTheGopenskeComLink() {
//        By linkGoPenske = loginPageFooter.linkGoPenske();
        Browser.getInst().click(loginPageFooter.linkGoPenske());
    }

    @When("^I click the Used Trucks link$")
    public void iClickTheUsedTrucksLink() {
//        By linkUsedTrucks = loginPageFooter.linkUsedTrucks();
        Browser.getInst().click(loginPageFooter.linkUsedTrucks());
    }

    @When("^I click the Penske News link$")
    public void iClickThePenskeNewsLink() {
//        By linkPenskeNews = loginPageFooter.linkPenskeNews();
        Browser.getInst().click(loginPageFooter.linkPenskeNews());
    }

    @Then("^I check the Roadside Assistance Support phone number \"([^\"]*)\"$")
    public void iCheckTheRoadsideAssistanceSupportPhoneNumber(String expectedPhoneNumber) {
        String actualPhoneNumber = loginPageFooter.getLabelSupportPhone();
        if (expectedPhoneNumber.equals(actualPhoneNumber.substring(5))) {
            System.out.println(String.format("Actual result matches Expected result: \nAR = ER: %s", expectedPhoneNumber));
        } else {
            System.out.println(String.format("Actual result doesn't match Expected result: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
        }
    }

    @And("^I check the wording of \"([^\"]*)\" link$")
    public void iCheckTheWordingOfLink(String expectedLinkName) {
    String actualLinkName = loginPageFooter.getNameLegalizationServices();
        if (expectedLinkName.equals(actualLinkName)) {
            System.out.println(String.format("Actual result matches Expected result: \nAR = ER: %s", actualLinkName));
        } else {
            System.out.println(String.format("Actual result doesn't match Expected result: \nAR: %s; ER: %s", actualLinkName, expectedLinkName));
        }
    }

    @And("^I click the Legalization Services link$")
    public void iClickTheLegalizationServicesLink() {
//        By linkLegalizationServices = loginPageFooter.linkLegalizationServices();
        Browser.getInst().click(loginPageFooter.linkLegalizationServices());
    }

    @And("^I click the Safety Bulletins link$")
    public void iClickTheSafetyBulletinsLink() {
//        By linkSafetyBulletins = loginPageFooter.linkSafetyBulletins();
        Browser.getInst().click(loginPageFooter.linkSafetyBulletins());
    }

    @And("^I check correctness of the copyright year \"([^\"]*)\"$")
    public void iCheckCorrectnessOfTheCopyrightYear(String expectedCopyrightYear) {
        String actualCopyrightYear = loginPageFooter.getLabelCopyright();
        if (expectedCopyrightYear.equals(actualCopyrightYear)) {
            System.out.println(String.format("Actual result matches Expected result: \nAR = ER: %s", actualCopyrightYear));
        } else {
            System.out.println(String.format("Actual result doesn't match Expected result: \nAR: %s; ER: %s", actualCopyrightYear, expectedCopyrightYear));
        }
    }

    @And("^I click the Privacy Policy link$")
    public void iClickThePrivacyPolicyLink() {
//        By linkPrivacyPolicy = loginPageFooter.linkPrivacyPolicy();
        Browser.getInst().click(loginPageFooter.linkPrivacyPolicy());
    }

    @And("^I click the Terms and Conditions link$")
    public void iClickTheTermsAndConditionsLink() {
//        By linkTermsAndConditions = loginPageFooter.linkTermsAndConditions();
        Browser.getInst().click(loginPageFooter.linkTermsAndConditions());
    }

    @When("^I check correctness of the wording of \"([^\"]*)\" link$")
    public void iCheckCorrectnessOfTheWordingOfLink(String expectedLinkName) {
        String actualLinkName = loginPageFooter.getNameSafetyBulletins();
        if (expectedLinkName.equals(actualLinkName)) {
            System.out.println(String.format("Actual result matches Expected result: \nAR = ER: %s", actualLinkName));
        } else {
            System.out.println(String.format("Actual result doesn't match Expected result: \nAR: %s; ER: %s", actualLinkName, expectedLinkName));
        }
    }
}
