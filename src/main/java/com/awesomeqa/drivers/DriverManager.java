package com.awesomeqa.drivers;

import com.awesomeqa.utils.data_Reader.PropertiesUtils;
import com.awesomeqa.utils.report.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    private DriverManager() {
        super();
    }

    @Step("create driver ")
    public static WebDriver initializeDriver() {
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        WebDriver driver = BaseDriver.getBrowser(browserName);
        LogsUtils.info("Driver created on: ", browserName);
        setDriver(driver);
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            LogsUtils.info("Driver is null");
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }
}
