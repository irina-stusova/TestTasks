package com.penske.core.framework;

import com.penske.core.framework.config.BrowserConfig;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static final String INTERNET_EXPLORER = "internet explorer";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    private static ThreadLocal<WebDriver> driverA = new ThreadLocal<>();
    private static ThreadLocal<NgWebDriver> ngWebDriver = new ThreadLocal<>();
    private static WebDriver driver;
    private static String browserName;
    private static WebDriverWait wait;
    private static JavascriptExecutor executor;

    public Browser() {
    }

    private static Browser inst = init();

    public static WebDriver getDriver() {
        if (driverA.get() == null) {
            browserName = BrowserConfig.getInstance().BROWSER_NAME();
            init();
        }
        return driverA.get();
    }

    public static NgWebDriver getNG() {
        return ngWebDriver.get();
    }

    private static Browser init() {
        Browser chromeInstance = new Browser();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        executor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(15000L, TimeUnit.MILLISECONDS);
        return chromeInstance;
    }

    public static Browser getInst() {
        return inst;
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
        return driver.manage().window().getSize().getHeight();
    }

    public static int getScreenWidth() {
        return driver.manage().window().getSize().getWidth();
    }

    public static WebElement findElement(By by) {
        System.out.println(String.format("Searching for element %s", by));
        return driver.findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        return driver.findElements(by);
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

    public void getUrl(String url) {
        driver.get(url);
    }

    public void click(By by, WebElement webElement) {
        Browser.focusOnElement(webElement);
        findElement(by).click();
    }

    public static void close() {
        if (driverA.get() != null) {
            com.penske.core.framework.Log.info("The driver is closing...");
            try {
                getDriver().close();
                getDriver().quit();
            } catch (Exception e) {
                com.penske.core.framework.Log.warn(e.getMessage());
            } finally {
                driverA.remove();
                ngWebDriver.remove();
                browserName = null;
                com.penske.core.framework.Log.info("The driver has been closed.");
            }
        }
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