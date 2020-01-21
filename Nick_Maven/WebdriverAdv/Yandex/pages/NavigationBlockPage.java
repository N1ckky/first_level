package Nick_Maven.WebdriverAdv.Yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class NavigationBlockPage extends AbstractPage {
    private static final String FOLDER_TITLE_LOCATOR = "//*[contains(@class,'listing-stub__desc')]//child::h1";
    public static ArrayList<String> getRealTitlesOfBlock = new ArrayList<>();

    public NavigationBlockPage() {
        super();
    }

    public NavigationBlockPage checkLastFilesBlock() {
        String lastFilesLocator = "//*[@title='Последние']";
        String lastFilesTitleLocator = "//*[@title='Последние файлы']";
        selectFolderAndGetBlockTitle(lastFilesLocator, lastFilesTitleLocator);
        return this;
    }

    public NavigationBlockPage checkFilesBlock() {
        String filesLocator = "//*[@title='Файлы']";
        String filesTitleLocator = "//*[@class='listing-heading__title']";
        selectFolderAndGetBlockTitle(filesLocator, filesTitleLocator);
        return this;
    }

    public NavigationBlockPage checkFotoBlock() {
        String fotoLocator = "//*[@title='Фото']";
        selectFolderAndGetBlockTitle(fotoLocator, FOLDER_TITLE_LOCATOR);
        return this;
    }

    public NavigationBlockPage checkAlbumsBlock() {
        String albumsLocator = "//*[@title='Альбомы']";
        selectFolderAndGetBlockTitle(albumsLocator, FOLDER_TITLE_LOCATOR);
        return this;
    }

    public NavigationBlockPage checkSharedBlock() {
        String sharedLocator = "//*[@title='Общий доступ']";
        selectFolderAndGetBlockTitle(sharedLocator, FOLDER_TITLE_LOCATOR);
        return this;
    }

    public NavigationBlockPage checkHistoryBlock() {
        String historyLocator = "//*[@title='История']";
        String histiryBlockTitleLocator = "//*[contains(@class,'journal-filter')]//child::h1";
        selectFolderAndGetBlockTitle(historyLocator, histiryBlockTitleLocator);
        return this;
    }

    public NavigationBlockPage checkArchiveBlock() {
        String archiveLocator = "//*[@title='Архив']";
        String archiveBlockTitleLocator = "//*[contains(@class,'listing-heading')]//child::h1";
        selectFolderAndGetBlockTitle(archiveLocator, archiveBlockTitleLocator);
        return this;
    }

    public NavigationBlockPage checkGarbageBlock() {
        String garbageLocator = "//*[@id='/trash']";
        String garbageBlockTitleLocator = "//*[contains(@class,'listing-heading')]//child::h1";
        selectFolderAndGetBlockTitle(garbageLocator, garbageBlockTitleLocator);
        return this;
    }

    private void selectFolderAndGetBlockTitle(String folderLocator, String titleLocator) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(folderLocator)));
        driver.findElement(By.xpath(folderLocator)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(titleLocator)));
        getRealTitlesOfBlock.add(driver.findElement(By.xpath(titleLocator)).getText());
    }
}