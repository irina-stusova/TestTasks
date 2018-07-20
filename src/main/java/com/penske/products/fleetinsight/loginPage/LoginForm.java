package com.penske.products.fleetinsight.loginPage;

import com.penske.core.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginForm {
    private static final String INPUT_USERID_ID = "USER";
    private static final String INPUT_PASSWORD_ID = "PASSWORD";
    private static final String BUTTON_LOGIN_XPATH = "//*[@id='submitLogin']";

    public static String getInputUseridId() {
        return INPUT_USERID_ID;
    }

    public static String getInputPasswordId() {
        return INPUT_PASSWORD_ID;
    }

    public static String getButtonLoginXpath() {
        return BUTTON_LOGIN_XPATH;
    }

    private void setInputUserId(String userId) {
        Browser.sendQuery(inputUserId(), userId);
    }

    private void setInputPassword(String password) {
        Browser.sendQuery(inputPassword(), password);
    }

    public void login(String userId, String password) {
        setInputUserId(userId);
        setInputPassword(password);
        WebElement webElement = Browser.findElement(buttonLogIn());
        Browser.focusOnElement(webElement);
        webElement.click();
    }

    private By inputUserId() {
        return By.id(INPUT_USERID_ID);
    }

    private By inputPassword() {
        return By.id(INPUT_PASSWORD_ID);
    }

    private By buttonLogIn() {
        return By.xpath(BUTTON_LOGIN_XPATH);
    }
}
