package pages;


import io.appium.java_client.AppiumDriver;

public class NewToursPage extends BasePage {

    HomePage homePage = new HomePage(appiumDriver);

    public NewToursPage(AppiumDriver driver){
        appiumDriver = driver;
    }

    public boolean isMainFragmentPresent() {
        return homePage.getRootElement().isDisplayed();
    }
}
