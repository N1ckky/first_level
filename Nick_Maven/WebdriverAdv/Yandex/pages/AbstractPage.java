package Nick_Maven.WebdriverAdv.Yandex.pages;

import Nick_Maven.WebdriverAdv.Yandex.service.DriverService;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected static WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    protected static final String HOMEPAGE_URL = "https://disk.yandex.by/";

    protected AbstractPage() {
        driver = setUpDriver();
    }

    public static WebDriver setUpDriver() {
        return DriverService.setUpDriver(HOMEPAGE_URL, WAIT_TIMEOUT_SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void openHomePage() {
        driver.get(HOMEPAGE_URL);
    }
}