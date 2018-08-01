package com.penske.core.framework;

import com.penske.core.framework.config.BrowserConfig;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static final String INTERNET_EXPLORER = "internet explorer";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<NgWebDriver> ngWebDriver = new ThreadLocal<>();
    private static String browserName;
    private static WebDriverWait wait;
    private static JavascriptExecutor executor;

    public Browser() {
    }

//    private static Browser inst = init();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            browserName = BrowserConfig.getInstance().BROWSER_NAME();
            init();
        }
        return driver.get();
    }

    public static NgWebDriver getNG() {
        return ngWebDriver.get();
    }

    private static Browser init() {
        Browser chromeInstance = new Browser();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src\\main\\resources\\drivers\\chromedriver.exe");
        driver.set(new ChromeDriver());
        wait = new WebDriverWait(getDriver(), 50);
        executor = (JavascriptExecutor) getDriver();
        getDriver().manage().timeouts().implicitlyWait(5000L, TimeUnit.MILLISECONDS);
        return chromeInstance;
    }

    public static void waitUntilElementClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitUntilElementPresent(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitUntilElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitElementDisplayed(By by) {
        waitUntilElementPresent(by);
        wait.until(webDriver -> {
            try {
                if (webDriver.findElement(by).isDisplayed()) {
                    return true;
                } else {
                    return false;
                }
            } catch (NoSuchElementException e) {
                return false;
            }
        });
    }

    public static void waitElementHasAttr(By by,String attrName) {
        waitElementDisplayed(by);
        wait.until(webDriver -> {
            try {
                if (!webDriver.findElement(by).getAttribute(attrName).isEmpty()) {
                    return true;
                } else {
                    return false;
                }
            } catch (NoSuchElementException e) {
                return false;
            }
        });
    }


    public static Object executeJavaScript(String js) {
        return executor.executeScript(js);
    }

    public static Object executeJavaScript(WebElement obj, String js) {
        return executor.executeScript(js, obj);
    }

    public static void focusOnElement(WebElement element) {
        int posY = element.getLocation().y - getScreenHeight() / 2;
        executeJavaScript(String.format("window.scrollTo({top: %s, behavior: \"instant\"})", posY));
    }

    public static int getScreenHeight() {
        return getDriver().manage().window().getSize().getHeight();
    }

    public static int getScreenWidth() {
        return getDriver().manage().window().getSize().getWidth();
    }

    public static WebElement findElement(By by) {
        System.out.println(String.format("Searching for element %s", by));
        waitUntilElementClickable(by);
        return getDriver().findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public static String getText(By by) {
        WebElement element = findElement(by);
        return getText(element);
    }

    public static String getText(WebElement element) {
        String text = getAttribute(element, "innerHTML");
        if (text.equals("")) {
            text = element.getText();
        }
        return text;
    }

    public static String getAttribute(By by, String attributeName) {
        WebElement element = findElement(by);
        return getAttribute(element, attributeName);
    }

    public static String getAttribute(WebElement element, String attributeName) {
        String result = "";
        Log.info(String.format("Getting a value of attribute '%s' of the element: %s.", attributeName, element.toString()));
        try {
            result = element.getAttribute(attributeName).trim();
            Log.info(String.format("Got the attribute text '%s' of the WebElement: %s.", result, element.toString()));
        } catch (Exception e) {
            Log.error(String.format("There is unexpected getting error text attribute of element - %s.", e.toString()));
        }
        return result;
    }

    public static String getValue(By by) {
        return getAttribute(by, "value");
    }

    public static String getValue(WebElement element) {
        return getAttribute(element, "value");
    }

    public static String getClass(By by) {
        return getAttribute(by, "class");
    }

    public static String getClass(WebElement element) {
        return getAttribute(element, "class");
    }

    public static String getInnerText(By by) {
        return getAttribute(by, "innerText");
    }

    public static String getInnerText(WebElement element) {
        return getAttribute(element, "innerText");
    }

    public static void sendQuery(By by, String query) {
        findElement(by).sendKeys(query);
    }

    public static void sendKeys(By by, String query) {
        findElement(by).sendKeys(query);
    }

    public static void getUrl(String url) {
        getDriver().get(url);
    }

    public static void click(By by, WebElement webElement) {
        Browser.focusOnElement(webElement);
        findElement(by).click();
    }

    public static void switchToTab(int tabNumber) {
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabNumber));
    }

    public static void close() {
        getDriver().close();
        getDriver().quit();
        System.out.println("The driver has been closed.");
    }

    public static String getTitle() {
        return getDriver().getTitle();
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public void quit() {
        getDriver().quit();
    }
}