package com.company.lessons.lesson14;

import org.openqa.selenium.*;

import java.util.List;

public class SearchResultsItem implements WebElement {
    private String header;
    private String url;
    private String content;

    public String getHeader(WebElement element) {
        return header;
    }

    public String getUrl(WebElement element) {
        return url;
    }

    public String getContent(WebElement element) {
        return content;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SearchResultsItem() {
    }

    public SearchResultsItem(String header, String url, String content) {
        this.header = header;
        this.url = url;
        this.content = content;
    }

    @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... charSequences) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
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
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
