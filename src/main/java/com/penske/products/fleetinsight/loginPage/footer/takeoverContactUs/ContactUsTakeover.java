package com.penske.products.fleetinsight.loginPage.footer.takeoverContactUs;

import org.openqa.selenium.By;

import static com.penske.core.framework.Browser.*;
import static com.penske.core.framework.Browser.getInst;

public class ContactUsTakeover {

    private static final String CONTACT_US_PAGE_URL_IDENTIFIER = "https://qa.fleetinsight.com/fiportal/public/contact-us";
    private static final String TITLE_TAKEOVER_XPATH = "//h1[@class='top-bar__head-text']";
    private static final String TITLE_FORM_XPATH = "//h2[@class='form-steps__page-title']";
    //PHONE NUMBERS
    public static final String SERVICE_PHONE_XPATH = "//p[@phone-number-key='%s']/span";
    public static final String CUSTOMER_SERVICE_PHONE_KEY = "CUSTOMER_SERVICE";
    public static final String ROAD_ASSISTANCE_PHONE_KEY = "ROAD_ASSISTANCE";
    //INPUT FIELDS
    public static final String INPUT_FIRST_NAME_BY_NAME = "firstName";
    public static final String INPUT_LAST_NAME_BY_NAME = "lastName";
    public static final String INPUT_EMAIL_NAME = "email";
    public static final String INPUT_ALTERNATIVE_EMAIL_NAME = "emailAlternate";
    public static final String INPUT_TELEPHONE_NAME = "phone";
    //PLACEHOLDERS
    public static final String DROPDOWN_SALUTATION_ID = "combobox__1";
    public static final String DROPDOWN_BEST_TIME_TO_REACH_ID = "combobox__2";
    public static final String DROPDOWN_REASON_FOR_CONTACT_ID = "combobox__3";
    private static final String PLACEHOLDER_INPUT_FIELD_XPATH = "//input[@name='%s'][@placeholder]";
    //DROPDOWNS CONTROLS
    private static final String DROPDOWN_CONTROL_XPATH = "//div[@class='custom-select__dropdown']/span/input[@id='%s']";
    //RADIO BUTTONS
    public static final String RADIO_BUTTON_NAME = "//input[@type='radio'][@name='%s']";
    public static final String RADIO_BUTTON_PHONE_TYPE_NAME = "typePhone";
    public static final String RADIO_BUTTON_EMAIL_TYPE_NAME = "typeMail";
    //BUTTONS
    public static final String BUTTON_CLOSE_XPATH = "//button[@type='button']/span[@svg-title='close']";
    public static final String BUTTON_BACK_XPATH = "//li[@class='form-steps__footer-link']/button[contains(text(), 'Back')]";
    public static final String BUTTON_CONTINUE_XPATH = "//li[@class='form-steps__footer-link']/button[contains(text(), 'Continue')]";

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

    public String getServicePhone(String phoneName) {
        return findElement(servicePhone(phoneName)).getText();
    }

    public String getCustomerServicePhone() {
        return findElement(customerServicePhone()).getText();
    }

    public String getRoadAssistancePhone() {
        return findElement(roadAssistancePhone()).getText();
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

    public String getDropdownPlaceholder(String dropdownId) {
        return findElement(placeholderDropdown(dropdownId)).getAttribute("value");
    }

    public String getInputFieldPlaceholder(String placeholderName) {
        return findElement(placeholderInputField(placeholderName)).getAttribute("placeholder");
    }

    public void setInputFirstName(String firstName) {
        getInst().sendQuery(inputFirstName(), firstName);
    }

    public void setInputLastName(String lastName) {
        getInst().sendQuery(inputLastName(), lastName);
    }

    public void setInputEmail(String email) {
        getInst().sendQuery(inputEmail(), email);
    }

    public void setInputAlternativeEmail(String emailAlternative) {
        getInst().sendQuery(inputEmailAlternative(), emailAlternative);
    }

    public void setInputTelephone(String telephone) {
        getInst().sendQuery(inputTelephone(), telephone);
    }

    //BY
    public By takeoverTitle() {
        return By.xpath(TITLE_TAKEOVER_XPATH);
    }

    public By formTitle() {
        return By.xpath(TITLE_FORM_XPATH);
    }

    public By servicePhone(String phoneName) {
        return By.xpath(String.format(SERVICE_PHONE_XPATH, phoneName));
    }

    public By customerServicePhone() {
        return By.xpath(CUSTOMER_SERVICE_PHONE_KEY);
    }

    public By roadAssistancePhone() {
        return By.xpath(ROAD_ASSISTANCE_PHONE_KEY);
    }

    public By inputFirstName() {
        return By.name(INPUT_FIRST_NAME_BY_NAME);
    }

    public By inputLastName() {
        return By.name(INPUT_LAST_NAME_BY_NAME);
    }

    public By inputEmail() {
        return By.name(INPUT_EMAIL_NAME);
    }

    public By inputEmailAlternative() {
        return By.name(INPUT_ALTERNATIVE_EMAIL_NAME);
    }

    public By inputTelephone() {
        return By.name(INPUT_TELEPHONE_NAME);
    }

    public By placeholderDropdown(String dropdownId) {
        return By.xpath(String.format(DROPDOWN_CONTROL_XPATH, dropdownId));
    }

    public By placeholderInputField(String placeholderName) {
        return By.xpath(String.format(PLACEHOLDER_INPUT_FIELD_XPATH, placeholderName));
    }

    public By dropdownControl(String dropdownId) {
        return By.xpath(String.format(DROPDOWN_CONTROL_XPATH, dropdownId));
    }

    public By radioButtonPhone() {
        return By.name(RADIO_BUTTON_PHONE_TYPE_NAME);
    }

    public By radioButtonEmail() {
        return By.name(RADIO_BUTTON_EMAIL_TYPE_NAME);
    }

    public By buttonClose() {
        return By.xpath(BUTTON_CLOSE_XPATH);
    }

    public By buttonBack() {
        return By.xpath(BUTTON_BACK_XPATH);
    }

    public By buttonContinue() {
        return By.xpath(BUTTON_CONTINUE_XPATH);
    }
}
