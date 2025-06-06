package com.entrata.tests;
import com.entrata.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class VerifyBusinessSuitesNavigation extends BaseTest {

    @Test
    public void verifyEachBusinessSuiteNavigation() {
        logger.info("Test verifyEachBusinessSuiteNavigation started");

        HomePage home = new HomePage(driver);
        home.open();
        logger.info("Entrata homepage launched");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> businessCards = driver.findElements(By.xpath("//div[@class='suite-card_heading']"));
        int count = Math.min(4, businessCards.size());

        for (int i = 0; i < count; i++) {
            // Re-fetch elements due to page reload after navigation back
            businessCards = driver.findElements(By.xpath("//div[@class='suite-card_heading']"));
            WebElement businessCard = businessCards.get(i);
            String fullCardText = businessCard.getText().trim();

            // Remove " Suite" from card text for validation
            String expectedPageHeading = fullCardText.replace(" Suite", "").trim();

            logger.info("Clicking on business card index: " + i + ", text: " + fullCardText);

            // Scroll element into view
            js.executeScript("arguments[0].scrollIntoView(true);", businessCard);

            // Wait until clickable
            wait.until(ExpectedConditions.elementToBeClickable(businessCard));

            try {
                businessCard.click();
            } catch (ElementClickInterceptedException e) {
                logger.warn("Normal click intercepted, trying JavaScript click");
                js.executeScript("arguments[0].click();", businessCard);
            }

            logger.info("Clicked on: " + fullCardText);

            // Wait for the page heading that matches expected text (without "Suite")
            By validationLocator = By.xpath("//h1[contains(text(), '" + expectedPageHeading + "')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(validationLocator));

            WebElement validationElement = driver.findElement(validationLocator);
            assertTrue(validationElement.isDisplayed(),
                "Expected text '" + expectedPageHeading + "' not visible on target page.");

            logger.info("Verified text on navigated page: " + expectedPageHeading);

            driver.navigate().back();
            logger.info("Returned to homepage after verifying: " + fullCardText);

            // Wait for homepage to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='suite-card_heading']")));
        }

        logger.info("Test verifyEachBusinessSuiteNavigation completed successfully");
    }
}