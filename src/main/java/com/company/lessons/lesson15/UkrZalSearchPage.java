package com.company.lessons.lesson15;

import com.company.lessons.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.company.lessons.browser.Browser.findElement;

public class UkrZalSearchPage {
    private static final String SEARCH_PAGE_URL_IDENTIFIER = "https://booking.uz.gov.ua/ru/";
    private static final String INPUT_FROM_XPATH = "//div[@class='stations']//input[@name='from-title']";
    private static final String INPUT_TO_XPATH = "//div[@class='stations']//input[@name='to-title']";
    private static final String LINK_TOMORROW_XPATH = "//*[@id='search-frm']//div[@class='link']//a[2]";
    private static final String DATE_CALENDAR_NAME = "date-hover";
    private static final String SELECT_AUTOCOMPLETE_FROM_ID = "ui-id-1";
    private static final String SELECT_AUTOCOMPLETE_TO_ID = "ui-id-2";
    private static final String BUTTON_SUBMIT_SEARCH_XPATH = "//*[@id='search-frm']//button[@type='submit']";
    private static final String SEARCH_ERROR_XPATH = "//div[@id='train-list']//div[@class='search-error']";
    private static final String CURRENT_DATE_XPATH = "//div[@class='date']/input[@type='text'][@value]";
    private static final String INPUT_DATE_XPATH = "//div[@class='date']/input[@type='hidden'][@value]";

    public void setSearchQueryFrom(String query) {
        Browser.getInst().sendQuery(inputQueryFrom(), query);
    }

    public String getSearchQueryFrom() {
        return Browser.getInst().getText(inputQueryFrom());
    }

    public void setSearchQueryTo(String query) {
        Browser.getInst().sendQuery(inputQueryTo(), query);
    }

    public String getSearchQueryTo() {
        return Browser.getInst().getText(inputQueryTo());
    }

    public String getCurrentDateXpath() {
     return findElement(currentDate()).getAttribute(CURRENT_DATE_XPATH);
    }

    public void setInputDate(String date) {
        Browser.getInst().sendQuery(inputDate(), date);
    }

    public void search() {
        Browser.getInst().sendQuery(inputQueryFrom(), Keys.ENTER.toString());
    }


    public By inputQueryFrom() {
        return By.xpath(INPUT_FROM_XPATH);
    }

    public By inputQueryTo() {
        return By.xpath(INPUT_TO_XPATH);
    }

    public By linkTomorrow() {
        return By.xpath(LINK_TOMORROW_XPATH);
    }

    public By autocompleteFrom() {
        return By.id(SELECT_AUTOCOMPLETE_FROM_ID);
    }

    public By autocompleteTo() {
        return By.id(SELECT_AUTOCOMPLETE_TO_ID);
    }

    public By buttonSearch() {
        return By.xpath(BUTTON_SUBMIT_SEARCH_XPATH);
    }

    public By calendar() {
        return By.name(DATE_CALENDAR_NAME);
    }

    public By currentDate() {
        return By.xpath(CURRENT_DATE_XPATH);
    }

    public By inputDate() {
        return By.xpath(INPUT_DATE_XPATH);
    }

    public By searchError() {
        return By.xpath(SEARCH_ERROR_XPATH);
    }
}
