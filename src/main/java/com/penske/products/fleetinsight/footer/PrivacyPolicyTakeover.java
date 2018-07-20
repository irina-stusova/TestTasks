package com.penske.products.fleetinsight.footer;

import com.penske.core.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PrivacyPolicyTakeover {
    private static final String PRIVACY_POLICY_PAGE_URL_IDENTIFIER = "https://qa.fleetinsight.com/fiportal/public/policy";
    private static final String BUTTON_CLOSE_XPATH = "//nav[@ui-view='header']//span[@svg-path='icon-x']";

    public void clickCloseButton(){
        WebElement webElement = Browser.findElement(buttonClose());
        Browser.focusOnElement(webElement);
        webElement.click();
    }

    private By buttonClose() {
        return By.xpath(BUTTON_CLOSE_XPATH);
    }
}
