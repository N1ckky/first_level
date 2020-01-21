package Nick_Maven.WebdriverAdv.Yandex.tests;

import Nick_Maven.WebdriverAdv.Yandex.pages.NavigationBlockPage;
import Nick_Maven.WebdriverAdv.Yandex.pages.WordEditorPage;
import Nick_Maven.WebdriverAdv.Yandex.pages.YandexDiskFilesPage;
import Nick_Maven.WebdriverAdv.Yandex.pages.YandexDiskLoginPage;
import Nick_Maven.WebdriverAdv.Yandex.model.User;
import Nick_Maven.WebdriverAdv.Yandex.service.BrowserParamsService;
import Nick_Maven.WebdriverAdv.Yandex.service.DriverService;
import Nick_Maven.WebdriverAdv.Yandex.service.UserCreator;
import Nick_Maven.WebdriverAdv.Yandex.service.WordOnlineService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static Nick_Maven.WebdriverAdv.Yandex.service.YandexDiscService.checkFolderName;

public class CreateFolderAndWordFileTest extends CommonConditions{

    @Test(description = "Creation Word file test")
    public void yandexDiskCreateFolderAndWordFileTest() {
        BrowserParamsService browser = new BrowserParamsService();
        User testUser = UserCreator.withCredentialsFromProperty();

        NavigationBlockPage newFolderTest = new YandexDiskLoginPage()
                .userLogin(testUser)
                .checkFilesBlock();
        YandexDiskFilesPage filesPage = new YandexDiskFilesPage()
                .openContextMenu()
                .createNewFolder()
                .setNewFolderName()
                .openCreatedFolder()
                .openContextMenu();
        WordEditorPage wordEditorPage = new YandexDiskFilesPage()
                .createWordFile();
        browser
                .getAllOppenedTabs()
                .switchTab(1);
        wordEditorPage
                .sendTextToWordEditor()
                .setWordFileName();
        browser
                .switchTab(0);
        filesPage
                .checkWordFile();
        browser
                .getAllOppenedTabs()
                .switchTab(2);

        Assert.assertTrue(checkFolderName());
        Assert.assertTrue(WordOnlineService.checkTextInTheWordDocument);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver = DriverService.getDriver();
        driver.quit();
        driver = null;
    }
}