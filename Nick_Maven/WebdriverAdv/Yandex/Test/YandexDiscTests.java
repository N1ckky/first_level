package Nick_Maven.WebdriverAdv.Yandex.Test;

import Nick_Maven.WebdriverAdv.Yandex.POModel.NavigationBlockPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.WordEditorPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskFilesPage;
import Nick_Maven.WebdriverAdv.Yandex.POModel.YandexDiskLoginPage;
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

        SoftAssert asert=new SoftAssert();
        asert.assertTrue(YandexDiscService.checkIsWordFileExist());

        filesPage
                .checkWordFile();

        browserParamsService
                .getAllOppenedTabs()
                .switchTab(2);

        asert.assertTrue(WordOnlineService.checkTextInWordEditor());
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
        SoftAssert asert=new SoftAssert();
        asert.assertFalse(YandexDiscService.checkFileNotInFilesFolder());

        filesBlock
                .checkGarbageBlock();

        asert.assertTrue(YandexDiscService.checkFileIsInGarbage());

        filesPage
                .clearGarbage()
        ;
        asert.assertFalse(YandexDiscService.checkFileNotInGarbage());
        driverQuit();
    }
}
