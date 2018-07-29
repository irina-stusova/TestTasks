package com.penske.products.fleetinsight;

import com.penske.core.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.penske.core.framework.Browser.findElement;
import static com.penske.core.framework.Browser.getAttribute;

public class MyProfilePage {
    private static final String MY_PROFILE_PAGE_URL_IDENTIFIER = "https://qa.fleetinsight.com/fiportal/settings/profile";
    private static final String LABEL_USER_ID_XPATH = "//h2//div[@class='set-preferences__value set-preferences__username']";
    private static final String LABEL_COMPANY_NAME_XPATH = "//h2//div[@class='set-preferences__value']";
    //INPUT FIELDS
    private static final String INPUT_FIRST_NAME_BY_NAME = "firstName";
    private static final String INPUT_LAST_NAME_BY_NAME = "lastName";
    private static final String INPUT_PRIMARY_EMAIL_NAME = "email";
    private static final String INPUT_TELEPHONE_NAME = "phone";
    //LINKS
    private static final String LINK_MANAGE_NOTIFICATIONS_XPATH = "//form/fieldset/div[@class='notification-email']/a[@class='notification-email__cta']";
    private static final String LINK_VIEW_ADMINS_XPATH = "//form/fieldset/p/a[contains(text(), 'View Admin Contact Information')]";
    //BUTTONS
    private static final String BUTTON_RESET_PASSWORD_XPATH = "//a[@type='button']";
    private static final String BUTTON_SAVE_UPDATES_XPATH = "//button[@class='form-steps__button-primary']";


    //METHODS
    public String getUserId() {
        return findElement(userId()).getText();
    }

    public String getCompanyName() {
        return findElement(companyName()).getText();
    }

    public String getInputFirstName() {
        return getAttribute(inputFirstName(), "value");
    }

    public String getInputLastName() {
        return getAttribute(inputLastName(), "value");
    }

    public String getInputEmail() {
        return getAttribute(inputEmail(), "value");
    }

    public String getInputTelephone() {
        return getAttribute(inputTelephone(), "value");
    }


    public void setInputFirstName(String firstName) {
        Browser.sendQuery(inputFirstName(), firstName);
    }

    public void setInputLastName(String lastName) {
        Browser.sendQuery(inputLastName(), lastName);
    }

    public void setInputEmail(String email) {
        Browser.sendQuery(inputEmail(), email);
    }

    public void setInputTelephone(String telephone) {
        Browser.sendQuery(inputTelephone(), telephone);
    }

    public void click(String elementName) {
        By by;
        switch (elementName) {
            case "RESET PASSWORD":
                by = buttonResetPassword();
                break;
            case "SAVE UPDATES":
                by = buttonSaveUpdates();
                break;
            case "Manage Notifications":
                by = linkManageNotifications();
                break;
            case "View Admin Contact Information":
                by = linkViewAdmins();
                break;
            default:
                throw new RuntimeException(String.format("No such element name '%s'", elementName));
        }
        WebElement webElement = Browser.findElement(by);
        Browser.click(by, webElement);
    }


    private By userId() {
        return By.xpath(LABEL_USER_ID_XPATH);
    }

    private By companyName() {
        return By.xpath(LABEL_COMPANY_NAME_XPATH);
    }

    private By inputFirstName() {
        return By.name(INPUT_FIRST_NAME_BY_NAME);
    }

    private By inputLastName() {
        return By.name(INPUT_LAST_NAME_BY_NAME);
    }

    private By inputEmail() {
        return By.name(INPUT_PRIMARY_EMAIL_NAME);
    }

    private By inputTelephone() {
        return By.name(INPUT_TELEPHONE_NAME);
    }

    private By linkManageNotifications() {
        return By.xpath(LINK_MANAGE_NOTIFICATIONS_XPATH);
    }

    private By linkViewAdmins() {
        return By.xpath(LINK_VIEW_ADMINS_XPATH);
    }

    private By buttonResetPassword() {
        return By.xpath(BUTTON_RESET_PASSWORD_XPATH);
    }

    private By buttonSaveUpdates() {
        return By.xpath(BUTTON_SAVE_UPDATES_XPATH);
    }
}
