package com.penske.products.fleetinsight.footer;

import com.penske.core.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Footer {
    //CONTACT INFO section
    private static final String LINK_CONTACT_US_XPATH = "//a[@class='site-footer__link site-footer__link--contact-us']";
    private static final String LINKS_EXTERNAL_HREF ="//a[@class='site-footer__link external'][contains(text(), '%s')]";
    //24/7 INFO section
    private static final String LABEL_SUPPORT_PHONE_HREF = "//Footer//div[@class='site-footer__247-info']/h2";
    //FOR CUSTOMERS section
    private static final String LINKS_FOR_CUSTOMERS_HREF ="//div[@class='site-footer__for-customers--link-container']/a[contains(text(), '%s')]";
    //FOOTER BOTTOM section
    private static final String LABEL_COPYRIGHT_ID = "copyRight";
    private static final String LINKS_INTERNAL_HREF ="//a[@class='site-footer__link'][contains(text(), '%s')]";


    public static String getLinkContactUsXpath() {
        return LINK_CONTACT_US_XPATH;
    }

    public static String getLinksExternalHref() {
        return LINKS_EXTERNAL_HREF;
    }

    public static String getLabelSupportPhoneHref() {
        return LABEL_SUPPORT_PHONE_HREF;
    }

    public static String getLinksForCustomersHref() {
        return LINKS_FOR_CUSTOMERS_HREF;
    }

    public static String getLabelCopyrightId() {
        return LABEL_COPYRIGHT_ID;
    }

    public static String getLinksInternalHref() {
        return LINKS_INTERNAL_HREF;
    }


    public void clickLink(String linkName) {
        String linkXpath = "";
        switch (linkName) {
            case "Contact Us":
                linkXpath = LINK_CONTACT_US_XPATH;
                break;
            case "gopenske.com":
                linkXpath = String.format(LINKS_EXTERNAL_HREF, linkName);
                break;
            case "Used Trucks":
                linkXpath = String.format(LINKS_EXTERNAL_HREF, linkName);
                break;
            case "Penske News":
                linkXpath = String.format(LINKS_EXTERNAL_HREF, linkName);
                break;
            case "Privacy Policy":
                linkXpath = String.format(LINKS_INTERNAL_HREF, linkName);
                break;
            case "Terms and Conditions":
                linkXpath = String.format(LINKS_INTERNAL_HREF, linkName);
                break;
            case "Safety bulletins":
                linkXpath = String.format(LINKS_FOR_CUSTOMERS_HREF, linkName);
                break;
            case "Legalization services":
                linkXpath = String.format(LINKS_FOR_CUSTOMERS_HREF, linkName);
                break;
            case "Safety Bulletins":
                linkXpath = String.format(LINKS_FOR_CUSTOMERS_HREF, linkName);
                break;
            case "Legalization Services":
                linkXpath = String.format(LINKS_FOR_CUSTOMERS_HREF, linkName);
                break;
            default:
                throw new RuntimeException(String.format("No such link name %s", linkName));
        }
        By link = By.xpath(linkXpath);
        WebElement webElement = Browser.findElement(By.xpath(linkXpath));
        Browser.click(link, webElement);
    }


    public String getSupportPhone() {
        String supportPhone = Browser.findElement(supportPhone()).getText();
        Pattern pattern = Pattern.compile("\\d{1}-\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(supportPhone);
        if (matcher.find()) {
            supportPhone = matcher.group();
        }
        return supportPhone;
    }

    public String getCopyrightYear() {
        return Browser.findElement(copyRight()).getText();
    }

    //BYs
    private By supportPhone() {
        return By.xpath(LABEL_SUPPORT_PHONE_HREF);
    }

    private By copyRight() {
        return By.id(LABEL_COPYRIGHT_ID);
    }

    private By linkContactUs() {
        return By.xpath(LINK_CONTACT_US_XPATH);
    }

    private By linksExternal(String linkName) {
        return By.xpath(String.format(LINKS_EXTERNAL_HREF, linkName));
    }

    private By linksInternal(String linkName) {
        return By.xpath(String.format(LINKS_INTERNAL_HREF, linkName));
    }

    private By linksForCustomers(String linkName) {
        return By.xpath(String.format(LINKS_FOR_CUSTOMERS_HREF, linkName));
    }
}
