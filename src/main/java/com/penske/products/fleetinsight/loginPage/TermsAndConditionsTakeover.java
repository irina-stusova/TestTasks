package com.penske.products.fleetinsight.loginPage;

import org.openqa.selenium.By;

public class TermsAndConditionsTakeover {
    private static final String TERMS_AND_CONDITIONS_PAGE_URL_IDENTIFIER = "https://qa.fleetinsight.com/fiportal/public/terms-of-use";
    private static final String BUTTON_CLOSE_XPATH = "//nav[@ui-view='header']//span[@svg-path='icon-x']";

    public String getContactUsPageUrlIdentifier() {
        return TERMS_AND_CONDITIONS_PAGE_URL_IDENTIFIER;
    }

    public By buttonClose() {
        return By.xpath(BUTTON_CLOSE_XPATH);
    }
}
