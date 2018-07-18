package com.penske.products.fleetinsight.tests.definitions.qaFleetInsight;

import com.penske.core.framework.Browser;
import com.penske.products.fleetinsight.loginPage.footer.takeoverContactUs.ContactUsDropdownOption;
import com.penske.products.fleetinsight.loginPage.footer.takeoverContactUs.ContactUsTakeover;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactUsStepDefs {
    private ContactUsTakeover contactUsTakeover = new ContactUsTakeover();
    private List<String> actualOptionsList = new ArrayList<>();

    @Then("^I check correctness of the \"([^\"]*)\" phone \"([^\"]*)\"$")
    public void iCheckCorrectnessOfThePhone(String serviceName, String expectedPhoneNumber) {
        String phoneName = "";
        switch (serviceName) {
            case "Customer Service":
                phoneName = ContactUsTakeover.CUSTOMER_SERVICE_PHONE_KEY;
                break;
            case "Road Assistance":
                phoneName = ContactUsTakeover.ROAD_ASSISTANCE_PHONE_KEY;
                break;
            default:
                throw new RuntimeException(String.format("No such service name %s", serviceName));
        }

        String actualPhoneNumber = contactUsTakeover.getServicePhone(phoneName);
        Pattern pattern = Pattern.compile("(\\(\\d{3}\\)\\s\\d{3}-\\d{4})");
        Matcher matcher = pattern.matcher(actualPhoneNumber);
        if (matcher.find()) {
            actualPhoneNumber = matcher.group();
        }
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

    @When("^I click the dropdown control for \"([^\"]*)\" dropdown$")
    public void iClickTheDropdownControlForDropdown(String dropdownName) {
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
        By dropdownControl = contactUsTakeover.dropdownControl(dropdownId);
        WebElement webElement = Browser.findElement(dropdownControl);
        Browser.click(dropdownControl, webElement);
    }

    @And("^I get \"([^\"]*)\" dropdown options as a list using locator \"([^\"]*)\"$")
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

    @Then("^I select the \"([^\"]*)\" radio button$")
    public void iSelectTheEmailRadioButton(String radioButtonName) {
        String radioButtonLocator = "";
        switch (radioButtonName) {
            case "Phone":
                radioButtonLocator = ContactUsTakeover.RADIO_BUTTON_PHONE_TYPE_NAME;
                break;
            case "Email":
                radioButtonLocator = ContactUsTakeover.RADIO_BUTTON_EMAIL_TYPE_NAME;
                break;
            default:
                throw new RuntimeException(String.format("No such radio button name %s", radioButtonName));
        }
        By radioButton = By.xpath(radioButtonLocator);
        WebElement webElement = Browser.findElement(radioButton);
        Browser.click(radioButton, webElement);
    }
}