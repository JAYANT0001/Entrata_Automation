package com.entrata.tests;

import com.entrata.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class VerifyApplicationLaunchTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(VerifyApplicationLaunchTest.class);

    @Test
    public void verifyApplicationLaunch() {
        logger.info("Test verifyApplicationLaunch started");

        HomePage home = new HomePage(driver);
        home.open();
        logger.info("Navigated to Entrata homepage");

        // Explicit wait for Products header
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.getProductsHeader()));
        logger.info("Products header is visible");

        // Assertion
        assertTrue(home.isProductsHeaderVisible(), "Products header is not visible - Application might not be loaded properly");
        logger.info("Verified that application launched successfully");

        logger.info("Test verifyApplicationLaunch completed");
    }
}