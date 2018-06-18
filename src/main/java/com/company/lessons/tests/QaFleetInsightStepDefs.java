package com.company.lessons.tests;

import com.company.lessons.browser.Browser;
import com.company.lessons.qaFleetInsight.LoginPageFooter;
import com.company.lessons.qaFleetInsight.PrivacyPolicyTakeover;
import com.company.lessons.qaFleetInsight.TermsAndConditionsTakeover;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class QaFleetInsightStepDefs {
    private LoginPageFooter loginPageFooter = new LoginPageFooter();
    private PrivacyPolicyTakeover privacyPolicyTakeover = new PrivacyPolicyTakeover();
    private TermsAndConditionsTakeover termsAndConditionsTakeover = new TermsAndConditionsTakeover();

    @And("^I click the Contact Us link$")
    public void iClickTheContactUsLink() {
        By linkContactUs = loginPageFooter.linkContactUs();
        WebElement webElement = Browser.findElement(linkContactUs);
//        Browser.focusOnElement(webElement);
        Browser.getInst().click(linkContactUs, webElement);
    }

    @Then("^I get the page opened in the same browser window and check correctness of the url \"([^\"]*)\"$")
    public void iGetThePageOpenedInTheSameBrowserWindow(String expectedUrl) {
        String currentUrl = Browser.getCurrentUrl();
        if (expectedUrl.equals(currentUrl)) {
            System.out.println(String.format("Expected url is opened: %s", currentUrl));
        } else {
            System.out.println(String.format("Incorrect url is opened: %s", currentUrl));
        }
    }

    @When("^I click the gopenske.com link$")
    public void iClickTheGopenskeComLink() {
        By linkGoPenske = loginPageFooter.linkGoPenske();
        WebElement webElement = Browser.findElement(linkGoPenske);
        Browser.getInst().click(linkGoPenske, webElement);
    }

    @When("^I click the Used Trucks link$")
    public void iClickTheUsedTrucksLink() {
        By linkUsedTrucks = loginPageFooter.linkUsedTrucks();
        WebElement webElement = Browser.findElement(linkUsedTrucks);
        Browser.getInst().click(linkUsedTrucks, webElement);
    }

    @When("^I click the Penske News link$")
    public void iClickThePenskeNewsLink() {
        By linkPenskeNews = loginPageFooter.linkPenskeNews();
        WebElement webElement = Browser.findElement(linkPenskeNews);
        Browser.getInst().click(linkPenskeNews, webElement);
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
        By linkLegalizationServices = loginPageFooter.linkLegalizationServices();
        WebElement webElement = Browser.findElement(linkLegalizationServices);
        Browser.getInst().click(linkLegalizationServices, webElement);
    }

    @And("^I click the Safety Bulletins link$")
    public void iClickTheSafetyBulletinsLink() {
        By linkSafetyBulletins = loginPageFooter.linkSafetyBulletins();
        WebElement webElement = Browser.findElement(linkSafetyBulletins);
        Browser.getInst().click(linkSafetyBulletins, webElement);
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
        By linkPrivacyPolicy = loginPageFooter.linkPrivacyPolicy();
        WebElement webElement = Browser.findElement(linkPrivacyPolicy);
        Browser.getInst().click(linkPrivacyPolicy, webElement);
    }

    @And("^I click the Terms and Conditions link$")
    public void iClickTheTermsAndConditionsLink() {
        By linkTermsAndConditions = loginPageFooter.linkTermsAndConditions();
        WebElement webElement = Browser.findElement(linkTermsAndConditions);
        Browser.getInst().click(linkTermsAndConditions, webElement);
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

    @Then("^I get the page opened in a new browser window and check correctness of the url \"([^\"]*)\"$")
    public void iGetThePageOpenedInANewBrowserWindowAndCheckCorrectnessOfTheUrl(String expectedUrl) {
        String currentUrl = Browser.getCurrentUrl();
        if (expectedUrl.equals(currentUrl)) {
            System.out.println(String.format("Expected url is opened: %s", currentUrl));
        } else {
            System.out.println(String.format("Incorrect url is opened: %s", currentUrl));
        }
    }

    @Then("^I close the Privacy Policy takeover$")
    public void iCloseThePrivacyPolicyTakeover() {
        By buttonClose = privacyPolicyTakeover.buttonClose();
        WebElement webElement = Browser.findElement(buttonClose);
        Browser.getInst().click(buttonClose, webElement);
    }

    @Then("^I close the Terms and Conditions takeover$")
    public void iCloseTheTermsAndConditionsTakeover() {
        By buttonClose = termsAndConditionsTakeover.buttonClose();
        WebElement webElement = Browser.findElement(buttonClose);
        Browser.getInst().click(buttonClose, webElement);
    }
}
