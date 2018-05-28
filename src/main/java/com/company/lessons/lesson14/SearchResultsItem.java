package com.company.lessons.lesson14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultsItem {
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

    private By linkHeader() {
        return By.xpath(header);
    }
    private By linkUrl() {
        return By.xpath(url);
    }
    private By textContent() {
        return By.xpath(content);
    }
}
