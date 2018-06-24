package com.company.lessons.qaFleetInsight.loginPage.takeoverContactUs;

import com.company.lessons.browser.Browser;
import org.openqa.selenium.By;

public class ContactUsTakeover {

    private static final String CONTACT_US_PAGE_URL_IDENTIFIER = "https://qa.fleetinsight.com/fiportal/public/contact-us";
    private static final String TITLE_TAKEOVER_XPATH = "//h1[@class='top-bar__head-text']";
    private static final String TITLE_FORM_XPATH = "//h2[@class='form-steps__page-title']";
    //PHONE NUMBERS
    private static final String CUSTOMER_SERVICE_PHONE_XPATH = "//p[@phone-number-key='CUSTOMER_SERVICE']/span";
    private static final String ROAD_ASSISTANCE_PHONE_XPATH = "//p[@phone-number-key='ROAD_ASSISTANCE']/span";
    //INPUT FIELDS
    private static final String INPUT_FIRST_NAME_BY_NAME = "firstName";
    private static final String INPUT_LAST_NAME_BY_NAME = "lastName";
    private static final String INPUT_EMAIL_NAME = "email";
    private static final String INPUT_ALTERNATIVE_EMAIL_NAME = "emailAlternate";
    private static final String INPUT_TELEPHONE_NAME = "phone";
    //PLACEHOLDERS
    private static final String PLACEHOLDER_SALUTATION_ID = "combobox__1";
    private static final String PLACEHOLDER_BEST_TIME_TO_REACH_ID = "combobox__2";
    private static final String PLACEHOLDER_REASON_FOR_CONTACT_ID = "combobox__3";
    private static final String PLACEHOLDER_FIRST_NAME_XPATH = "//input[@name='firstName'][@placeholder]";
    private static final String PLACEHOLDER_LAST_NAME_XPATH = "//input[@name='lastName'][@placeholder]";
    private static final String PLACEHOLDER_EMAIL_XPATH = "//input[@name='email'][@placeholder]";
    private static final String PLACEHOLDER_ALTERNATIVE_EMAIL_XPATH = "//input[@name='emailAlternate'][@placeholder]";
    private static final String PLACEHOLDER_TELEPHONE_XPATH = "//input[@name='phone'][@placeholder]";
    //DROP DOWNS
    private static final String DROPDOWN_OPTION_SALUTATION_XPATH = "//dropdown-list//ul[@aria-labelledby='combobox__1']/li"; /*/li[*]*/
    private static final String DROPDOWN_OPTION_BEST_TIME_TO_REACH_XPATH = "//dropdown-list//ul[@aria-labelledby='combobox__2']/li"; /*/li[*]*/
    private static final String DROPDOWN_OPTION_REASON_FOR_CONTACT_XPATH = "//dropdown-list//ul[@aria-labelledby='combobox__3']/li"; /*/li[*]*/
    //RADIO BUTTONS
    private static final String RADIO_BUTTON_PHONE_TYPE_NAME = "typePhone";
    private static final String RADIO_BUTTON_EMAIL_TYPE_NAME = "typeMail";
    //BUTTONS
    private static final String BUTTON_CLOSE_XPATH = "//button[@type='button']/span[@svg-title='close']";
    private static final String BUTTON_BACK_XPATH = "//li[@class='form-steps__footer-link']/button[contains(text(), 'Back')]";
    private static final String BUTTON_CONTINUE_XPATH = "//li[@class='form-steps__footer-link']/button[contains(text(), 'Continue')]";

    //GETTERs
    public String getContactUsPageUrlIdentifier() {
        return CONTACT_US_PAGE_URL_IDENTIFIER;
    }

    public String getTakeoverTitle() {
        return Browser.findElement(takeoverTitle()).getText();
    }

    public String getFormTitle() {
        return Browser.findElement(formTitle()).getText();
    }

    public String getCustomerServicePhone() {
        return Browser.findElement(customerServicePhone()).getText();
    }

    public String getRoadAssistancePhone() {
        return Browser.findElement(roadAssistancePhone()).getText();
    }

    public String getInputFirstName() {
        return Browser.getInst().getText(inputFirstName());
    }

    public String getInputLastName() {
        return Browser.getInst().getText(inputLastName());
    }

    public String getInputEmail() {
        return Browser.getInst().getText(inputEmail());
    }

    public String getInputAlternativeEmail() {
        return Browser.getInst().getText(inputEmailAlternative());
    }

    public String getInputTelephone() {
        return Browser.getInst().getText(inputTelephone());
    }

    public String getPlaceholderSalutation() {
        return Browser.findElement(placeholderSalutation()).getAttribute("value");
    }

    public String getPlaceholderBestTimeToReach() {
        return Browser.findElement(placeholderBestTimeToReach()).getAttribute("value");
    }

    public String getPlaceholderReasonForContact() {
        return Browser.findElement(placeholderReasonForContact()).getAttribute("value");
    }

    public String getPlaceholderFirstName() {
        return Browser.findElement(placeholderFirstName()).getAttribute("placeholder");
    }

    public String getPlaceholderLastName() {
        return Browser.findElement(placeholderLastName()).getAttribute("placeholder");
    }

    public String getPlaceholderEmail() {
        return Browser.findElement(placeholderEmail()).getAttribute("placeholder");
    }

    public String getPlaceholderAlternativeEmail() {
        return Browser.findElement(placeholderEmailAlternative()).getAttribute("placeholder");
    }

    public String getPlaceholderTelephone() {
        return Browser.findElement(placeholderTelephone()).getAttribute("placeholder");
    }

    public String getDropdownOptionSalutation() {
        return Browser.getInst().getText(dropdownOptionSalutation());
    }

    public String getDropdownOptionBestTimeToReach() {
        return Browser.getInst().getText(dropdownOptionBestTimeToReach());
    }

    public String getDropdownOptionReasonForContact() {
        return Browser.getInst().getText(dropdownOptionReasonForContact());
    }

    //SETTERs
    public void setInputFirstName(String firstName) {
        Browser.getInst().sendQuery(inputFirstName(), firstName);
    }

    public void setInputLastName(String lastName) {
        Browser.getInst().sendQuery(inputLastName(), lastName);
    }

    public void setInputEmail(String email) {
        Browser.getInst().sendQuery(inputEmail(), email);
    }

    public void setInputAlternativeEmail(String emailAlternative) {
        Browser.getInst().sendQuery(inputEmailAlternative(), emailAlternative);
    }

    public void setInputTelephone(String telephone) {
        Browser.getInst().sendQuery(inputTelephone(), telephone);
    }

    //???
    public void setSalutation(String salutation) {
        Browser.getInst().sendQuery(dropdownOptionSalutation(), salutation);
    }

    public void setBestTimeToReach(String timeToReach) {
        Browser.getInst().sendQuery(dropdownOptionBestTimeToReach(), timeToReach);
    }

    public void setReasonForContact(String reason) {
        Browser.getInst().sendQuery(dropdownOptionReasonForContact(), reason);
    }

    //BY
    public By takeoverTitle() {
        return By.xpath(TITLE_TAKEOVER_XPATH);
    }

    public By formTitle() {
        return By.xpath(TITLE_FORM_XPATH);
    }

    public By customerServicePhone() {
        return By.xpath(CUSTOMER_SERVICE_PHONE_XPATH);
    }

    public By roadAssistancePhone() {
        return By.xpath(ROAD_ASSISTANCE_PHONE_XPATH);
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

    public By placeholderSalutation() {
        return By.id(PLACEHOLDER_SALUTATION_ID);
    }

    public By placeholderBestTimeToReach() {
        return By.id(PLACEHOLDER_BEST_TIME_TO_REACH_ID);
    }

    public By placeholderReasonForContact() {
        return By.id(PLACEHOLDER_REASON_FOR_CONTACT_ID);
    }

    public By placeholderFirstName() {
        return By.xpath(PLACEHOLDER_FIRST_NAME_XPATH);
    }

    public By placeholderLastName() {
        return By.xpath(PLACEHOLDER_LAST_NAME_XPATH);
    }

    public By placeholderEmail() {
        return By.xpath(PLACEHOLDER_EMAIL_XPATH);
    }

    public By placeholderEmailAlternative() {
        return By.xpath(PLACEHOLDER_ALTERNATIVE_EMAIL_XPATH);
    }

    public By placeholderTelephone() {
        return By.xpath(PLACEHOLDER_TELEPHONE_XPATH);
    }

    public By dropdownOptionSalutation() {
        return By.xpath(DROPDOWN_OPTION_SALUTATION_XPATH);
    }

    public By dropdownOptionBestTimeToReach() {
        return By.xpath(DROPDOWN_OPTION_BEST_TIME_TO_REACH_XPATH);
    }

    public By dropdownOptionReasonForContact() {
        return By.xpath(DROPDOWN_OPTION_REASON_FOR_CONTACT_XPATH);
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
