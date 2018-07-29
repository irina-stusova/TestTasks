package com.penske.products.fleetinsight.header;

import com.penske.core.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LeftPanel {
    private static final String FOOTER_LEFT_PANEL_XPATH = "//left-menu//div[@class='main-menu__footer']/a[@class='%s']";
    private static final String LINK_MY_PROFILE_CLASS_NAME = "main-menu__footer--name";
    private static final String LINK_LOGOUT_CLASS_NAME = "main-menu__footer--logout";

    public void clickFooterLink(String footerLinkName) {
        String footerLinkClassName;
        switch (footerLinkName) {
            case "My Profile":
                footerLinkClassName = LINK_MY_PROFILE_CLASS_NAME;
                break;
            case "Logout":
                footerLinkClassName = LINK_LOGOUT_CLASS_NAME;
                break;
            default:
                throw new RuntimeException(String.format("No such link name '%s' in the footer", footerLinkName));
        }
        WebElement webElement = Browser.findElement(footerLink(footerLinkClassName));
        By by = footerLink(footerLinkClassName);
        Browser.click(by, webElement);
    }

    private By footerLink(String footerLinkClassName) {
        return By.xpath(String.format(FOOTER_LEFT_PANEL_XPATH, footerLinkClassName));
    }
}
