package com.awesomeqa.utils.report;

import com.awesomeqa.drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotsUtils {

    public static final String SCREENSHOTS_PATH = "test-outputs/screenshots/";


    private ScreenshotsUtils() {
        super();
    }

    public static void takeScreenshot(String screenshotName) {
        //code
        try {
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + ".png");
            FileUtils.copyFile(screenshot, screenshotFile);
            AllureUtils.attachScreenshotsToAllure(screenshotName, screenshotFile.getPath());
        } catch (Exception e) {
            LogsUtils.error("Failed to take screenshot: " + e.getMessage());
        }

    }
}
