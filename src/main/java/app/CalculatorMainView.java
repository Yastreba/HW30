package app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class CalculatorMainView {
    AppiumDriver appiumDriver;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_add')]")
    public MobileElement plusButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_pct')]")
    public MobileElement percentageButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'dec_point')]")
    public MobileElement pointButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_mul')]")
    public MobileElement multiplicationButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'eq')]")
    public MobileElement equalButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'result_final')]")
    public MobileElement resultField;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'C')]")
    public MobileElement resetButton;

    public CalculatorMainView(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.appiumDriver), this);
    }

    public WebElement plusButton() {
        return plusButton;
    }

    public WebElement equalButton() {
        return equalButton;
    }

    public WebElement multiplicationButton() {
        return multiplicationButton;
    }

    public void rotate() {
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public WebElement percentageButton() {
    return percentageButton;
    }

    public WebElement pointButton() {
        return pointButton;
    }


    public WebElement resetButton() {
        return resetButton;
    }

    public WebElement digit(int digitNum) {
        return appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'digit_"+ digitNum +"')]"));
    }

    public void reset() {
        resetButton().click();
    }


}




