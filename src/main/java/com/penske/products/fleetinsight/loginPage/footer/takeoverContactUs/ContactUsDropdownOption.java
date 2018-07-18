package com.penske.products.fleetinsight.loginPage.footer.takeoverContactUs;

import com.penske.core.framework.Browser;
import org.openqa.selenium.*;

import java.util.List;

public class ContactUsDropdownOption implements WebElement {

    private String dropdownOption;

    private static final String DROPDOWN_SALUTATION_ID = "combobox__1";
    private static final String DROPDOWN_BEST_TIME_TO_REACH_ID = "combobox__2";
    private static final String DROPDOWN_REASON_FOR_CONTACT_ID = "combobox__3";
    private static final String DROPDOWN_OPTION_XPATH = ".//ul[@aria-labelledby='%s']/li";


    public ContactUsDropdownOption() {};

    public ContactUsDropdownOption(String dropdownOption) {
        this.dropdownOption = dropdownOption;
    };

    //GETTERs
    public String getDropdownOption(WebElement element) {
        return dropdownOption;
    }

    public String getDropdownOption(String dropdownId) {
        return Browser.getText(dropdownOption(dropdownId));
    }

    //SETTERs
    public void setDropdownOption(String dropdownOption) {
        this.dropdownOption = dropdownOption;
    }

    //???
    public void setDrodownOption(String dropdownId, String dropdownOption) {
        Browser.sendQuery(dropdownOption(dropdownId), dropdownOption); }

    //BY
    public By dropdownOption(String dropdownId) {
        return By.xpath(String.format(DROPDOWN_OPTION_XPATH, dropdownId));
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
