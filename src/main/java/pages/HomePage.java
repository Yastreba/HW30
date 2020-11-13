package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    By rootElement = By.cssSelector("div[class='row']");
    By agileProjectLink = By.xpath("//a[contains(text(), 'Agile Project')]");
    By newToursLink = By.xpath("//a[contains(text(), 'New Tours')]");
    By seleniumDropdown = By.xpath("//a[@class='dropdown-toggle' and contains(text(), 'Selenium')]");
    By tableDemoLink = By.xpath("//a[contains(text(), 'Table Demo')]");
    By loginForm = By.cssSelector("form[name='frmLogin']");

    public HomePage(AppiumDriver driver){
        appiumDriver = driver;
    }

    public boolean isLoginFormPresent() {
      return  appiumDriver.findElement(loginForm).isDisplayed();
    }

    public void navigate() {
       appiumDriver.get("http://demo.guru99.com/");
    }

    public WebElement getRootElement() {
        return appiumDriver.findElement(rootElement);
    }

    private void clickSeleniumSelector() {
        appiumDriver.findElement(seleniumDropdown).click();
    }

    public void clickAgileProjectLink() {
        appiumDriver.findElement(agileProjectLink).click();
    }

    public void clickNewToursLink() {
        appiumDriver.findElement(newToursLink).click();
    }

    public void clickTableDemo() {
        clickSeleniumSelector();
        appiumDriver.findElement(tableDemoLink).click();
    }
}


