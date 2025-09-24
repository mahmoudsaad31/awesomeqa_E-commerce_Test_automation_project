package com.awesomeqa;


import com.awesomeqa.drivers.DriverManager;
import com.awesomeqa.listeners.TestNGListeners;
import com.awesomeqa.utils.TimestampUtils;
import com.awesomeqa.utils.data_Reader.JsonUtils;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(TestNGListeners.class)
public class TestBase {


    public String getProductData(String data) {
        JsonUtils ProductData = new JsonUtils("Product_Data");
        return ProductData.getJsonData(data);
    }

    public String getTestData(String data) {
        JsonUtils testData = new JsonUtils("test_data");
        return testData.getJsonData(data);
    }

    public String getRANDTestData(String data) {
        JsonUtils testData = new JsonUtils("test_data");
        return testData.getJsonData(data) + TimestampUtils.getTimestamp();

    }


    //configuration
    @BeforeSuite(alwaysRun = true)
    @Step("Setup the environment")
    public void setup() {
        DriverManager.initializeDriver();


    }

//    @AfterSuite(alwaysRun = true)
//    @Step("shut down the environment")
//    public void tearDown() {
//        BrowserActions.closeBrowser();
//    }

}

