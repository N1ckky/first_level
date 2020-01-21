package Nick_Maven.WebdriverAdv.Yandex.tests;

import Nick_Maven.WebdriverAdv.Yandex.service.DriverService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    protected static WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 10;

    public static void driverQuit() {
        driver = DriverService.getDriver();
        driver.quit();
        driver = null;
    }

    @BeforeMethod(alwaysRun = true)
    public void driverSetup() {
        driver = DriverService.getDriver();
    }

}