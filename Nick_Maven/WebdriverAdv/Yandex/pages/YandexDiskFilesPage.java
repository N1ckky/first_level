package Nick_Maven.WebdriverAdv.Yandex.pages;

import Nick_Maven.WebdriverAdv.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Nick_Maven.WebdriverAdv.Yandex.service.RandomStringGenerator.randomStringGenerator;

public class YandexDiskFilesPage extends AbstractPage {
    private Actions actions;
    public static String folderName;
    public static String realFolderName;
    private static final String WORD_FILE_NAME = "wordFileName";
    public static final String FILE_LOCATOR_PATTERN = String.format("//*[@class='clamped-text' and contains(text(),'%s')]", WORD_FILE_NAME);


    public YandexDiskFilesPage() {
        super();
        actions = new Actions(driver);
    }

    public YandexDiskFilesPage openContextMenu() {
        String screenField = "//*[contains(@class,'root__content-inner_page_listing')]";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(screenField)));
        WebElement screenFieldWeb = driver.findElement(By.xpath(screenField));
        actions.moveToElement(screenFieldWeb).contextClick().build().perform();
        return this;
    }

    public YandexDiskFilesPage createNewFolder() {
        String newFolderField = "//*[contains(@class,'context-menu-create-popup__item_new-folder')]";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newFolderField)));
        driver.findElement(By.xpath(newFolderField)).click();
        return this;
    }

    public YandexDiskFilesPage setNewFolderName() {
        folderName = randomStringGenerator();
        String nameField = "//*[@class='rename-dialog__rename-form']//child::input";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameField)));
        driver.findElement(By.xpath(nameField)).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        actions.moveToElement(driver.findElement(By.xpath(nameField))).click().sendKeys(folderName).build().perform();
        String confirmButton = "//*[contains(@class,'confirmation-dialog__button_submit')]";
        driver.findElement(By.xpath(confirmButton)).click();
        System.out.println("Folder with name: " + folderName + " is created");
        return this;
    }

    public YandexDiskFilesPage openCreatedFolder() {
        String nameField = String.format("//*[@class='listing__items']//*[text()= '%s']", folderName);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameField)));
        actions.moveToElement(driver.findElement(By.xpath(nameField))).doubleClick().build().perform();
        String realFolderTitleLocator = String.format("//*[@title='%s']", folderName);
        realFolderName = driver.findElement(By.xpath(realFolderTitleLocator)).getText();

        return this;
    }

    public YandexDiskFilesPage setNameToFolderMustBeOpened(String myFolderName) {
        folderName = myFolderName;
        return this;
    }

    public WordEditorPage createWordFile() {
        String newWordFileField = "//*[contains(@class,'context-menu-create-popup__item_word')]";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(newWordFileField)));
        driver.findElement(By.xpath(newWordFileField)).click();
        System.out.println("Word file created");
        return new WordEditorPage();
    }

    public WordEditorPage checkWordFile() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jsReadyStateCompleted());
        String searchWordFileLocator = FILE_LOCATOR_PATTERN;
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(searchWordFileLocator)));
        actions.moveToElement(driver.findElement(By.xpath(searchWordFileLocator))).doubleClick().build().perform();
        System.out.println("Word file: " + WORD_FILE_NAME + " oppened");
        return new WordEditorPage();
    }

    public YandexDiskFilesPage selectWordFile() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jsReadyStateCompleted());
        String searchWordFileLocator = FILE_LOCATOR_PATTERN;
        System.out.println("Searching word file is exist: " + new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(searchWordFileLocator))).isDisplayed());
        return new YandexDiskFilesPage();
    }

    public YandexDiskFilesPage deleteWordFile() {
        String searchWordFileLocator = String.format("//*[@class='clamped-text' and contains(text(),'%s')]" +
                "//ancestor::div[contains(@class,'listing-item_type_file')]//child::img", WORD_FILE_NAME);
        String garbageLocator = "//*[@title='Корзина']";
        actions.moveToElement(driver.findElement(By.xpath(searchWordFileLocator))).clickAndHold().moveToElement(driver.findElement(By.xpath(garbageLocator))).release().build().perform();
        return new YandexDiskFilesPage();
    }

    public YandexDiskFilesPage clearGarbage() {
        String clearGarbageLocator = "//button[contains(@class,'client-listing__clean-trash-button')]";
        String clearGarbageConfirmButton = "//button[contains(@class,'button2_action_yes')]//child::span[contains(text(),'Очистить')]";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(clearGarbageLocator)));
        driver.findElement(By.xpath(clearGarbageLocator)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(clearGarbageConfirmButton)));
        actions.moveToElement(driver.findElement(By.xpath(clearGarbageConfirmButton))).click().build().perform();
        driver.navigate().refresh();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        return new YandexDiskFilesPage();
    }
}