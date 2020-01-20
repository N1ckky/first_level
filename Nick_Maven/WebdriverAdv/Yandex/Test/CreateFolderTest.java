package Nick_Maven.WebdriverAdv.Yandex.Test;

import Nick_Maven.WebdriverAdv.Yandex.POModel.NavigationBlockPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskFilesPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskLoginPage;
import Nick_Maven.WebdriverAdv.Yandex.service.DriverService;
import Nick_Maven.WebdriverAdv.Yandex.service.UserCreator;
import Nick_Maven.WebdriverAdv.Yandex.service.YandexDiscService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CreateFolderTest extends CommonConditions{
    @Test(description = "Creation folder test")
    public void yandexDiscCreateFolderTest() {
        NavigationBlockPage newFolderTest = new YandexDiskLoginPage()
                .userLogin(UserCreator.withCredentialsFromProperty())
                .checkFilesBlock();
        YandexDiskFilesPage filesPage = new YandexDiskFilesPage()
                .openContextMenu()
                .createNewFolder()
                .setNewFolderName()
                .openCreatedFolder()
                ;

        Assert.assertTrue(YandexDiscService.checkFolderName());
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver = DriverService.getDriver();
        driver.quit();
        driver = null;
    }
}
