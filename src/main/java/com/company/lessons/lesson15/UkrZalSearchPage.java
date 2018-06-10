package com.company.lessons.lesson15;

import com.company.lessons.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class UkrZalSearchPage {
    private static final String SEARCH_PAGE_URL_IDENTIFIER = "https://booking.uz.gov.ua/ru/";
    private static final String INPUT_FROM_NAME = "//div[@class='stations']//input[@name='from-title']";
    private static final String INPUT_TO_NAME = "//div[@class='stations']//input[@name='to-title']";
    private static final String LINK_TOMORROW_XPATH = "//*[@id='search-frm']//div[@class='link']//a[2]";
    private static final String DATE_CALENDAR_NAME = "date-hover";
    private static final String SELECT_AUTOCOMPLETE_FROM_ID = "ui-id-1";
    private static final String SELECT_AUTOCOMPLETE_TO_ID = "ui-id-2";
    private static final String BUTTON_SUBMIT_SEARCH_XPATH = "//*[@id='search-frm']//button";

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

    public void search() {
        Browser.getInst().sendQuery(inputQueryFrom(), Keys.ENTER.toString());
    }

    public By inputQueryFrom() {
        return By.xpath(INPUT_FROM_NAME);
    }

    public By inputQueryTo() {
        return By.xpath(INPUT_TO_NAME);
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
}
