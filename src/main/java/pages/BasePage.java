package pages;


import io.appium.java_client.AppiumDriver;

public class BasePage {

    AppiumDriver appiumDriver;

    public String getTitle() {
        return appiumDriver.getTitle();
    }
    }


