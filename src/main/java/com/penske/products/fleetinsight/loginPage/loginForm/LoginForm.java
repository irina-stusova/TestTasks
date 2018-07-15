package com.penske.products.fleetinsight.loginPage.loginForm;

import org.openqa.selenium.By;

import static com.penske.core.framework.Browser.getInst;

public class LoginForm {
    public static final String INPUT_USERID_ID = "USER";
    public static final String INPUT_PASSWORD_ID = "PASSWORD";
    public static final String BUTTON_LOGIN_XPATH = "//*[@id='submitLogin']";

    public void setInputUserId(String userId) {
        getInst().sendQuery(inputUserId(), userId);
    }

    public void setInputPassword(String password) {
        getInst().sendQuery(inputPassword(), password);
    }
    public void setInputValue(String password) {
        getInst().sendQuery(inputPassword(), password);
    }

    public By inputUserId() {
        return By.id(INPUT_USERID_ID);
    }

    public By inputPassword() {
        return By.id(INPUT_PASSWORD_ID);
    }

    public By buttonLogIn() {
        return By.xpath(BUTTON_LOGIN_XPATH);
    }
}
