package com.company.lessons.tests;

import com.company.lessons.qaFleetInsight.loginPage.takeoverContactUs.ContactUsTakeover;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ContactUsStepDefs {
    private ContactUsTakeover contactUsTakeover = new ContactUsTakeover();

    @Then("^I check correctness of the Customer Service phone \"([^\"]*)\"$")
    public void iCheckCorrectnessOfTheCustomerServicePhone(String expectedPhoneNumber) {
        String actualPhoneNumber = contactUsTakeover.getCustomerServicePhone().substring(81, 95);
        actualPhoneNumber = actualPhoneNumber.replaceAll("\\D", "");
        if (expectedPhoneNumber.equals(actualPhoneNumber)) {
            System.out.println(String.format("Actual result matches Expected result for the Customer Service phone: \nAR = ER: %s", expectedPhoneNumber));
        } else {
            System.out.println(String.format("Actual result doesn't match Expected result: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
        }
    }

    @And("^I check correctness of the Road Assistance phone \"([^\"]*)\"$")
    public void iCheckCorrectnessOfTheRoadAssistancePhone(String expectedPhoneNumber) {
        String actualPhoneNumber = contactUsTakeover.getRoadAssistancePhone().substring(45, 59);
        actualPhoneNumber = actualPhoneNumber.replaceAll("\\D", "");
        if (expectedPhoneNumber.equals(actualPhoneNumber)) {
            System.out.println(String.format("Actual result matches Expected result for the Road Assistance phone: \nAR = ER: %s", expectedPhoneNumber));
        } else {
            System.out.println(String.format("Actual result doesn't match Expected result: \nAR: %s; ER: %s", actualPhoneNumber, expectedPhoneNumber));
        }
    }

    @Then("^I check that \"([^\"]*)\" is shown as a placeholder for the Salutation dropdown$")
    public void iCheckThatIsShownAsAPlaceholderForTheSalutationDropdown(String expectedPlaceholder) {
    String actualPlaceholder = contactUsTakeover.getPlaceholderSalutation().toUpperCase();
        if (expectedPlaceholder.equals(actualPlaceholder)) {
            System.out.println(String.format("\nAR matches ER for the Salutation dropdown placeholder: \nAR = ER: %s", expectedPlaceholder));
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
            System.out.println(String.format("\nAR matches ER for the Best Time To Reach You dropdown placeholder: \nAR = ER: %s", expectedPlaceholder));
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
            System.out.println(String.format("\nAR matches ER for the Reason For Contact dropdown placeholder: \nAR = ER: %s", expectedPlaceholder));
            System.out.println();
        } else {
            System.out.println(String.format("\nAR doesn't match ER for the Reason For Contact dropdown placeholder: \nAR: %s; ER: %s", actualPlaceholder, expectedPlaceholder));
            System.out.println();
        }
    }
}
