package com.company.lessons.tests;

import com.company.lessons.lesson14.Browser;
import com.company.lessons.lesson14.GooglePage;
import com.company.lessons.lesson14.SearchResultsItem;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Lesson14StepDefs {

    private GooglePage googlePage = new GooglePage();
//    private SearchResultsItem searchItem1 = new SearchResultsItem();
//    private SearchResultsItem searchItem2 = new SearchResultsItem();
    private String header;
    private String url;
    private String content;
    private List<String> urls;

    @Given("^I open url \"([^\"]*)\"$")
    public void iOpenUrl(String url) {
        Browser.getInst().getUrl(url);
    }

    @When("^I enter the text \"([^\"]*)\" into the Search input field$")
    public void iEnterTheTextIntoTheSearchInputField(String query) {
        googlePage.setSearchQuery(query);
    }

    @Then("^I click the Enter key$")
    public void iClickTheEnterKey() {
        googlePage.search();
    }

    @Then("^I do the most insane things I have ever done$")
    public List<String> iDoTheMostInsaneThingsIHaveEverDone() {
//        List<SearchResultsItem> searchResultsItems = new ArrayList<>();
//
//        header = searchItem1.getHeader(Browser.getInst().findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/h3/a")));
//        url = searchItem1.getUrl(Browser.getInst().findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/div/div/cite")));
//        content = searchItem1.getContent(Browser.getInst().findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/div/span/text()")));
//
//        searchResultsItems.add(new SearchResultsItem(header, url, content));
//
//        header = searchItem2.getHeader(Browser.getInst().findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[2]/div/div/h3/a")));
//        url = searchItem2.getUrl(Browser.getInst().findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[2]/div/div/div[1]/div/div[1]/cite")));
//        content = searchItem2.getContent(Browser.getInst().findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[2]/div/div/div[1]/div/span/text()")));
//
//        searchResultsItems.add(new SearchResultsItem(header, url, content));


        List<WebElement> searchResultsDivs = Browser.findElements(By.xpath("//*[@id=\"rso\"]/div[5]/div/div[1-6]/div"));

        for (int i = 0; i < searchResultsDivs.size(); i++) {
            url = searchResultsDivs.get(i).findElement(By.tagName("cite")).getText();
            urls.add(url);
        }
            return urls;

        Browser.getInst().getUrl(urls.get(0)).click();
    }
}