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

import static Nick_Maven.WebdriverAdv.Yandex.POModel.WordEditorPage.checkTextInTheWordDocument;
import static Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskFilesPage.checkFolderName;
import static Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskFilesPage.checkWordFileExist;

public class CreateFolderAndWordFileTest {
    private WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Creation Word file test")
    public void yandexDiskCreateFolderAndWordFileTest() {
        ArrayList<String> tempList = new ArrayList<>();
        BrowserParams browser = new BrowserParams(driver);
        User testUser = UserCreator.withCredentialsFromProperty();

        NavigationBlockPage newFolderTest = new YandexDiskLoginPage(driver)
                .openPage()
                .userLogin(testUser)
                .checkFilesBlock();
        YandexDiskFilesPage filesPage = new YandexDiskFilesPage(driver)
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
        filesPage
                .checkWordFile();
        browser
                .getAllOppenedTabs()
                .switchSecondTab();
        wordEditorPage
                .checkTextInWordEditor();

        Assert.assertTrue(checkFolderName);
        Assert.assertTrue(checkWordFileExist);
        Assert.assertTrue(checkTextInTheWordDocument);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
