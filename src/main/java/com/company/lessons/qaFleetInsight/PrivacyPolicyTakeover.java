package com.company.lessons.qaFleetInsight;

import org.openqa.selenium.By;

public class PrivacyPolicyTakeover {
    private static final String PRIVACY_POLICY_PAGE_URL_IDENTIFIER = "https://qa.fleetinsight.com/fiportal/public/policy";
    private static final String BUTTON_CLOSE_XPATH = "//nav[@ui-view='header']//span[@svg-path='icon-x']";

    public String getContactUsPageUrlIdentifier() {
        return PRIVACY_POLICY_PAGE_URL_IDENTIFIER;
    }

    public By buttonClose() {
        return By.xpath(BUTTON_CLOSE_XPATH);
    }
}
