package com.penske.products.fleetinsight.tests.definitions.qaFleetInsight;

import com.penske.products.fleetinsight.footer.takeoverContactUs.ContactUsDropdownOption;
import com.penske.products.fleetinsight.footer.takeoverContactUs.ContactUsTakeover;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactUsStepDefs {
    private ContactUsTakeover contactUsTakeover = new ContactUsTakeover();
    private ContactUsDropdownOption contactUsDropdownOption = new ContactUsDropdownOption();
    private List<String> actualOptionsList = new ArrayList<>();

    ////<editor-fold desc="When">
    @When("^I click the dropdown control for \"([^\"]*)\" dropdown$")
    public void iClickTheDropdownControlForDropdown(String dropdownName) {
        contactUsTakeover.clickDropdownControl(dropdownName);
    }
    ////</editor-fold>
    ////<editor-fold desc="And">
    @And("^I get \"([^\"]*)\" dropdown options as a list$")
    public List<String> iGetDropdownOptionsAsAList(String dropdownName) {
        return actualOptionsList = contactUsDropdownOption.getDropdownOptionsList(dropdownName);
    }
    ////</editor-fold>
    ////<editor-fold desc="Then">
    @Then("^I check correctness of the \"([^\"]*)\" phone \"([^\"]*)\"$")
    public void iCheckCorrectnessOfThePhone(String serviceName, String expectedPhoneNumber) {
        String actualPhoneNumber = contactUsTakeover.getServicePhone(serviceName);
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the \"([^\"]*)\" dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheDropdown(String expectedPlaceholder, String dropdownName) {
        String actualPlaceholder = contactUsTakeover.getDropdownPlaceholder(dropdownName).toUpperCase();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the \"([^\"]*)\" input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheInputField(String expectedPlaceholder, String inputFieldName) {
        String actualPlaceholder = contactUsTakeover.getInputFieldPlaceholder(inputFieldName);
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
    }

    @Then("^I compare the actual options list with the expected options list$")
    public void iCompareTheActualOptionsListWithTheExpectedOptionsList(List<String> expectedOptionsList) {
        Assert.assertEquals(actualOptionsList, expectedOptionsList, String.format("\nAR doesn't match ER. \nActual list: %s.\nExpected list: %s", actualOptionsList, expectedOptionsList));
    }

    @Then("^I check the \"([^\"]*)\" radio button is preselected by default$")
    public boolean iCheckThePhoneRadioButtonIsPreselectedByDefault(String radioButtonName) {
        WebElement webElement = contactUsTakeover.getRadioButton(radioButtonName);
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
        WebElement webElement = contactUsTakeover.getRadioButton(radioButtonName);
        webElement.click();
    }
////</editor-fold>
}