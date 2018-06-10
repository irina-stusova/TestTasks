package com.company.lessons.tests;

import com.company.lessons.browser.Browser;
import com.company.lessons.lesson15.AutocompleteList;
import com.company.lessons.lesson15.UkrZalSearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Lesson15StepDefs {
    private UkrZalSearchPage ukrZalSearchPage = new UkrZalSearchPage();
    private List<AutocompleteList> autocompleteListOptions = new ArrayList<AutocompleteList>() {
        @Override
        public AutocompleteList get(int index) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    };
    //    private TrainsListPage train = new TrainsListPage();
    //private WebElement webElement;
    Select oSelect;


    @When("^I enter the text \"([^\"]*)\" into the From input field$")
    public void IEnterTheTextIntoTheFromInputField(String query) {
        ukrZalSearchPage.setSearchQueryFrom(query);
    }

    @When("^I enter the text \"([^\"]*)\" into the To input field$")
    public void iEnterTheTextIntoTheToInputField(String query) {
        ukrZalSearchPage.setSearchQueryTo(query);
    }

    @Then("^The autocomplete list with id \"([^\"]*)\" is shown$")
    public List<AutocompleteList> theAutocompleteListWithIdIsShown(String id) {
        String block = "//ul[@id='" + id + "']/li[%s]";
        int count = Browser.findElements(By.xpath(String.format(block, "*"))).size();
        for (int i = 1; i <= count; i++) {
            AutocompleteList option = new AutocompleteList();
            option.setListOption(Browser.findElement(By.xpath(String.format(block, i))).getText());
            autocompleteListOptions.add(option);
        }
        return autocompleteListOptions;
    }

    @And("^I select the option from list matching my query \"([^\"]*)\"$")
    public void iSelectTheOptionFromListMatchingMyQuery(String query) {
        for (int i = 0; i < autocompleteListOptions.size(); i++) {
            AutocompleteList option = autocompleteListOptions.get(i);
            if (option.toString().equalsIgnoreCase(query)) {
                option.click();
//                oSelect = new Select(option);
//                oSelect.selectByValue(query);
            } else {
                break;
            }
        }
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
