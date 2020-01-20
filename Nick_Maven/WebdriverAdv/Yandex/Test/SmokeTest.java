package Nick_Maven.WebdriverAdv.Yandex.Test;

import Nick_Maven.WebdriverAdv.Yandex.POModel.NavigationBlockPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskLoginPage;
import Nick_Maven.WebdriverAdv.Yandex.service.DriverService;
import Nick_Maven.WebdriverAdv.Yandex.service.UserCreator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SmokeTest extends CommonConditions {

    @Test(description = "Smoke test - log In to yandex Disc")
    public void yandexDiscSmokeTest() {
        NavigationBlockPage yandexDiskTest = new YandexDiskLoginPage()
                .userLogin(UserCreator.withCredentialsFromProperty());
    }

    @AfterMethod
    public void browserQuit() {
        driver = DriverService.getDriver();
        driver.quit();
        driver = null;
    }
}