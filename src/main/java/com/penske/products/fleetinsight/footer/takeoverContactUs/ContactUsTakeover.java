package com.penske.products.fleetinsight.footer.takeoverContactUs;

import com.penske.core.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.penske.core.framework.Browser.*;

public class ContactUsTakeover {

    private static final String CONTACT_US_PAGE_URL_IDENTIFIER = "https://qa.fleetinsight.com/fiportal/public/contact-us";
    private static final String TITLE_TAKEOVER_XPATH = "//h1[@class='top-bar__head-text']";
    private static final String TITLE_FORM_XPATH = "//h2[@class='form-steps__page-title']";
    //PHONE NUMBERS
    private static final String SERVICE_PHONE_XPATH = "//p[@phone-number-key='%s']/span";
    private static final String CUSTOMER_SERVICE_PHONE_KEY = "CUSTOMER_SERVICE";
    private static final String ROAD_ASSISTANCE_PHONE_KEY = "ROAD_ASSISTANCE";
    //INPUT FIELDS
    private static final String INPUT_FIRST_NAME_BY_NAME = "firstName";
    private static final String INPUT_LAST_NAME_BY_NAME = "lastName";
    private static final String INPUT_EMAIL_NAME = "email";
    private static final String INPUT_ALTERNATIVE_EMAIL_NAME = "emailAlternate";
    private static final String INPUT_TELEPHONE_NAME = "phone";
    //PLACEHOLDERS
    private static final String DROPDOWN_SALUTATION_ID = "combobox__1";
    private static final String DROPDOWN_BEST_TIME_TO_REACH_ID = "combobox__2";
    private static final String DROPDOWN_REASON_FOR_CONTACT_ID = "combobox__3";
    private static final String PLACEHOLDER_DROPDOWN_XPATH = "//input[@type='button'][@id='%s']";
    private static final String PLACEHOLDER_INPUT_FIELD_XPATH = "//input[@name='%s'][@placeholder]";
    //DROPDOWNS CONTROLS
    private static final String DROPDOWN_CONTROL_XPATH = "//div[@class='custom-select__dropdown']/span/input[@id='%s']";
    //RADIO BUTTONS
    private static final String RADIO_BUTTON_XPATH = "//input[@type='radio'][@name='%s']";
    private static final String RADIO_BUTTON_PHONE_TYPE_NAME = "typePhone";
    private static final String RADIO_BUTTON_EMAIL_TYPE_NAME = "typeMail";
    //BUTTONS
    private static final String BUTTON_CLOSE_XPATH = "//button[@type='button']/span[@svg-title='close']";
    private static final String BUTTONS_FOOTER_XPATH = "//li[@class='form-steps__footer-link']/button[contains(text(), '%s')]";

    //METHODS
    public String getContactUsPageUrlIdentifier() {
        return CONTACT_US_PAGE_URL_IDENTIFIER;
    }

    public String getTakeoverTitle() {
        return findElement(takeoverTitle()).getText();
    }

    public String getFormTitle() {
        return findElement(formTitle()).getText();
    }

    public String getInputFirstName() {
        return getText(inputFirstName());
    }

    public String getInputLastName() {
        return getText(inputLastName());
    }

    public String getInputEmail() {
        return getText(inputEmail());
    }

    public String getInputAlternativeEmail() {
        return getText(inputEmailAlternative());
    }

    public String getInputTelephone() {
        return getText(inputTelephone());
    }

    public String getServicePhone(String serviceName) {
        String phoneNumber = findElement(servicePhone(serviceName)).getText();
        Pattern pattern = Pattern.compile("(\\(\\d{3}\\)\\s\\d{3}-\\d{4})");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.find()) {
            phoneNumber = matcher.group();
        }
        return phoneNumber;
    }


    public String getDropdownPlaceholder(String dropdownName) {
        String dropdownId = "";
        switch (dropdownName) {
            case "SALUTATION":
                dropdownId = DROPDOWN_SALUTATION_ID;
                break;
            case "Best Time To Reach you?":
                dropdownId = DROPDOWN_BEST_TIME_TO_REACH_ID;
                break;
            case "Reason for contact?":
                dropdownId = DROPDOWN_REASON_FOR_CONTACT_ID;
                break;
            default:
                throw new RuntimeException(String.format("No such dropdown name %s", dropdownName));
        }
        By by = placeholderDropdown(dropdownId);
        Browser.waitElementHasAttr(by,"value");
        WebElement element = findElement(by);
        String value = element.getAttribute("value");
        return value;
    }


    public String getInputFieldPlaceholder(String inputFieldName) {
        String placeholderName = "";
        switch (inputFieldName) {
            case "FIRST NAME":
                placeholderName = INPUT_FIRST_NAME_BY_NAME;
                break;
            case "LAST NAME":
                placeholderName = INPUT_LAST_NAME_BY_NAME;
                break;
            case "EMAIL":
                placeholderName = INPUT_EMAIL_NAME;
                break;
            case "ALTERNATIVE EMAIL":
                placeholderName = INPUT_ALTERNATIVE_EMAIL_NAME;
                break;
            case "TELEPHONE":
                placeholderName = INPUT_TELEPHONE_NAME;
                break;
            default:
                throw new RuntimeException(String.format("No such input field name %s", inputFieldName));
        }
        return findElement(placeholderInputField(placeholderName)).getAttribute("placeholder");
    }


    public void clickDropdownControl(String dropdownName) {
        By dropdownControl;
        switch (dropdownName) {
            case "SALUTATION":
                dropdownControl = dropdownControl(DROPDOWN_SALUTATION_ID);
                break;
            case "Best Time To Reach you?":
                dropdownControl = dropdownControl(DROPDOWN_BEST_TIME_TO_REACH_ID);
                break;
            case "Reason for contact?":
                dropdownControl = dropdownControl(DROPDOWN_REASON_FOR_CONTACT_ID);
                break;
            default:
                throw new RuntimeException(String.format("No such dropdown name %s", dropdownName));
        }
        WebElement webElement = Browser.findElement(dropdownControl);
        Browser.click(dropdownControl, webElement);
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

    public void setInputAlternativeEmail(String emailAlternative) {
        Browser.sendQuery(inputEmailAlternative(), emailAlternative);
    }

    public void setInputTelephone(String telephone) {
        Browser.sendQuery(inputTelephone(), telephone);
    }


    public WebElement getRadioButton(String radioButtonName) {
        String radioButtonType = "";
        switch (radioButtonName) {
            case "Phone":
                radioButtonType = RADIO_BUTTON_PHONE_TYPE_NAME;
                break;
            case "Email":
                radioButtonType = RADIO_BUTTON_EMAIL_TYPE_NAME;
                break;
            default:
                throw new RuntimeException(String.format("No such radio button name %s", radioButtonName));
        }
        return Browser.findElement(radioButton(radioButtonType));
    }


    public void clickButton(String buttonName) {
        WebElement webElement = Browser.findElement(buttonInFooter(buttonName));
        Browser.click(buttonInFooter(buttonName), webElement);
    }

    //BY
    private By takeoverTitle() {
        return By.xpath(TITLE_TAKEOVER_XPATH);
    }

    private By formTitle() {
        return By.xpath(TITLE_FORM_XPATH);
    }

    private By servicePhone(String serviceName) {
        return By.xpath(String.format(SERVICE_PHONE_XPATH, serviceName));
    }

    private By customerServicePhone() {
        return By.xpath(CUSTOMER_SERVICE_PHONE_KEY);
    }

    private By roadAssistancePhone() {
        return By.xpath(ROAD_ASSISTANCE_PHONE_KEY);
    }

    private By inputFirstName() {
        return By.name(INPUT_FIRST_NAME_BY_NAME);
    }

    private By inputLastName() {
        return By.name(INPUT_LAST_NAME_BY_NAME);
    }

    private By inputEmail() {
        return By.name(INPUT_EMAIL_NAME);
    }

    private By inputEmailAlternative() {
        return By.name(INPUT_ALTERNATIVE_EMAIL_NAME);
    }

    private By inputTelephone() {
        return By.name(INPUT_TELEPHONE_NAME);
    }

    private By placeholderDropdown(String dropdownId) {
        return By.xpath(String.format(PLACEHOLDER_DROPDOWN_XPATH, dropdownId));
    }

    private By placeholderInputField(String placeholderName) {
        return By.xpath(String.format(PLACEHOLDER_INPUT_FIELD_XPATH, placeholderName));
    }

    private By dropdownControl(String dropdownId) {
        return By.xpath(String.format(DROPDOWN_CONTROL_XPATH, dropdownId));
    }

    private By radioButton(String radioButtonType) {
        return By.xpath(String.format(RADIO_BUTTON_XPATH, radioButtonType));
    }

    private By radioButtonEmail() {
        return By.name(RADIO_BUTTON_EMAIL_TYPE_NAME);
    }

    private By buttonClose() {
        return By.xpath(BUTTON_CLOSE_XPATH);
    }

    private By buttonInFooter(String buttonName) {
        return By.xpath(String.format(BUTTONS_FOOTER_XPATH, buttonName));
    }
}
