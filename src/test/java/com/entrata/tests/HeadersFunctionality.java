package com.entrata.tests;

import com.entrata.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HeadersFunctionality extends BaseTest {

    private static final Logger logger = LogManager.getLogger(HeadersFunctionality.class);

    @Test(priority = 2)
    public void verifyHeadersAndDropdownItems() {
        logger.info("Test verifyHeadersAndDropdownItems started");
        test.info("Test verifyHeadersAndDropdownItems started");

        HomePage home = new HomePage(driver);
        home.open();
        logger.info("Home page opened");
        test.info("Home page opened");

        // Verify headers
        assertTrue(home.isProductsHeaderVisible(), "Products header should be visible");
        logger.info("Products header is visible");
        test.pass("Products header is visible");

        assertTrue(home.isSolutionsHeaderVisible(), "Solutions header should be visible");
        logger.info("Solutions header is visible");
        test.pass("Solutions header is visible");

        assertTrue(home.isResourcesHeaderVisible(), "Resources header should be visible");
        logger.info("Resources header is visible");
        test.pass("Resources header is visible");

        assertTrue(home.isCompanyNewsHeaderVisible(), "Company News header should be visible");
        logger.info("Company News header is visible");
        test.pass("Company News header is visible");

        // Verify Products dropdown
        home.hoverProducts();
        logger.info("Hovered over Products header");
        test.info("Hovered over Products header");

        List<WebElement> productsItems = home.getProductsDropdownItems();
        assertFalse(productsItems.isEmpty(), "Products dropdown should have items");
        logger.info("Products dropdown has " + productsItems.size() + " items");
        test.pass("Products dropdown has " + productsItems.size() + " items");

        for (WebElement item : productsItems) {
            assertTrue(item.isDisplayed(), "Product dropdown item should be visible: " + item.getText());
            logger.info("Verified product dropdown item: " + item.getText());
            test.pass("Verified product dropdown item: " + item.getText());
        }

        // Verify Solutions dropdown
        home.hoverSolutions();
        logger.info("Hovered over Solutions header");
        test.info("Hovered over Solutions header");

        List<WebElement> solutionsItems = home.getSolutionsDropdownItems();
        assertFalse(solutionsItems.isEmpty(), "Solutions dropdown should have items");
        logger.info("Solutions dropdown has " + solutionsItems.size() + " items");
        test.pass("Solutions dropdown has " + solutionsItems.size() + " items");

        for (WebElement item : solutionsItems) {
            assertTrue(item.isDisplayed(), "Solutions dropdown item should be visible: " + item.getText());
            logger.info("Verified solutions dropdown item: " + item.getText());
            test.pass("Verified solutions dropdown item: " + item.getText());
        }

        // Verify Resources dropdown
        home.hoverResources();
        logger.info("Hovered over Resources header");
        test.info("Hovered over Resources header");

        List<WebElement> resourcesItems = home.getResourcesDropdownItems();
        assertFalse(resourcesItems.isEmpty(), "Resources dropdown should have items");
        logger.info("Resources dropdown has " + resourcesItems.size() + " items");
        test.pass("Resources dropdown has " + resourcesItems.size() + " items");

        for (WebElement item : resourcesItems) {
            assertTrue(item.isDisplayed(), "Resources dropdown item should be visible: " + item.getText());
            logger.info("Verified resources dropdown item: " + item.getText());
            test.pass("Verified resources dropdown item: " + item.getText());
        }

        // Click Company News and verify content
        home.clickCompanyNews();
        logger.info("Clicked on Company News header");
        test.info("Clicked on Company News header");

        String expectedText = "Entrata Receives $200 Million Investment from Blackstone";
        boolean isTextPresent = driver.findElements(By.xpath("//*[contains(text(),'" + expectedText + "')]"))
                .size() > 0;
        assertTrue(isTextPresent, "Expected text should be present on Company News page");

        logger.info("Verified expected text is present on Company News page");
        test.pass("Verified expected text is present on Company News page");

        logger.info("Test verifyHeadersAndDropdownItems completed successfully");
        test.pass("Test verifyHeadersAndDropdownItems completed successfully");
    }
}