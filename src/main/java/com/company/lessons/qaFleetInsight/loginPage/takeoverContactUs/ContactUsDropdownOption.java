package com.company.lessons.qaFleetInsight.loginPage.takeoverContactUs;

import com.company.lessons.browser.Browser;
import org.openqa.selenium.*;
import java.util.List;

public class ContactUsDropdownOption implements WebElement {

    private String dropdownOption;
    //DROPDOWNS OPTIONS
    private static final String DROPDOWN_OPTION_SALUTATION_XPATH = ".//ul[@aria-labelledby='combobox__1']/li";
    private static final String DROPDOWN_OPTION_BEST_TIME_TO_REACH_XPATH = ".//ul[@aria-labelledby='combobox__2']/li";
    private static final String DROPDOWN_OPTION_REASON_FOR_CONTACT_XPATH = ".//ul[@aria-labelledby='combobox__3']/li";

    public ContactUsDropdownOption(){};

    public ContactUsDropdownOption(String dropdownOption) {
        this.dropdownOption = dropdownOption;
    };

    //GETTERs
    public String getDropdownOption(WebElement element) {
        return dropdownOption;
    }
    public String getDropdownOptionSalutation() {
        return Browser.getInst().getText(dropdownOptionSalutation());
    }
    public String getDropdownOptionBestTimeToReach() {
        return Browser.getInst().getText(dropdownOptionBestTimeToReach());
    }
    public String getDropdownOptionReasonForContact() {
        return Browser.getInst().getText(dropdownOptionReasonForContact());
    }

    //SETTERs
    public void setDropdownOption(String dropdownOption) {
        this.dropdownOption = dropdownOption;
    }
    //???
    public void setSalutation(String salutation) {
        Browser.getInst().sendQuery(dropdownOptionSalutation(), salutation);
    }

    public void setBestTimeToReach(String timeToReach) {
        Browser.getInst().sendQuery(dropdownOptionBestTimeToReach(), timeToReach);
    }

    public void setReasonForContact(String reason) {
        Browser.getInst().sendQuery(dropdownOptionReasonForContact(), reason);
    }

    //BY
    public By dropdownOptionSalutation() {
        return By.xpath(DROPDOWN_OPTION_SALUTATION_XPATH);
    }

    public By dropdownOptionBestTimeToReach() {
        return By.xpath(DROPDOWN_OPTION_BEST_TIME_TO_REACH_XPATH);
    }

    public By dropdownOptionReasonForContact() {
        return By.xpath(DROPDOWN_OPTION_REASON_FOR_CONTACT_XPATH);
    }

    @Override
    public void click() {

    }

    @Override
    public void submit() {
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
    }

    @Override
    public void clear() {
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
