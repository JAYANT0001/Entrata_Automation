package com.entrata.tests;

import static org.testng.Assert.assertTrue;

import com.entrata.pages.DemoPage;
import com.entrata.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.List;

import static org.testng.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InteractWithFirstProductAndFillForm extends BaseTest {

    private static final Logger logger = LogManager.getLogger(InteractWithFirstProductAndFillForm.class);

    @Test(priority = 3)
    public void interactWithFirstProductAndFillForm() {
        logger.info("Test interactWithFirstProductAndFillForm started");

        HomePage home = new HomePage(driver);
        DemoPage demo = new DemoPage(driver);

        home.open();
        logger.info("Home page opened");

        home.hoverProducts();
        logger.info("Hovered over Products header");

        List<WebElement> productsItems = home.getProductsDropdownItems();
        if (!productsItems.isEmpty()) {
            WebElement firstItem = productsItems.get(0);
            String firstItemText = firstItem.getText();
            firstItem.click();
            logger.info("Clicked first Products dropdown item: " + firstItemText);

            demo.firstDemoClick();
            demo.bookDemoClick();

            // Wait explicitly for the form to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(demo.getSubmitButton()));
            logger.info("Form is visible and ready");

            // Fill the form 
            demo.enterFirstName("John");
            demo.enterLastName("Doe");
            demo.enterEmail("john.doe@example.com");
            demo.enterCompanyName("Acme Corp");
            demo.enterPhoneNumber("1234567890");
            demo.enterTotalManagedUnits(); // assumes selecting first dropdown item
            demo.enterJobTitle("Manager");
            demo.selectIamOption(); // assumes selecting first "I am" option

            logger.info("Filled the form");

            //  Assertion instead of submission
            assertTrue(demo.getSubmitButton().isDisplayed(), "Submit button is not visible");
            assertTrue(demo.getSubmitButton().isEnabled(), "Submit button is not enabled");

        } else {
            logger.error("Products dropdown items are empty");
            fail("Propducts dropdown items are empty");
        }

        logger.info("Test interactWithFirstProductAndFillForm completed");
    }
}