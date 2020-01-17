package Nick_Maven.WebdriverAdv.Yandex.Test;

import Nick_Maven.WebdriverAdv.Yandex.POModel.BrowserParams;
import Nick_Maven.WebdriverAdv.Yandex.POModel.NavigationBlockPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskLoginPage;
import Nick_Maven.WebdriverAdv.Yandex.model.User;
import Nick_Maven.WebdriverAdv.Yandex.service.UserCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SmokeTest {
    private WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Creation Word file test")
    public void yandexDiscSmokeTest() {
        ArrayList<String> tempList = new ArrayList<>();
        BrowserParams browser = new BrowserParams(driver);
        User testUser = UserCreator.withCredentialsFromProperty();

        NavigationBlockPage yandexDiskTest = new YandexDiskLoginPage(driver)
                .openPage()
                .userLogin(testUser);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}