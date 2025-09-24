package com.awesomeqa.drivers;

import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseDriver {


    // Initialize WebDriver with browserName
    public static WebDriver getBrowser(String browserName) {

        switch (browserName.toLowerCase()) {
            case "chrome":
                return new ChromeDriver(getChromeOptions());

            case "firefox":
                return new FirefoxDriver(getFirefoxOptions());

            case "edge":
                return new EdgeDriver(getEdgeOptions());

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            chromeOptions.addArguments("--headless");
        }
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized--");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            firefoxOptions.addArguments("--headless");
        }
        return firefoxOptions;
    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            edgeOptions.addArguments("--headless");
        }
        return edgeOptions;
    }


}

