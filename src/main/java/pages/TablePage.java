package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TablePage extends BasePage {

    By table = By.cssSelector("table[cellspacing]");

    public TablePage(AppiumDriver driver){
        appiumDriver = driver;
    }

    public boolean isTablePresent() {
        return appiumDriver.findElement(table).isDisplayed();
    }
}
