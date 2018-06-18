package com.company.lessons.browser;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static JavascriptExecutor executor;

    public Browser() {
    }

    private static Browser inst = init();

    private static Browser init() {
        Browser chromeInstance = new Browser();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        executor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(3000L, TimeUnit.MILLISECONDS);
        return chromeInstance;
    }

    public static Browser getInst() {
        return inst;
    }

    public static WebElement findElement(By by) {
        System.out.println(String.format("Searching for element %s", by));
        return driver.findElement(by);
    }

    public static Object executeJavaScript(String js) {
        return executor.executeScript(js);
    }

//    public static Object executeJavaScript(WebElement obj, String js) {
//        return executor.executeScript(js, obj);
//    }

    public static void focusOnElement(WebElement element) {
        int posY = element.getLocation().y - getScreenHeight() / 2;
        executeJavaScript(String.format("window.scrollTo({top: %s, behavior: \"instant\"})", posY));
    }

    public static int getScreenHeight() {
        return driver.manage().window().getSize().getHeight();
    }

    public static int getScreenWidth() {
        return driver.manage().window().getSize().getWidth();
    }

    public static List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void sendQuery(By by, String query) {
        findElement(by).sendKeys(query);
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void click(By by, WebElement webElement) {
        Browser.focusOnElement(webElement);
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