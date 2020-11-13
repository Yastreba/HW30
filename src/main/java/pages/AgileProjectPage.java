package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class AgileProjectPage  extends BasePage  {

    By loginInput = By.xpath("//input[@name='uid']");
    By passInput = By.xpath("//input[@name='password']");
    By Message = By.cssSelector("marquee.heading3");

    public AgileProjectPage(AppiumDriver driver){
        appiumDriver = driver;
    }

    public boolean isWelcomeMessagePresent() {
        return appiumDriver.findElement(Message).isDisplayed();
    }

    public void inputUserAndPass(String user, String pass)  {
        appiumDriver.findElement(loginInput).sendKeys(user);
        appiumDriver.findElement(passInput).sendKeys(pass);
    }

    public void clickLoginButton() {
        appiumDriver.getKeyboard().pressKey(Keys.ENTER);
    }
}




