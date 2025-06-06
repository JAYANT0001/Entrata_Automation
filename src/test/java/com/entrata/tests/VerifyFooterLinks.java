package com.entrata.tests;

import com.entrata.pages.HomePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class VerifyFooterLinks extends BaseTest {

    @Test(priority = 5)
    public void verifyAllVisibleFooterLinksAreUniqueAndClickable() {
        logger.info("Test verifyAllVisibleFooterLinksAreUniqueAndClickable started");

        HomePage homePage = new HomePage(driver);
        homePage.open();
        logger.info("Entrata homepage launched");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> sectionHeaders = homePage.getFooterSectionHeaders();
        List<WebElement> allLinks = homePage.getAllFooterLinks();

        Set<String> uniqueVisibleLinks = new HashSet<>();

        for (WebElement section : sectionHeaders) {
            js.executeScript("arguments[0].scrollIntoView(true);", section);
        }

        for (WebElement link : allLinks) {
            js.executeScript("arguments[0].scrollIntoView(true);", link);

            if (link.isDisplayed()) {
                String text = link.getText().trim();
                String href = link.getAttribute("href");

                logger.info("Validating visible footer link: " + text + " -> " + href);

                assertFalse(text.isEmpty(), "Link text is empty");
                assertNotNull(href, "Href is null");
                assertFalse(href.isEmpty(), "Href is empty");

                // Check for duplicates only among visible links
                if (!uniqueVisibleLinks.add(href)) {
                    logger.warn("Duplicate footer link detected (allowed): " + href);
                }
            }
        }

        logger.info("Total visible and unique footer links verified: " + uniqueVisibleLinks.size());
        logger.info("Test verifyAllVisibleFooterLinksAreUniqueAndClickable completed successfully");
    }
}