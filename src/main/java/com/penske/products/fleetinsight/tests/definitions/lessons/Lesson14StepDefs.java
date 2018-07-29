package com.penske.products.fleetinsight.tests.definitions.lessons;

import com.penske.core.framework.Browser;
import com.penske.core.framework.Log;
import com.penske.lessons.lesson14.GooglePage;
import com.penske.lessons.lesson14.SearchResultsItem;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class Lesson14StepDefs {

    private GooglePage googlePage = new GooglePage();
    private List<SearchResultsItem> searchResultsItems = new ArrayList<>();

    private WebElement webElement;
    //    private String header;
    private String url;
//    private String content;

    @Given("^I open url \"([^\"]*)\"$")
    public void iOpenUrl(String url) {
        Browser.getUrl(url);
        Log.info(String.format("Url %s was opened", url));
    }

    @When("^I enter the text \"([^\"]*)\" into the Search input field$")
    public void iEnterTheTextIntoTheSearchInputField(String query) {
        googlePage.setSearchQuery(query);
    }

    @When("^I click the Enter key$")
    public void iClickTheEnterKey() {
        googlePage.search();
    }

    @Then("^I'm presented with the list of search results$")
    public List<SearchResultsItem> iMPresentedWithTheListOfSearchResults() {
        String block = "//div[@id='rso']//div[1]/div[@class='srg']//div[@class='g'][%s]";
        int count = Browser.findElements(By.xpath(String.format(block, "*"))).size();

        for (int i = 1; i <= count; i++) {
            SearchResultsItem item = new SearchResultsItem();
            item.setUrl(Browser.findElement(By.xpath(String.format(block, i) + "//cite")).getText());
            item.setHeader(Browser.findElement(By.xpath(String.format(block, i) + "//h3/a")).getText());
            item.setContent(Browser.findElement(By.xpath(String.format(block, i) + "//span[@class='st']")).getText());

            searchResultsItems.add(item);
        }
        return searchResultsItems;
    }

    @When("^I click the (\\d+) search result link$")
    public void iClickTheSearchResultLink(int n) {
        webElement = searchResultsItems.get(n);
        url = searchResultsItems.get(n).getUrl(webElement);
        Browser.getUrl(searchResultsItems.get(n).getUrl(webElement));
    }

    @Then("^I get the page url opened and compare it to required link$")
    public void iGetThePageUrlOpenedAndCompareItToRequiredLink() {
        String currentUrl = Browser.getCurrentUrl();

        if (currentUrl.equals(url)) {
            System.out.println(String.format("Required url is opened: %s", currentUrl));
        } else {
            System.out.println(String.format("Incorrect url is opened: %s", currentUrl));
        }
    }
}