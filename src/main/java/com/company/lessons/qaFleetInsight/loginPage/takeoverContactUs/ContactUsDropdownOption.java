package com.company.lessons.qaFleetInsight.loginPage.takeoverContactUs;

import org.openqa.selenium.*;
import java.util.List;

public class ContactUsDropdownOption implements WebElement {

    private String dropdownOption;

    public ContactUsDropdownOption(){};

    public ContactUsDropdownOption(String dropdownOption) {
        this.dropdownOption = dropdownOption;
    };

    public String getSalutationOption(WebElement element) {
        return dropdownOption;
    }

    public void setDropdownOption(String dropdownOption) {
        this.dropdownOption = dropdownOption;
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
