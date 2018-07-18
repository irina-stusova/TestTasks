package com.penske.products.fleetinsight.loginPage.loginForm;

import com.penske.core.framework.Browser;
import com.penske.products.fleetinsight.loginPage.footer.LoginPageFooter;
import org.openqa.selenium.By;


public class LoginForm {
    public static final String INPUT_USERID_ID = "USER";
    public static final String INPUT_PASSWORD_ID = "PASSWORD";
    public static final String BUTTON_LOGIN_XPATH = "//*[@id='submitLogin']";

    private LoginPageFooter footer = new LoginPageFooter();
    public LoginPageFooter getFooter(){
        return footer;
    }
    public void setInputUserId(String userId) {
        Browser.sendQuery(inputUserId(), userId);
    }

    public void setInputPassword(String password) {
        Browser.sendQuery(inputPassword(), password);
    }
    public void setInputValue(String password) {
        Browser.sendQuery(inputPassword(), password);
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
