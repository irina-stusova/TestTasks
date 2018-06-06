package com.company.lessons.tests;

import com.company.lessons.browser.Browser;
import com.company.lessons.lesson15.TrainsListPage;
import com.company.lessons.lesson15.UkrZalSearchPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.company.lessons.browser.Browser.findElement;

public class Lesson15StepDefs {
    private UkrZalSearchPage ukrZalSearchPage = new UkrZalSearchPage();
    //    private TrainsListPage train = new TrainsListPage();
    private By webElement;
    Select oSelect = new Select((WebElement) webElement);

//    @Given("^I open url \"([^\"]*)\"$")
//    public void iOpenUrl(String url) {
//        Browser.getInst().getUrl(url);
//    }

    @When("^I enter the text \"([^\"]*)\" into the From input field$")
    public void IEnterTheTextIntoTheFromInputField(String query) {
        ukrZalSearchPage.setSearchQueryFrom(query);
        webElement = ukrZalSearchPage.autocompleteFrom();
        //Select oSelect = new Select((WebElement) webElement);
        oSelect.selectByValue("Киев");
    }

    @When("^I enter the text \"([^\"]*)\" into the To input field$")
    public void iEnterTheTextIntoTheToInputField(String query) {
        ukrZalSearchPage.setSearchQueryTo(query);
        webElement = ukrZalSearchPage.autocompleteTo();
        oSelect.selectByValue("Мелитополь");
    }

    @When("^I click the Day link$")
    public void iClickTheDayLink() {
        By linkTomorrow = ukrZalSearchPage.linkTomorrow();
        Browser.getInst().click(linkTomorrow);
    }

    @When("^I click the Search Trains On button$")
    public void iClickTheSearchTrainsOnButton() {
        By buttonSearch = ukrZalSearchPage.buttonSearch();
        Browser.getInst().click(buttonSearch);
    }
}
