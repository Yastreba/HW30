import com.codeborne.selenide.Selenide;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AgileProjectPage;
import pages.HomePage;
import pages.NewToursPage;
import pages.TablePage;

import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Guru99 {
    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_API_30");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("chromedriverExecutableDir", "C:\\Users\\Yastreba\\.m2\\repository\\webdriver\\chromedriver\\win32\\83.0.4103.106");

        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }


    @Test
    public void agileProjectTest()  {
        HomePage homePage = new HomePage(appiumDriver);
        AgileProjectPage agileProjectPage = new AgileProjectPage(appiumDriver);
        homePage.navigate();
        homePage.clickAgileProjectLink();
        agileProjectPage.inputUserAndPass("1303", "Guru99");
        agileProjectPage.clickLoginButton();
        assertTrue(agileProjectPage.isWelcomeMessagePresent());
        homePage.navigate();
        homePage.clickAgileProjectLink();
        agileProjectPage.inputUserAndPass("111", "xyz");
        agileProjectPage.clickLoginButton();
        assertEquals("User or Password is not valid", Selenide.switchTo().alert().getText());
        Selenide.switchTo().alert().accept();
    }


    @Test
    public void SmokeNavigationTest() {
        HomePage homePage = new HomePage(appiumDriver);
        NewToursPage newToursPage = new NewToursPage(appiumDriver);
        TablePage tablePage = new TablePage(appiumDriver);
        homePage.navigate();
        assertEquals("Guru99 Bank Home Page", homePage.getTitle());
        assertTrue(homePage.isLoginFormPresent());
        homePage.navigate();
        homePage.clickNewToursLink();
        assertEquals("Welcome: Mercury Tours", newToursPage.getTitle());
        assertTrue(newToursPage.isMainFragmentPresent());
        homePage.navigate();
        homePage.clickTableDemo();
        assertEquals("Table Demo", tablePage.getTitle());
        assertTrue(tablePage.isTablePresent());

    }
}









