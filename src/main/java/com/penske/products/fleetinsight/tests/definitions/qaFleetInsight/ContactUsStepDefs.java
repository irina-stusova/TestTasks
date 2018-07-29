package com.penske.products.fleetinsight.tests.definitions.qaFleetInsight;

import com.penske.core.framework.Log;
import com.penske.products.fleetinsight.MyProfilePage;
import com.penske.products.fleetinsight.User;
import com.penske.products.fleetinsight.footer.takeoverContactUs.ContactUsDropdownOption;
import com.penske.products.fleetinsight.footer.takeoverContactUs.ContactUsTakeover;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactUsStepDefs {
    private ContactUsTakeover contactUsTakeover = new ContactUsTakeover();
    private ContactUsDropdownOption contactUsDropdownOption = new ContactUsDropdownOption();
    private MyProfilePage myProfilePage = new MyProfilePage();
    private List<String> actualOptionsList = new ArrayList<>();
    private User currentUser = new User();

    ////<editor-fold desc="When">
    @When("^I click the dropdown control for \"([^\"]*)\" dropdown$")
    public void iClickTheDropdownControlForDropdown(String dropdownName) {
        contactUsTakeover.clickDropdownControl(dropdownName);
        Log.info(String.format("Dropdown control for '%s' was clicked", dropdownName));
    }

    ////</editor-fold>
    ////<editor-fold desc="And">
    @And("^I get \"([^\"]*)\" dropdown options as a list$")
    public List<String> iGetDropdownOptionsAsAList(String dropdownName) {
        Log.info(String.format("Options of the '%s' dropdown were retrieved into a list", dropdownName));
        return actualOptionsList = contactUsDropdownOption.getDropdownOptionsList(dropdownName);
    }

    ////</editor-fold>
    ////<editor-fold desc="Then">
    @Then("^I get the current user basic information$")
    public User iGetTheCurrentUserBasicInformation() {
        currentUser.setFirstName(myProfilePage.getInputFirstName());
        currentUser.setLastName(myProfilePage.getInputLastName());
        currentUser.setEmail(myProfilePage.getInputEmail());
        currentUser.setPhone(myProfilePage.getInputTelephone());
        return currentUser;
    }

    @Then("^I check correctness of the \"([^\"]*)\" phone \"([^\"]*)\"$")
    public void iCheckCorrectnessOfThePhone(String serviceName, String expectedPhoneNumber) {
        String actualPhoneNumber = contactUsTakeover.getServicePhone(serviceName);
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
        Log.info(String.format("Correctness of the %s phone number was checked", serviceName));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the \"([^\"]*)\" dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheDropdown(String expectedPlaceholder, String dropdownName) {
        String actualPlaceholder = contactUsTakeover.getDropdownPlaceholder(dropdownName).toUpperCase();
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
        Log.info(String.format("Placeholder for the '%s' dropdown was checked", dropdownName));
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the \"([^\"]*)\" input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheInputField(String expectedPlaceholder, String inputFieldName) {
        String actualPlaceholder = contactUsTakeover.getInputFieldPlaceholder(inputFieldName);
        String actualValue = contactUsTakeover.getInputFieldValue(inputFieldName);
        String expectedValue = "";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
        Assert.assertEquals(actualValue, expectedValue, String.format("\nAR doesn't match ER: \nAR: %s; ER: %s", actualValue, expectedValue));
        Log.info(String.format("Placeholder for the '%s' input field was checked", inputFieldName));
    }

    @Then("^I compare the actual options list with the expected options list$")
    public void iCompareTheActualOptionsListWithTheExpectedOptionsList(List<String> expectedOptionsList) {
        Assert.assertEquals(actualOptionsList, expectedOptionsList, String.format("\nAR doesn't match ER. \nActual list: %s.\nExpected list: %s", actualOptionsList, expectedOptionsList));
        Log.info("Actual options list was compared to expected options list");
    }

    @Then("^I check the \"([^\"]*)\" radio button is preselected by default$")
    public void iCheckThePhoneRadioButtonIsPreselectedByDefault(String radioButtonName) {
        WebElement webElement = contactUsTakeover.getRadioButton(radioButtonName);
        Assert.assertTrue(webElement.isSelected(), "\nPhone radio button is not preselected by default");
        Log.info("Default radio button selection was checked");
    }

    @Then("^I select the \"([^\"]*)\" radio button$")
    public void iSelectTheEmailRadioButton(String radioButtonName) {
        contactUsTakeover.selectRadioButton(radioButtonName);
        Log.info(String.format("Radio button %s was selected", radioButtonName));
    }

    @Then("^I check that input fields are pre-populated with current user data available$")
    public boolean iCheckThatInputFieldsArePrePopulatedWithCurrentUserDataAvailable() {
        User userToContact = new User();
        userToContact.setFirstName(contactUsTakeover.getInputFirstName());
        userToContact.setLastName(contactUsTakeover.getInputLastName());
        userToContact.setEmail(contactUsTakeover.getInputEmail());
        userToContact.setPhone(contactUsTakeover.getInputTelephone());

        Log.info("Equality of pre-populated values to the current user's data was checked");
        return Objects.equals(currentUser.getFirstName(), userToContact.getFirstName()) &&
                Objects.equals(currentUser.getLastName(), userToContact.getLastName()) &&
                Objects.equals(currentUser.getEmail(), userToContact.getEmail()) &&
                Objects.equals(currentUser.getPhone(), userToContact.getPhone());
    }

////</editor-fold>
}