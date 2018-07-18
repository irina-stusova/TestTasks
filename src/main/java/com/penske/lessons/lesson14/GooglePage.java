package com.penske.lessons.lesson14;

import com.penske.core.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GooglePage {
    private static final String SEARCH_PAGE_URL_IDENTIFIER = "https://www.google.com";
    public static final String PAGE_IDENTIFIER = "Search Page";
    private static final String LINK_GMAIL_HREF = "//a[contains(text(), 'Gmail')]";
    private static final String LINK_IMAGES_HREF = "//a[contains(text(), 'Images')]";
    private static final String LINK_APPS_HREF = "https://www.google.com.ua/intl/en/options/";
    private static final String INPUT_SEARCH_ID = "lst-ib";
    private static final String BUTTON_VOICE_SEARCH_NAME = "gs_st0";
    private static final String BUTTON_SUBMIT_SEARCH_NAME = "btnK";
    private static final String BUTTON_LUCKY_SEARCH_NAME = "btnI";
    private static final String LINK_RU_HREF = "//a[contains(text(), 'русский')]";
    private static final String LINK_UA_HREF = "//a[contains(text(), 'українська')]";
    private static final String LINK_ENG_HREF = "//a[contains(text(), 'English')]";

    public void setSearchQuery(String query) {
        Browser.sendQuery(inputQuery(), query);
    }

    public String getSearchQuery() {
        return Browser.getText(inputQuery());
    }

    public void search() {
        Browser.sendQuery(inputQuery(), Keys.ENTER.toString());
    }

    public By inputQuery() {
        return By.id(INPUT_SEARCH_ID);
    }

    private By buttonSearch() {
        return By.name(BUTTON_SUBMIT_SEARCH_NAME);
    }

    private By buttonLucky() {
        return By.name(BUTTON_LUCKY_SEARCH_NAME);
    }

    private By buttonVoice() {
        return By.name(BUTTON_VOICE_SEARCH_NAME);
    }

    private By linkSwitchLanguageRu() {
        return By.linkText(LINK_RU_HREF);
    }

    private By linkSwitchLanguageUa() {
        return By.linkText(LINK_UA_HREF);
    }

    private By linkSwitchLanguageEng() {
        return By.linkText(LINK_ENG_HREF);
    }

    private By linkGmail() {
        return By.linkText(LINK_GMAIL_HREF);
    }

    private By linkApps() {
        return By.linkText(LINK_APPS_HREF);
    }

    private By linkImages() {
        return By.linkText(LINK_IMAGES_HREF);
    }
}
