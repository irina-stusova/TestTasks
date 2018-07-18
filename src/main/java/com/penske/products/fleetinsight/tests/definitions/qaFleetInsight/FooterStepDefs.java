package com.penske.products.fleetinsight.tests.definitions.qaFleetInsight;

import com.penske.core.framework.Browser;
import com.penske.products.fleetinsight.globalFooter.GlobalFooter;
import com.penske.products.fleetinsight.loginPage.footer.LoginPageFooter;
import com.penske.products.fleetinsight.loginPage.footer.PrivacyPolicyTakeover;
import com.penske.products.fleetinsight.loginPage.footer.TermsAndConditionsTakeover;
import com.penske.products.fleetinsight.loginPage.footer.takeoverContactUs.ContactUsTakeover;
import com.penske.products.fleetinsight.loginPage.loginForm.LoginForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Year;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.penske.core.framework.Browser.getDriver;
import static com.penske.core.framework.Browser.switchToTab;


public class FooterStepDefs {
    private LoginPageFooter loginPageFooter = new LoginPageFooter();

    @When("^I enter \"([^\"]*)\" into the \"([^\"]*)\" field$")
    public void iEnterIntoTheField(String inputValue, String inputFieldName) {
        String inputFieldId = "";
        switch (inputFieldName) {
            case "UserId":
                inputFieldId = LoginForm.INPUT_USERID_ID;
                break;
            case "Password":
                inputFieldId = LoginForm.INPUT_PASSWORD_ID;
                break;
            default:
                throw new RuntimeException(String.format("No such input field name %s", inputFieldName));
        }
        By inputField = By.id(inputFieldId);
        Browser.sendQuery(inputField, inputValue);
    }

    @When("^I click the \"([^\"]*)\" button$")
    public void iClickTheBackButton(String buttonName) {
        String buttonLocator = "";
        switch (buttonName) {
            case "BACK":
                buttonLocator = ContactUsTakeover.BUTTON_BACK_XPATH;
                break;
            case "LOG IN":
                buttonLocator = LoginForm.BUTTON_LOGIN_XPATH;
                break;
            default:
                throw new RuntimeException(String.format("No such button name %s", buttonName));
        }
        By button = By.xpath(buttonLocator);
        WebElement webElement = Browser.findElement(button);
        Browser.click(button, webElement);
    }

    @And("^I click the \"([^\"]*)\" link$")
    public void iClickTheLink(String linkName) {
        String linkXpath = "";
        switch (linkName) {
            case "Contact Us":
                linkXpath = LoginPageFooter.LINK_CONTACT_US_XPATH;
                break;
            case "gopenske.com":
                linkXpath = LoginPageFooter.LINK_GOPENSKE_HREF;
                break;
            case "Used Trucks":
                linkXpath = LoginPageFooter.LINK_USED_TRUCKS_HREF;
                break;
            case "Penske News":
                linkXpath = LoginPageFooter.LINK_PENSKE_NEWS_HREF;
                break;
            case "Privacy Policy":
                linkXpath = LoginPageFooter.LINK_PRIVACY_POLICY_HREF;
                break;
            case "Terms and Conditions":
                linkXpath = LoginPageFooter.LINK_TERMS_AND_CONDITIONS_HREF;
                break;
            case "Safety Bulletins":
                linkXpath = LoginPageFooter.LINK_SAFETY_BULLETINS_HREF;
                break;
            case "Legalization Services":
                linkXpath = LoginPageFooter.LINK_LEGALIZATION_SERVICES_HREF;
                break;
            case "Privacy Policy-Global":
                linkXpath = GlobalFooter.LINK_PRIVACY_POLICY_HREF;
                break;
            case "Terms and Conditions-Global":
                linkXpath = GlobalFooter.LINK_TERMS_AND_CONDITIONS_HREF;
                break;
            case "Safety Bulletins-Global":
                linkXpath = GlobalFooter.LINK_SAFETY_BULLETINS_HREF;
                break;
            case "Legalization Services-Global":
                linkXpath = GlobalFooter.LINK_LEGALIZATION_SERVICES_HREF;
                break;
            default:
                throw new RuntimeException(String.format("No such link name %s", linkName));
        }
        By link = By.xpath(linkXpath);
        WebElement webElement = Browser.findElement(link);
        Browser.click(link, webElement);
    }

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


    @And("^I check correctness of the copyright year$")
    public void iCheckCorrectnessOfTheCopyrightYear() {
        String actualCopyrightYear = loginPageFooter.getLabelCopyright();
        String currentYear = Year.now().toString();
        Assert.assertEquals(actualCopyrightYear, currentYear, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualCopyrightYear, currentYear));
    }

    @And("^I check correctness of the wording \"([^\"]*)\" for \"([^\"]*)\" link$")
    public void iCheckCorrectnessOfTheWordingForLink(String expectedLinkName, String linkName) {
        String actualLinkXpath = "";
        switch (linkName) {
            case "Safety Bulletins":
                actualLinkXpath = LoginPageFooter.LINK_SAFETY_BULLETINS_HREF;
                break;
            case "Legalization Services":
                actualLinkXpath = LoginPageFooter.LINK_LEGALIZATION_SERVICES_HREF;
                break;
            default:
                throw new RuntimeException(String.format("No such link name %s", linkName));
        }
        By link = By.xpath(actualLinkXpath);
        String actualLinkName = Browser.findElement(link).getText();
        Assert.assertEquals(actualLinkName, expectedLinkName, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualLinkName, expectedLinkName));
    }

    @Then("^I get the page opened in the same browser window and check correctness of the url \"([^\"]*)\"$")
    public void iGetThePageOpenedInTheSameBrowserWindow(String expectedUrl) {
        String currentUrl = Browser.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", currentUrl, expectedUrl));
    }

    @Then("^I check the Roadside Assistance Support phone number \"([^\"]*)\"$")
    public void iCheckTheRoadsideAssistanceSupportPhoneNumber(String expectedPhoneNumber) {
        String actualPhoneNumber = loginPageFooter.getLabelSupportPhone();
        Pattern pattern = Pattern.compile("\\d{1}-\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(actualPhoneNumber);
        if (matcher.find()) {
            actualPhoneNumber = matcher.group();
        }
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
    }

    @Then("^I close the \"([^\"]*)\" takeover$")
    public void iCloseTheTakeover(String takeoverName) {
        String buttonCloseXpath = "";
        switch (takeoverName) {
            case "Privacy Policy":
                buttonCloseXpath = PrivacyPolicyTakeover.BUTTON_CLOSE_XPATH;
                break;
            case "Terms and Conditions":
                buttonCloseXpath = TermsAndConditionsTakeover.BUTTON_CLOSE_XPATH;
                break;
            default:
                throw new RuntimeException(String.format("No such takeover name %s", takeoverName));
        }

        By buttonClose = By.xpath(buttonCloseXpath);
        WebElement webElement = Browser.findElement(buttonClose);
        Browser.click(buttonClose, webElement);
    }

    @Then("^I get the Login page shown \"([^\"]*)\"$")
    public void iGetTheLoginPageShown(String expectedUrl) {
        String currentUrl = Browser.getCurrentUrl().substring(0, 46);
        Assert.assertEquals(currentUrl, expectedUrl, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", currentUrl, expectedUrl));
    }




//    @Then("^I get the page opened in a new browser window and check correctness of the url \"([^\"]*)\"$")
//    public void iGetThePageOpenedInANewBrowserWindowAndCheckCorrectnessOfTheUrl(String expectedUrl) {
//        Browser.switchToTab(2);
//        String currentUrl = Browser.getCurrentUrl();
//        Assert.assertEquals(currentUrl, expectedUrl, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", currentUrl, expectedUrl));
//    }
}
