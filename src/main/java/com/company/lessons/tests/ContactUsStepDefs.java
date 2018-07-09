package com.company.lessons.tests;

import com.company.lessons.browser.Browser;
import com.company.lessons.qaFleetInsight.loginPage.takeoverContactUs.ContactUsDropdownOption;
import com.company.lessons.qaFleetInsight.loginPage.takeoverContactUs.ContactUsTakeover;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class ContactUsStepDefs {
    private ContactUsTakeover contactUsTakeover = new ContactUsTakeover();
    private List<String> actualOptionsList = new ArrayList<>();

    @Then("^I check correctness of the Customer Service phone \"([^\"]*)\"$")
    public void iCheckCorrectnessOfTheCustomerServicePhone(String expectedPhoneNumber) {
        String actualPhoneNumber = contactUsTakeover.getCustomerServicePhone().substring(81, 95);
        actualPhoneNumber = actualPhoneNumber.replaceAll("\\D", "");
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
    }

    @Then("^I check correctness of the Road Assistance phone \"([^\"]*)\"$")
    public void iCheckCorrectnessOfTheRoadAssistancePhone(String expectedPhoneNumber) {
        String actualPhoneNumber = contactUsTakeover.getRoadAssistancePhone().substring(45, 59);
        actualPhoneNumber = actualPhoneNumber.replaceAll("\\D", "");
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Salutation dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheSalutationDropdown(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderSalutation().toUpperCase();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @And("^I check that \"([^\"]*)\" is shown as a placeholder for the Best Time To Reach You dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheBestTimeToReachYouDropdown(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderBestTimeToReach().toUpperCase();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @And("^I check that \"([^\"]*)\" is shown as a placeholder for the Reason For Contact dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheReasonForContactDropdown(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderReasonForContact().toUpperCase();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the First Name input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheFirstNameInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderFirstName();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Last Name input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheLastNameInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderLastName();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Email input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheEmailInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderEmail();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Alternative Email input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheAlternativeEmailInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderAlternativeEmail();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Telephone input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheTelephoneInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderTelephone();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @When("^I click the Salutation dropdown control$")
    public void iClickTheSalutationDropdownControl() {
        By dropdownControlSalutation = contactUsTakeover.dropdownControlSalutation();
        WebElement webElement = Browser.findElement(dropdownControlSalutation);
        Browser.getInst().click(dropdownControlSalutation, webElement);
    }

    @When("^I click the Best Time To Reach You dropdown control$")
    public void iClickTheBestTimeToReachYouDropdownControl() {
        By dropdownControlBestTime = contactUsTakeover.dropdownControlBestTime();
        WebElement webElement = Browser.findElement(dropdownControlBestTime);
        Browser.getInst().click(dropdownControlBestTime, webElement);
    }

    @When("^I click the Reason For Contact dropdown control$")
    public void iClickTheReasonForContactDropdownControl() {
        By dropdownControlContactReason = contactUsTakeover.dropdownControlContactReason();
        WebElement webElement = Browser.findElement(dropdownControlContactReason);
        Browser.getInst().click(dropdownControlContactReason, webElement);
    }

    @And("^I get dropdown options as a list using locator \"([^\"]*)\"$")
    public List<String> iGetDropdownOptionsAsAList(String locator) {
        int count = Browser.findElements(By.xpath(String.format(locator, "@*"))).size();

        for (int i = 1; i <= count; i++) {
            ContactUsDropdownOption option = new ContactUsDropdownOption();
            option.setDropdownOption(Browser.findElement(By.xpath(String.format(locator, i))).getText());
            actualOptionsList.add(option.getDropdownOption(option));
        }
        return actualOptionsList;
    }

    @Then("^I compare the actual options list with the expected options list$")
    public void iCompareTheActualOptionsListWithTheExpectedOptionsList(List<String> expectedOptionsList) {
        Assert.assertEquals(actualOptionsList, expectedOptionsList, String.format("\nAR doesn't match ER. \nActual list: %s.\nExpected list: %s", actualOptionsList, expectedOptionsList));
    }

    @Then("^I check the Phone radio button is preselected by default$")
    public boolean iCheckThePhoneRadioButtonIsPreselectedByDefault() {
        By radioButtonPhone = contactUsTakeover.radioButtonPhone();
        WebElement webElement = Browser.findElement(radioButtonPhone);
        if (webElement.isSelected()) {
            System.out.println("\nPhone radio button is preselected by default");
            return true;
        } else {
            System.out.println("\nPhone radio button is not preselected by default");
            return false;
        }
    }

    @Then("^I select the Email radio button$")
    public void iSelectTheEmailRadioButton() {
        By radioButtonEmail = contactUsTakeover.radioButtonEmail();
        WebElement webElement = Browser.findElement(radioButtonEmail);
        Browser.getInst().click(radioButtonEmail, webElement);
    }

    @Then("^I select the Phone radio button$")
    public void iSelectThePhoneRadioButton() {
        By radioButtonPhone = contactUsTakeover.radioButtonPhone();
        WebElement webElement = Browser.findElement(radioButtonPhone);
        Browser.getInst().click(radioButtonPhone, webElement);
    }
}
