package com.company.lessons.browser;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.List;

public class Browser {
    private static WebDriver driver;

    public Browser(){
    }

    private static Browser inst = init();
    private static Browser init() {
        Browser chromeInstance = new Browser();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return chromeInstance;
    }

    public static Browser getInst() {
        return inst;
    }

    public static WebElement findElement(By by) {
        System.out.println(String.format("Searching for element %s", by));
        return driver.findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void sendQuery (By by, String query){
        findElement(by).sendKeys(query);
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void click(By by) {
        findElement(by).click();
    }

    public static String getTitle() {
        return driver.getTitle();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void quit() {
        driver.quit();
    }
}