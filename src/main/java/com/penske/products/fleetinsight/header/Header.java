package com.penske.products.fleetinsight.header;

import com.penske.core.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Header {
    private static final String HAMBURGER_MENU_ID = "tour-overview-open-navigation-panel";

    public void clickLeftPanelMenu() {
        WebElement webElement = Browser.findElement(leftPanelMenu());
        Browser.click(leftPanelMenu(), webElement);
    }

    private By leftPanelMenu() {
        return By.id(HAMBURGER_MENU_ID);
    }
}
