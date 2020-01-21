package Nick_Maven.WebdriverAdv.Yandex.service;

import Nick_Maven.WebdriverAdv.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverService {
    protected static WebDriver driver;

    public static WebDriver setUpDriver(String homePage, int Timeout) {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(homePage);
            new WebDriverWait(driver, Timeout).until(CustomConditions.jsReadyStateCompleted());
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}