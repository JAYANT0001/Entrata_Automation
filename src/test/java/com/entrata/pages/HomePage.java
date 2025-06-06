package com.entrata.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver); // call to BasePage's constructor
    }

    @FindBy(xpath = "//div[contains(text(),'Products')]")
    private WebElement productsHeader;

    @FindBy(xpath = "//div[@id='w-dropdown-toggle-1']//div[contains(text(),'Solutions')]")
    private WebElement solutionsHeader;

    @FindBy(xpath = "//div[contains(text(),'Resources')]")
    private WebElement resourcesHeader;

    @FindBy(xpath = "//a[@class='nav_link w-nav-link']")
    private WebElement companyNewsHeader;

    @FindBy(xpath = "//div[@class='dropdown_tabs-menu w-tab-menu']/a")
    private List<WebElement> productsDropdownItems;

    @FindBy(xpath = "//div[@class='nav_dropdown-columns is-solutions']//div[@class='dropdown_link-heading']")
    private List<WebElement> solutionsDropdownItems;

    @FindBy(xpath = "//div[@class='nav_dropdown-columns']//div[@class='dropdown_link-content']/div")
    private List<WebElement> resourcesDropdownItems;

    @FindBy(xpath = "//div[@class='footer_column-heading']")
    private List<WebElement> footerSectionHeaders;

    @FindBy(xpath = "//div[@class='footer_column']//a")
    private List<WebElement> allFooterLinks;


    public WebElement getProductsHeader() {
        return productsHeader;
    }

    public boolean isProductsHeaderVisible() {
        try {
            return productsHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void open() {
        driver.get("https://www.entrata.com/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isSolutionsHeaderVisible() {
        return solutionsHeader.isDisplayed();
    }

    public boolean isResourcesHeaderVisible() {
        return resourcesHeader.isDisplayed();
    }

    public boolean isCompanyNewsHeaderVisible() {
        return companyNewsHeader.isDisplayed();
    }

    public void hoverProducts() {
        new Actions(driver).moveToElement(productsHeader).perform();
    }

    public void hoverSolutions() {
        new Actions(driver).moveToElement(solutionsHeader).perform();
    }

    public void hoverResources() {
        new Actions(driver).moveToElement(resourcesHeader).perform();
    }

    public void clickCompanyNews() {
        companyNewsHeader.click();
    }

    public List<WebElement> getProductsDropdownItems() {
        return productsDropdownItems;
    }

    public List<WebElement> getSolutionsDropdownItems() {
        return solutionsDropdownItems;
    }

    public List<WebElement> getResourcesDropdownItems() {
        return resourcesDropdownItems;
    }

    
     public List<WebElement> getFooterSectionHeaders() {
        return footerSectionHeaders;
    }

    public List<WebElement> getAllFooterLinks() {
        return allFooterLinks;
    }

}