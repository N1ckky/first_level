package Nick_Maven.WebdriverAdv.Yandex.Test;

import Nick_Maven.WebdriverAdv.Yandex.POModel.*;
import Nick_Maven.WebdriverAdv.Yandex.model.User;
import Nick_Maven.WebdriverAdv.Yandex.service.UserCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static Nick_Maven.WebdriverAdv.Yandex.POModel.NavigationBlockPage.navigationBlockTitlesAsExpected;
import static Nick_Maven.WebdriverAdv.Yandex.POModel.WordEditorPage.checkTextInTheWordDocument;
import static Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskFilesPage.checkFolderName;
import static Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskFilesPage.checkWordFileExist;

public class AllInOneTest {
    private WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Nav Bar test")
    public void yandexDiscAllTests() {
        ArrayList<String> tempList = new ArrayList<>();
        BrowserParams browser = new BrowserParams(driver);
        User testUser = UserCreator.withCredentialsFromProperty();

        System.out.println("---Starts nav bar test");
        NavigationBlockPage navigationBlockPage = new YandexDiskLoginPage(driver)
                .openPage()
                .userLogin(testUser)
                .checkLastFilesBlock()
                .checkFilesBlock()
                .checkFotoBlock()
                .checkAlbumsBlock()
                .checkSharedBlock()
                .checkHistoryBlock()
                .checkArchiveBlock()
                .checkGarbageBlock()
                .titleComparisonBlock();
        Assert.assertTrue(navigationBlockTitlesAsExpected);
        System.out.println("+++Completed nav bar test");

        System.out.println("---Starts create folder and word file test");
        navigationBlockPage
                .checkFilesBlock();
        YandexDiskFilesPage yandexDiskFilesPage = new YandexDiskFilesPage(driver)
                .openContextMenu()
                .createNewFolder()
                .setNewFolderName()
                .openCreatedFolder()
                .openContextMenu();
        WordEditorPage wordEditorPage = new YandexDiskFilesPage(driver)
                .createWordFile();
        browser
                .getAllOppenedTabs()
                .switchFirstTab();
        wordEditorPage
                .sendTextToWordEditor()
                .setWordFileName();
        browser
                .switchZeroTab();
        yandexDiskFilesPage
                .checkWordFile();
        browser
                .getAllOppenedTabs()
                .switchSecondTab();
        wordEditorPage
                .checkTextInWordEditor();

        Assert.assertTrue(checkFolderName);
        Assert.assertTrue(checkWordFileExist);
        Assert.assertTrue(checkTextInTheWordDocument);
        System.out.println("+++Completed create folder and word file test");

        System.out.println("---Starts garbage test");
        browser.switchZeroTab();
        navigationBlockPage
                .checkFilesBlock();
        yandexDiskFilesPage
                .openCreatedFolder()
                .selectWordFile()
                .deleteWordFile();

        Assert.assertFalse(yandexDiskFilesPage.checkFileNotInFilesFolder());
        navigationBlockPage
                .checkGarbageBlock();

        Assert.assertTrue(yandexDiskFilesPage.checkFileIsInGarbage());

        yandexDiskFilesPage
                .clearGarbage();

        Assert.assertFalse(yandexDiskFilesPage.checkFileNotInGarbage());

        System.out.println("+++Completed garbage test");
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
