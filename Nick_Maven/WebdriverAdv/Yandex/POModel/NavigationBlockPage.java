package Nick_Maven.WebdriverAdv.Yandex.POModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class NavigationBlockPage {

    private WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    public static boolean navigationBlockTitlesAsExpected = false;

    private static final String EXPECTED_LAST_FILES_TAG = "Последние файлы";
    private static final String EXPECTED_FILES_TAG = "Файлы";
    private static final String EXPECTED_FOTO_TAG = "Все фотографии";
    private static final String EXPECTED_ALBUM_TAG = "Альбомы";
    private static final String EXPECTED_SHARED_TAG = "Публичные ссылки";
    private static final String EXPECTED_HISTORY_TAG = "История";
    private static final String EXPECTED_ARCHIVE_TAG = "Архив";
    private static final String EXPECTED_GARBAGE_TAG = "Корзина";
    private static final String FOLDER_TITLE_LOCATOR = "//*[contains(@class,'listing-stub__desc')]//child::h1";
    private Actions actions;
    private static ArrayList<String> realTitlesOfBlock = new ArrayList<>();


    public NavigationBlockPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public NavigationBlockPage checkLastFilesBlock() {
        String lastFilesLocator = "//*[@title='Последние']";
        String lastFilesTitleLocator = "//*[@title='Последние файлы']";
        getFolderBlockTitle(lastFilesLocator,lastFilesTitleLocator);
        return this;
    }

    public NavigationBlockPage checkFilesBlock() {
        String filesLocator = "//*[@title='Файлы']";
        String filesTitleLocator = "//*[@class='listing-heading__title']";
        getFolderBlockTitle(filesLocator,filesTitleLocator);
        return this;
    }

    public NavigationBlockPage checkFotoBlock() {
        String fotoLocator = "//*[@title='Фото']";
        getFolderBlockTitle(fotoLocator,FOLDER_TITLE_LOCATOR);
        return this;
    }

    public NavigationBlockPage checkAlbumsBlock() {
        String albumsLocator = "//*[@title='Альбомы']";
        getFolderBlockTitle(albumsLocator,FOLDER_TITLE_LOCATOR);
        return this;
    }

    public NavigationBlockPage checkSharedBlock() {
        String sharedLocator = "//*[@title='Общий доступ']";
        getFolderBlockTitle(sharedLocator,FOLDER_TITLE_LOCATOR);
        return this;
    }

    public NavigationBlockPage checkHistoryBlock() {
        String historyLocator = "//*[@title='История']";
        String histiryBlockTitleLocator = "//*[contains(@class,'journal-filter')]//child::h1";
        getFolderBlockTitle(historyLocator,histiryBlockTitleLocator);
        return this;
    }

    public NavigationBlockPage checkArchiveBlock() {
        String archiveLocator = "//*[@title='Архив']";
        String archiveBlockTitleLocator = "//*[contains(@class,'listing-heading')]//child::h1";
        getFolderBlockTitle(archiveLocator,archiveBlockTitleLocator);
        return this;
    }

    public NavigationBlockPage checkGarbageBlock() {
        String garbageLocator = "//*[@id='/trash']";
        String garbageBlockTitleLocator = "//*[contains(@class,'listing-heading')]//child::h1";
        getFolderBlockTitle(garbageLocator,garbageBlockTitleLocator);
        return this;
    }

    private void getFolderBlockTitle(String folderLocator, String titleLocator) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(folderLocator)));
        driver.findElement(By.xpath(folderLocator)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(titleLocator)));
        realTitlesOfBlock.add(driver.findElement(By.xpath(titleLocator)).getText());
    }

    public NavigationBlockPage titleComparisonBlock() {
        ArrayList<String> expectedTitlesOfBlock = new ArrayList<>();
        expectedTitlesOfBlock.add(EXPECTED_LAST_FILES_TAG);
        expectedTitlesOfBlock.add(EXPECTED_FILES_TAG);
        expectedTitlesOfBlock.add(EXPECTED_FOTO_TAG);
        expectedTitlesOfBlock.add(EXPECTED_ALBUM_TAG);
        expectedTitlesOfBlock.add(EXPECTED_SHARED_TAG);
        expectedTitlesOfBlock.add(EXPECTED_HISTORY_TAG);
        expectedTitlesOfBlock.add(EXPECTED_ARCHIVE_TAG);
        expectedTitlesOfBlock.add(EXPECTED_GARBAGE_TAG);
        navigationBlockTitlesAsExpected = realTitlesOfBlock.equals(expectedTitlesOfBlock);
        System.out.println("All navigation titles are as expected: " + navigationBlockTitlesAsExpected);
        return this;
    }

}
