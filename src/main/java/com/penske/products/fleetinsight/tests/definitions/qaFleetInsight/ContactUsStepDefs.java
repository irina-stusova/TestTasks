package com.penske.products.fleetinsight.tests.definitions.qaFleetInsight;

import com.penske.core.framework.Browser;
import com.penske.products.fleetinsight.loginPage.takeoverContactUs.ContactUsDropdownOption;
import com.penske.products.fleetinsight.loginPage.takeoverContactUs.ContactUsTakeover;
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

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the \"([^\"]*)\" dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheDropdown(String expectedPlaceholder, String dropdownName) {
        String dropdownId = "";
        switch (dropdownName) {
            case "SALUTATION":
                dropdownId = ContactUsTakeover.DROPDOWN_SALUTATION_ID;
                break;
            case "Best Time To Reach you?":
                dropdownId = ContactUsTakeover.DROPDOWN_BEST_TIME_TO_REACH_ID;
                break;
            case "Reason for contact?":
                dropdownId = ContactUsTakeover.DROPDOWN_REASON_FOR_CONTACT_ID;
                break;
            default:
                throw new RuntimeException(String.format("No such dropdown name %s", dropdownName));
        }
        String actualPlaceholder = contactUsTakeover.getDropdownPlaceholder(dropdownId).toUpperCase();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the \"([^\"]*)\" input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheInputField(String expectedPlaceholder, String inputFieldName) {
        String placeholderName = "";
        switch (inputFieldName) {
            case "FIRST NAME":
                placeholderName = ContactUsTakeover.INPUT_FIRST_NAME_BY_NAME;
                break;
            case "LAST NAME":
                placeholderName = ContactUsTakeover.INPUT_LAST_NAME_BY_NAME;
                break;
            case "EMAIL":
                placeholderName = ContactUsTakeover.INPUT_EMAIL_NAME;
                break;
            case "ALTERNATIVE EMAIL":
                placeholderName = ContactUsTakeover.INPUT_ALTERNATIVE_EMAIL_NAME;
                break;
            case "TELEPHONE":
                placeholderName = ContactUsTakeover.INPUT_TELEPHONE_NAME;
                break;
            default:
                throw new RuntimeException(String.format("No such input field name %s", inputFieldName));
        }

        String actualPlaceholder = contactUsTakeover.getInputFieldPlaceholder(placeholderName);
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @When("^I click the dropdown control for \"([^\"]*)\"$")
    public void iClickTheDropdownControl(String dropdownId) {
        By dropdownControl = contactUsTakeover.dropdownControl(dropdownId);
        WebElement webElement = Browser.findElement(dropdownControl);
        Browser.getInst().click(dropdownControl, webElement);
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