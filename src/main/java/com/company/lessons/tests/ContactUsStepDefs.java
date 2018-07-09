package com.company.lessons.tests;

import com.company.lessons.browser.Browser;
import com.company.lessons.qaFleetInsight.loginPage.takeoverContactUs.ContactUsDropdownOption;
import com.company.lessons.qaFleetInsight.loginPage.takeoverContactUs.ContactUsTakeover;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactUsStepDefs {
    private ContactUsTakeover contactUsTakeover = new ContactUsTakeover();
    List<ContactUsDropdownOption> actualOptionsList = new ArrayList<>();

    @Then("^I check correctness of the Customer Service phone \"([^\"]*)\"$")
    public void iCheckCorrectnessOfTheCustomerServicePhone(String expectedPhoneNumber) {
        String actualPhoneNumber = contactUsTakeover.getCustomerServicePhone().substring(81, 95);
        actualPhoneNumber = actualPhoneNumber.replaceAll("\\D", "");
        if (expectedPhoneNumber.equals(actualPhoneNumber)) {
            System.out.println(String.format("\nActual result matches Expected result for the Customer Service phone: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
            System.out.println();
        } else {
            System.out.println(String.format("\nActual result doesn't match Expected result: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
            System.out.println();
        }
    }

    @And("^I check correctness of the Road Assistance phone \"([^\"]*)\"$")
    public void iCheckCorrectnessOfTheRoadAssistancePhone(String expectedPhoneNumber) {
        String actualPhoneNumber = contactUsTakeover.getRoadAssistancePhone().substring(45, 59);
        actualPhoneNumber = actualPhoneNumber.replaceAll("\\D", "");
        if (expectedPhoneNumber.equals(actualPhoneNumber)) {
            System.out.println(String.format("\nActual result matches Expected result for the Road Assistance phone: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
            System.out.println();
        } else {
            System.out.println(String.format("\nActual result doesn't match Expected result: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
            System.out.println();
        }
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Salutation dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheSalutationDropdown(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderSalutation().toUpperCase();
        if (expectedPlaceholder.equals(actualPlaceholder)) {
            System.out.println(String.format("\nAR matches ER for the Salutation dropdown placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        } else {
            System.out.println(String.format("\nAR doesn't match ER for the Salutation dropdown placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        }
    }

    @And("^I check that \"([^\"]*)\" is shown as a placeholder for the Best Time To Reach You dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheBestTimeToReachYouDropdown(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderBestTimeToReach().toUpperCase();
        if (expectedPlaceholder.equals(actualPlaceholder)) {
            System.out.println(String.format("\nAR matches ER for the Best Time To Reach You dropdown placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        } else {
            System.out.println(String.format("\nAR doesn't match ER for the Best Time To Reach You dropdown placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        }
    }

    @And("^I check that \"([^\"]*)\" is shown as a placeholder for the Reason For Contact dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheReasonForContactDropdown(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderReasonForContact().toUpperCase();
        if (expectedPlaceholder.equals(actualPlaceholder)) {
            System.out.println(String.format("\nAR matches ER for the Reason For Contact dropdown placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        } else {
            System.out.println(String.format("\nAR doesn't match ER for the Reason For Contact dropdown placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        }
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the First Name input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheFirstNameInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderFirstName();
        if (expectedPlaceholder.equalsIgnoreCase(actualPlaceholder)) {
            System.out.println(String.format("\nAR matches ER for the First Name Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        } else {
            System.out.println(String.format("\nAR doesn't match ER for the First Name Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        }
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Last Name input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheLastNameInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderLastName();
        if (expectedPlaceholder.equalsIgnoreCase(actualPlaceholder)) {
            System.out.println(String.format("\nAR matches ER for the Last Name Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        } else {
            System.out.println(String.format("\nAR doesn't match ER for the Last Name Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        }
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Email input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheEmailInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderEmail();
        if (expectedPlaceholder.equalsIgnoreCase(actualPlaceholder)) {
            System.out.println(String.format("\nAR matches ER for the Email Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        } else {
            System.out.println(String.format("\nAR doesn't match ER for the Email Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        }
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Alternative Email input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheAlternativeEmailInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderAlternativeEmail();
        if (expectedPlaceholder.equalsIgnoreCase(actualPlaceholder)) {
            System.out.println(String.format("\nAR matches ER for the Alternative Email Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        } else {
            System.out.println(String.format("\nAR doesn't match ER for the Alternative Email Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        }
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Telephone input field$")
    public void iCheckThatIsShownAsAPlaceholderForTheTelephoneInputField(String expectedPlaceholder) {
        String actualPlaceholder = contactUsTakeover.getPlaceholderTelephone();
        if (expectedPlaceholder.equalsIgnoreCase(actualPlaceholder)) {
            System.out.println(String.format("\nAR matches ER for the Telephone Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        } else {
            System.out.println(String.format("\nAR doesn't match ER for the Telephone Input field placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        }
    }


    @When("^I click the Salutation dropdown control$")
    public void iClickTheSalutationDropdownControl() {
        By dropdownControlSalutation = contactUsTakeover.dropdownControlSalutation();
        WebElement webElement = Browser.findElement(dropdownControlSalutation);
        Browser.getInst().click(dropdownControlSalutation, webElement);
    }

    @And("^I get the Salutation dropdown options as a list$")
    public List<ContactUsDropdownOption> iGetTheSalutationDropdownOptionsAsAList() {

        String block = ".//dropdown-list//ul[@aria-labelledby='combobox__1']/li";
        String block1 = block + "[%s]";
        int count = Browser.findElements(By.xpath(block)).size();

        for (int i = 1; i <= count; i++) {
            ContactUsDropdownOption option = new ContactUsDropdownOption();
            option.setDropdownOption(Browser.findElement(By.xpath(String.format(block1, i))).getText());
            actualOptionsList.add(option);
        }
        return actualOptionsList;
    }

    @When("^I click the Best Time To Reach You dropdown control$")
    public void iClickTheBestTimeToReachYouDropdownControl() {
        By dropdownControlBestTime = contactUsTakeover.dropdownControlBestTime();
        WebElement webElement = Browser.findElement(dropdownControlBestTime);
        Browser.getInst().click(dropdownControlBestTime, webElement);
    }

    @And("^I get the Best Time To Reach You dropdown options as a list$")
    public List<ContactUsDropdownOption> iGetTheBestTimeToReachYouDropdownOptionsAsAList() {

        String block = ".//dropdown-list//ul[@aria-labelledby='combobox__2']/li";
        String block1 = block + "[%s]";
        int count = Browser.findElements(By.xpath(block)).size();

        for (int i = 1; i <= count; i++) {
            ContactUsDropdownOption option = new ContactUsDropdownOption();
            option.setDropdownOption(Browser.findElement(By.xpath(String.format(block1, i))).getText());
            actualOptionsList.add(option);
        }
        return actualOptionsList;
    }


    @When("^I click the Reason For Contact dropdown control$")
    public void iClickTheReasonForContactDropdownControl() {
        By dropdownControlContactReason = contactUsTakeover.dropdownControlContactReason();
        WebElement webElement = Browser.findElement(dropdownControlContactReason);
        Browser.getInst().click(dropdownControlContactReason, webElement);
    }

    @And("^I get the Reason For Contact dropdown options as a list$")
    public List<ContactUsDropdownOption> iGetTheReasonForContactDropdownOptionsAsAList() {

        String block = ".//dropdown-list//ul[@aria-labelledby='combobox__3']/li";
        String block1 = block + "[%s]";
        int count = Browser.findElements(By.xpath(block)).size();

        for (int i = 1; i <= count; i++) {
            ContactUsDropdownOption option = new ContactUsDropdownOption();
            option.setDropdownOption(Browser.findElement(By.xpath(String.format(block1, i))).getText());
            actualOptionsList.add(option);
        }
        return actualOptionsList;
    }

    @Then("^I compare the actual options list with the expected options list$")
    public void iCompareTheActualOptionsListWithTheExpectedOptionsList(DataTable table) {
        List<DataTableRow> expectedOptionsList = table.getGherkinRows();
//        this.actualOptionsList = actualOptionsList;
        List<Str>exp=table;
        actualOptionsList.sort(ASC);
        exp.sort(ASC);
//        actualOptionsList.equals(exp);
                Assert.asertEqual(actualOptionsList,exp,
                        String.format("Act list is not equal to exp. Act %s",))
        if ((actualOptionsList.size() == expectedOptionsList.size()) && (actualOptionsList.retainAll(expectedOptionsList))) {
            System.out.println("\nAR matches ER");
            System.out.println("\nActual Dropdown Options List:");
            for (ContactUsDropdownOption o : actualOptionsList) {
                System.out.println(o.getText() + " ");
            }
            System.out.println();
            System.out.println("\nExpected Dropdown Options List:");

            for (DataTableRow row : expectedOptionsList) {
                List<String> cells = row.getCells();
                for (String cell : cells) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("\nAR doesn't match ER");
            System.out.println("\nActual Dropdown Options List:");
            for (ContactUsDropdownOption o : actualOptionsList) {
                System.out.println(o.getText() + " ");
            }
            System.out.println("\nExpected Dropdown Options List:");

            expectedOptionsList = table.getGherkinRows();
            for (DataTableRow row : expectedOptionsList) {
                List<String> cells = row.getCells();
                for (String cell : cells) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
    }

    @Then("^I check the Phone radio button is preselected by default$")
    public boolean iCheckThePhoneRadioButtonIsPreselectedByDefault() {
        By radioButtonPhone = contactUsTakeover.radioButtonPhone();
        WebElement webElement = Browser.findElement(radioButtonPhone);

        if (webElement.isSelected()){
            System.out.println("\nPhone radio button is preselected by default");
            return true;
            } else{
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
