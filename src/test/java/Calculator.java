import app.CalculatorMainView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Calculator {

    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_API_30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");

        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void sumTest(){
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);
        calculatorMainView.rotate();
        calculatorMainView.digit(3).click();
        calculatorMainView.plusButton().click();
        calculatorMainView.digit(6).click();
        calculatorMainView.equalButton().click();

        assertEquals("9", calculatorMainView.resultField.getText());

        calculatorMainView.reset();
    }

    @Test
    public void multipleTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);
        calculatorMainView.digit(2).click();
        calculatorMainView.multiplicationButton().click();
        calculatorMainView.digit(7).click();
        calculatorMainView.equalButton().click();

        assertEquals("14", calculatorMainView.resultField.getText());
    }

    @Test
    public void percentageTest() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);
        calculatorMainView.rotate();
        calculatorMainView.digit(1).click();
        calculatorMainView.digit(0).click();
        calculatorMainView.digit(0).click();
        calculatorMainView.plusButton().click();
        calculatorMainView.digit(9).click();
        calculatorMainView.percentageButton().click();
        calculatorMainView.equalButton().click();

        assertEquals("109", calculatorMainView.resultField.getText());
    }
    @Test
    public void percentageTest2() {
        CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);
        calculatorMainView.rotate();
        calculatorMainView.digit(1).click();
        calculatorMainView.digit(0).click();
        calculatorMainView.digit(0).click();
        calculatorMainView.plusButton().click();
        calculatorMainView.digit(9).click();
        calculatorMainView.pointButton().click();
        calculatorMainView.digit(5).click();
        calculatorMainView.percentageButton().click();
        calculatorMainView.equalButton().click();

        assertEquals("109.5", calculatorMainView.resultField.getText());
    }
}




