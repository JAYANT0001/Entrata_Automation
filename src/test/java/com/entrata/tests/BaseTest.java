package com.entrata.tests;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.entrata.Utilities.ScreenshotsUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;

import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setUpSuite() {
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
        logger.info("Extent Report initialized at: " + reportPath);
    }

    @BeforeMethod
    public void setup(Method method) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        test = extent.createTest(method.getName());
        logger.info("Test started: " + method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getName();

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test Failed: " + testName);
            test.fail(result.getThrowable());

            String screenshotPath = ScreenshotsUtil.takeScreenshot(driver, testName);
            if (screenshotPath != null) {
                logger.info("Screenshot saved at: " + screenshotPath);
                // Use relative path for ExtentReport
                String relativePath = "./" + screenshotPath.substring(System.getProperty("user.dir").length() + 1);
                test.addScreenCaptureFromPath(relativePath);
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Test Passed: " + testName);
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("Test Skipped: " + testName);
            test.skip(result.getThrowable());
        }

        if (driver != null) {
            driver.quit();
            logger.info("Browser closed for test: " + testName);
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        if (extent != null) {
            extent.flush();
            logger.info("Extent Report flushed");
        }
    }
}