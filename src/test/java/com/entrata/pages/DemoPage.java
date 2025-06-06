package com.entrata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemoPage extends BasePage {

    public DemoPage(WebDriver driver) {
        super(driver); // calls BasePage constructor
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='ProspectPortal']")
    private WebElement firstDemoItem;

    @FindBy(xpath = "//div[@class='button-group']//div[@class='button_text'][normalize-space()='Book a demo']")
    private WebElement bookADemoButton;

    @FindBy(css = "#FirstName")
    private WebElement firstNameInput;

    @FindBy(css = "#LastName")
    private WebElement lastNameInput;

    @FindBy(css = "#Email")
    private WebElement emailInput;

    @FindBy(css = "#Company")
    private WebElement companyNameInput;

    @FindBy(css = "#Phone")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//select[@id='Unit_Count__c']")
    private WebElement totalManagedUnitsInput; // This is a <select> element

    @FindBy(xpath  = "//input[@id='Title']")
    private WebElement jobTitleInput;

    @FindBy(xpath  = "//select[@id='demoRequest']")
    private WebElement iamDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;  // This is a <select> element

    public void firstDemoClick() {
        firstDemoItem.click();
    }

    public void bookDemoClick(){
        bookADemoButton.click();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterCompanyName(String company) {
        companyNameInput.clear();
        companyNameInput.sendKeys(company);
    }

    public void enterPhoneNumber(String phone) {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
    }

    public void enterTotalManagedUnits() {
        Select dropdown = new Select(totalManagedUnitsInput);
        dropdown.selectByIndex(0); // Select first option
    }

    public void enterJobTitle(String jobTitle) {
        jobTitleInput.clear();
        jobTitleInput.sendKeys(jobTitle);
    }

    public void selectIamOption() {
        Select dropdown = new Select(iamDropdown);
        dropdown.selectByIndex(0); // Select first option
    }


    public WebElement getSubmitButton() {
    return submitButton;
}
}