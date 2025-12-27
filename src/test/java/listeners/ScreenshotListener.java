package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;
import utility.ScreenshotUtility;

//This listener captures a screenshot whenever a test fails
    public class ScreenshotListener extends TestBase implements ITestListener {

    	// This method runs automatically when a test fails
    	@Override
        public void onTestFailure(ITestResult result) {
            try {
                // Get the test class instance
                Object testClass = result.getInstance();

                // Fetch the driver from the test class
                WebDriver driver = ((TestBase) testClass).getDriver();

                // Null check before taking screenshot
                if (driver != null) {
                    ScreenshotUtility.capture(driver, result.getName());
                } else {
                    System.out.println("Driver is null. Screenshot not captured for " + result.getName());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


