package com.company.lessons.qaFleetInsight.loginPage;

import com.company.lessons.browser.Browser;
import org.openqa.selenium.By;

public class LoginPageFooter {
    private static final String LOGIN_PAGE_URL_IDENTIFIER = "https://qa.fleetinsight.com";
    private static final String LINK_CONTACT_US_XPATH = "//div[@class='site-footer__container']//a[@href='/fiportal/public/contact-us']";
    private static final String LINK_GOPENSKE_HREF = "//a[contains(text(), 'gopenske.com')]";
    private static final String LINK_USED_TRUCKS_HREF = "//a[contains(text(), 'Used Trucks')]";
    private static final String LINK_PENSKE_NEWS_HREF = "//a[contains(text(), 'Penske News')]";
    private static final String LABEL_SUPPORT_PHONE_HREF = "//footer[@class='site-footer']//div[@class='site-footer__247-info']/h2";
    private static final String LABEL_COPYRIGHT_ID = "copyRight";
    private static final String LINK_PRIVACY_POLICY_HREF = "//a[contains(text(), 'Privacy Policy')]";
    private static final String LINK_TERMS_AND_CONDITIONS_HREF = "//a[contains(text(), 'Terms and Conditions')]";
    private static final String LINK_LEGALIZATION_SERVICES_HREF = "//section[@class='site-footer__for-customers']//a[@href='https://www.pensketruckleasing.com/for-customers/legalization-services/']";
    private static final String LINK_SAFETY_BULLETINS_HREF = "//section[@class='site-footer__for-customers']//a[@href='https://www.pensketruckleasing.com/for-customers/safety-bulletins/']";

    public String getLoginPageUrlIdentifier() {
        return LOGIN_PAGE_URL_IDENTIFIER;
    }

    public String getLinkContactUs() {
        return "https://qa.fleetinsight.com" + Browser.findElement(linkContactUs()).getAttribute("href");
    }

    public String getLinkGopenske() {
        return Browser.findElement(linkGoPenske()).getAttribute("href");
    }

    public String getLinkUsedTrucks() {
        return Browser.findElement(linkUsedTrucks()).getAttribute("href");
    }

    public String getLinkPenskeNews() {
        return Browser.findElement(linkPenskeNews()).getAttribute("href");
    }

    public String getLabelSupportPhone() {
        return Browser.findElement(supportPhone()).getText();
    }

    public String getLabelCopyright() {
        return Browser.findElement(copyRight()).getText();
    }

    public String getLinkPrivacyPolicy() {
        return Browser.findElement(linkPrivacyPolicy()).getAttribute("href");
    }

    public String getLinkTermsAndConditions() {
        return Browser.findElement(linkTermsAndConditions()).getAttribute("href");
    }

    public String getLinkLegalizationServices() {
        return Browser.findElement(linkLegalizationServices()).getAttribute("href");
    }

    public String getNameLegalizationServices() {
        return Browser.findElement(linkLegalizationServices()).getText();
    }

    public String getLinkSafetyBulletins() {
        return Browser.findElement(linkSafetyBulletins()).getAttribute("href");
    }

    public String getNameSafetyBulletins() {
        return Browser.findElement(linkSafetyBulletins()).getText();
    }

    public By linkContactUs() {
        return By.xpath(LINK_CONTACT_US_XPATH);
    }

    public By linkGoPenske() {
        return By.xpath(LINK_GOPENSKE_HREF);
    }

    public By linkUsedTrucks() {
        return By.xpath(LINK_USED_TRUCKS_HREF);
    }

    public By linkPenskeNews() {
        return By.xpath(LINK_PENSKE_NEWS_HREF);
    }

    public By supportPhone() {
        return By.xpath(LABEL_SUPPORT_PHONE_HREF);
    }

    public By copyRight() {
        return By.id(LABEL_COPYRIGHT_ID);
    }

    public By linkPrivacyPolicy() {
        return By.xpath(LINK_PRIVACY_POLICY_HREF);
    }

    public By linkTermsAndConditions() {
        return By.xpath(LINK_TERMS_AND_CONDITIONS_HREF);
    }

    public By linkLegalizationServices() {
        return By.xpath(LINK_LEGALIZATION_SERVICES_HREF);
    }

    public By linkSafetyBulletins() {
        return By.xpath(LINK_SAFETY_BULLETINS_HREF);
    }
}
