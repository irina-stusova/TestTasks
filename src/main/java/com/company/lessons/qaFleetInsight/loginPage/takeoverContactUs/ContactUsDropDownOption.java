package com.company.lessons.qaFleetInsight.loginPage.takeoverContactUs;

import org.openqa.selenium.*;

import java.util.List;

public class ContactUsDropDownOption implements WebElement {
    private String salutationOption;
    private String bestTimeToReachOption;
    private String reasonForContactOption;

    public ContactUsDropDownOption(){};

    public String getSalutationOption(WebElement element) {
        return salutationOption;
    }

    public String getBestTimeToReachOption(WebElement element) {
        return bestTimeToReachOption;
    }

    public String getReasonForContactOption(WebElement element) {
        return reasonForContactOption;
    }

    public void setSalutationOption(String salutationOption) {
        this.salutationOption = salutationOption;
    }

    public void setBestTimeToReachOption(String bestTimeToReachOption) {
        this.bestTimeToReachOption = bestTimeToReachOption;
    }

    public void setReasonForContactOption(String reasonForContactOption) {
        this.reasonForContactOption = reasonForContactOption;
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
