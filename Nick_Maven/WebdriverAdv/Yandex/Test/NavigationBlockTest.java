package Nick_Maven.WebdriverAdv.Yandex.Test;

import Nick_Maven.WebdriverAdv.Yandex.POModel.NavigationBlockPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskLoginPage;
import Nick_Maven.WebdriverAdv.Yandex.service.DriverService;
import Nick_Maven.WebdriverAdv.Yandex.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static Nick_Maven.WebdriverAdv.Yandex.service.NavigationBlockService.titlesComparisonInNavBlock;

public class NavigationBlockTest extends CommonConditions {

    @Test(description = "Yandex disk navigation block test")
    public void yandexDiskNavigationBlockTest() {
        NavigationBlockPage yandexDiskTest = new YandexDiskLoginPage()
                .userLogin(UserCreator.withCredentialsFromProperty())
                .checkLastFilesBlock()
                .checkFilesBlock()
                .checkFotoBlock()
                .checkAlbumsBlock()
                .checkSharedBlock()
                .checkHistoryBlock()
                .checkArchiveBlock()
                .checkGarbageBlock();

        Assert.assertTrue(titlesComparisonInNavBlock());
    }

    @AfterMethod
    public void browserQuit() {
        driver = DriverService.getDriver();
        driver.quit();
        driver = null;
    }
}
