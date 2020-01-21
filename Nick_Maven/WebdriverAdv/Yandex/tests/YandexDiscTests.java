package Nick_Maven.WebdriverAdv.Yandex.tests;

import Nick_Maven.WebdriverAdv.Yandex.pages.NavigationBlockPage;
import Nick_Maven.WebdriverAdv.Yandex.pages.WordEditorPage;
import Nick_Maven.WebdriverAdv.Yandex.pages.YandexDiskFilesPage;
import Nick_Maven.WebdriverAdv.Yandex.pages.YandexDiskLoginPage;
import Nick_Maven.WebdriverAdv.Yandex.service.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Nick_Maven.WebdriverAdv.Yandex.service.NavigationBlockService.titlesComparisonInNavBlock;
import static Nick_Maven.WebdriverAdv.Yandex.service.YandexDiscService.checkFolderName;

public class YandexDiscTests extends CommonConditions {
    @Test(priority = 1, description = "Try to log In in account")
    public void yandexDiscSmokeTest() {
        NavigationBlockPage loginPage = new YandexDiskLoginPage()
                .userLogin(UserCreator.withCredentialsFromProperty());
    }

    @Test(priority = 2, description = "Yandex disk navigation block test")
    public void yandexDiskNavigationBlockTest() {
        NavigationBlockPage navBlock = new NavigationBlockPage()
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

    @Test(priority = 3, description = "Creation folder test")
    public void yandexDiscCreateFolderTest() {
        NavigationBlockPage newFolderTest = new NavigationBlockPage()
                .checkFilesBlock();
        YandexDiskFilesPage filesPage = new YandexDiskFilesPage()
                .openContextMenu()
                .createNewFolder()
                .setNewFolderName()
                .openCreatedFolder();

        Assert.assertTrue(checkFolderName());
    }

    @Test(priority = 3, description = "Creation Word file test")
    public void yandexDiskCreateFolderAndWordFileTest() {
        NavigationBlockPage newFolderTest = new NavigationBlockPage()
                .checkFilesBlock();
        YandexDiskFilesPage filesPage = new YandexDiskFilesPage()
                .openContextMenu()
                .createNewFolder()
                .setNewFolderName()
                .openCreatedFolder()
                .openContextMenu();
        WordEditorPage wordEditorPage = new YandexDiskFilesPage()
                .createWordFile();
        BrowserParamsService browserParamsService = new BrowserParamsService()
                .getAllOppenedTabs()
                .switchTab(1);
        wordEditorPage
                .sendTextToWordEditor()
                .setWordFileName();
        browserParamsService
                .switchTab(0);

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(YandexDiscService.checkIsWordFileExist());

        filesPage
                .checkWordFile();

        browserParamsService
                .getAllOppenedTabs()
                .switchTab(2);

        softAssert.assertTrue(WordOnlineService.checkTextInWordEditor());
        softAssert.assertAll();
    }

    @Test(priority = 4, description = "Yandex disc garbage test")
    public void yandexDisсGarbageTest() {
        new BrowserParamsService()
                .getAllOppenedTabs()
                .switchTab(0);
        NavigationBlockPage filesBlock = new NavigationBlockPage()
                .checkFilesBlock();
        YandexDiskFilesPage filesPage = new YandexDiskFilesPage()
                .setNameToFolderMustBeOpened("test")
                .openCreatedFolder()
                .selectWordFile()
                .deleteWordFile();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(YandexDiscService.checkFileNotInFilesFolder());

        filesBlock
                .checkGarbageBlock();

        softAssert.assertTrue(YandexDiscService.checkFileIsInGarbage());

        filesPage
                .clearGarbage()
        ;
        softAssert.assertFalse(YandexDiscService.checkFileNotInGarbage());
        softAssert.assertAll();
        driverQuit();
    }
}