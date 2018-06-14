package com.company.lessons.tests;

import com.company.lessons.browser.Browser;
import com.company.lessons.lesson15.UkrZalSearchPage;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

import static com.company.lessons.browser.Browser.findElement;
import static com.company.lessons.browser.Browser.wait;

public class Lesson15StepDefs {
    private UkrZalSearchPage ukrZalSearchPage = new UkrZalSearchPage();

    @When("^I enter the text \"([^\"]*)\" into the From input field$")
    public void IEnterTheTextIntoTheFromInputField(String query) {
        ukrZalSearchPage.setSearchQueryFrom(query);
    }

    @When("^I enter the text \"([^\"]*)\" into the To input field$")
    public void iEnterTheTextIntoTheToInputField(String query) {
        ukrZalSearchPage.setSearchQueryTo(query);
    }

    @Then("^I select the option matching my query \"([^\"]*)\" from list with id \"([^\"]*)\"$")
    public void iSelectTheOptionMatchingMyQueryFromListWithId(String query, String id) {
        try {
            WebElement autoOptions = findElement(By.id(id));
            wait.until(ExpectedConditions.visibilityOf(autoOptions));

            List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
            for (WebElement option : optionsToSelect) {
                if (option.getText().equalsIgnoreCase(query)) {
                    option.click();
                    break;
                }
            }
        } catch (
                NoSuchElementException e) {
            System.out.println(e.getStackTrace());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }


    @When("^I click the Calendar field$")
    public void iClickTheCalendarField() {
        By calendar = ukrZalSearchPage.calendar();
        Browser.getInst().click(calendar);

//        WebElement month = findElement(calendar);
//        Select monthCombo = new Select((WebElement) calendar);
//        monthCombo.selectByVisibleText("Июль");

        Browser.getInst().click(By.linkText("30"));
    }

    @When("^I click the Departure Day link$")
    public void iClickTheDepartureDayLink() {
        By linkTomorrow = ukrZalSearchPage.linkTomorrow();
        Browser.getInst().click(linkTomorrow);
    }

    @When("^I click the Search Trains On button$")
    public void iClickTheSearchTrainsOnButton() {
        By buttonSearch = ukrZalSearchPage.buttonSearch();
        Browser.getInst().click(buttonSearch);
    }


    @Then("^I'm presented with search results$")
    public void iMPresentedWithSearchResults() {
        String noTrains = "По заданному Вами направлению мест нет.\nНо Вы можете посмотреть маршруты с пересадкой.";
        By searchError = ukrZalSearchPage.searchError();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement searchErrorMessage = findElement(searchError);
        if (searchErrorMessage.getText().equalsIgnoreCase(noTrains)) {
            System.out.println("No trains available yet!");
        } else {
            // to be continued ...
            System.out.println("Uppsssss");
        }
    }
}
