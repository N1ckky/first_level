package Nick_Maven.WebdriverAdv.Yandex.service;

import Nick_Maven.WebdriverAdv.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Nick_Maven.WebdriverAdv.Yandex.pages.YandexDiskFilesPage.*;

public class YandexDiscService {
    protected static WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    public static boolean checkFolderName;
    public static boolean checkWordFileExist;


    public static boolean checkIsWordFileExist() {
        driver = DriverService.getDriver();
        driver.navigate().refresh();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jsReadyStateCompleted());
        String searchWordFileLocator = FILE_LOCATOR_PATTERN;
        checkWordFileExist = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(searchWordFileLocator))).isDisplayed();
        System.out.println("Is the Word file exist: " + checkWordFileExist);
        return checkWordFileExist;
    }

    public static boolean checkFolderName() {
        checkFolderName = folderName.equals(realFolderName);
        System.out.println(folderName);
        System.out.println(realFolderName);
        return checkFolderName;
    }

    public static boolean checkFileNotInFilesFolder() {
        String searchWordFileLocator = FILE_LOCATOR_PATTERN;
        return checkerFileInCurrentFolder(searchWordFileLocator, "FILES");
    }

    public static boolean checkFileIsInGarbage() {
        String searchWordFileLocator = FILE_LOCATOR_PATTERN;
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(searchWordFileLocator)));
        return checkerFileInCurrentFolder(searchWordFileLocator, "GARBAGE");
    }

    public static boolean checkFileNotInGarbage() {
        String searchWordFileLocator = FILE_LOCATOR_PATTERN;
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(searchWordFileLocator)));
        return checkerFileInCurrentFolder(searchWordFileLocator, "GARBAGE");
    }

    private static  boolean checkerFileInCurrentFolder(String searchWordFileLocator, String folderTitle) {
        driver = DriverService.getDriver();
        String setFolderName = String.format("File in %s folder: ", folderTitle);
        try {
            driver.findElement(By.xpath(searchWordFileLocator));
            System.out.println(setFolderName + true);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println(setFolderName + false);
            return false;
        }
    }
}