package Nick_Maven.WebdriverAdv.Yandex.Test;

import Nick_Maven.WebdriverAdv.Yandex.POModel.NavigationBlockPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.WordEditorPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskFilesPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskLoginPage;
import Nick_Maven.WebdriverAdv.Yandex.service.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static Nick_Maven.WebdriverAdv.Yandex.service.YandexDiscService.checkFolderName;

public class AllInOneTest extends CommonConditions{
    @Test(description = "Nav Bar test")
    public void yandexDiscAllTests() {
        BrowserParamsService browser = new BrowserParamsService();

        System.out.println("---Starts nav bar test");
        NavigationBlockPage navigationBlockPage = new YandexDiskLoginPage()
                .userLogin(UserCreator.withCredentialsFromProperty())
                .checkLastFilesBlock()
                .checkFilesBlock()
                .checkFotoBlock()
                .checkAlbumsBlock()
                .checkSharedBlock()
                .checkHistoryBlock()
                .checkArchiveBlock()
                .checkGarbageBlock();
        System.out.println("+++Completed nav bar test");

        System.out.println("---Starts create folder and word file test");
        navigationBlockPage
                .checkFilesBlock();
        YandexDiskFilesPage yandexDiskFilesPage = new YandexDiskFilesPage()
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
        yandexDiskFilesPage
                .checkWordFile();
        browser
                .getAllOppenedTabs()
                .switchTab(2);

        Assert.assertTrue(checkFolderName());
        Assert.assertTrue(WordOnlineService.checkTextInTheWordDocument);
        System.out.println("+++Completed create folder and word file test");

        System.out.println("---Starts garbage test");
        browser.switchTab(0);
        navigationBlockPage
                .checkFilesBlock();
        yandexDiskFilesPage
                .openCreatedFolder()
                .selectWordFile()
                .deleteWordFile();

        Assert.assertFalse(YandexDiscService.checkFileNotInFilesFolder());
        navigationBlockPage
                .checkGarbageBlock();

        Assert.assertTrue(YandexDiscService.checkFileIsInGarbage());

        yandexDiskFilesPage
                .clearGarbage();

        Assert.assertFalse(YandexDiscService.checkFileNotInGarbage());

        System.out.println("+++Completed garbage test");
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver = DriverService.getDriver();
        driver.quit();
        driver = null;
    }
}
