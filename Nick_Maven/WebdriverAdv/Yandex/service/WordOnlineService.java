package Nick_Maven.WebdriverAdv.Yandex.service;

import Nick_Maven.WebdriverAdv.CustomConditions;
import Nick_Maven.WebdriverAdv.Yandex.pages.WordEditorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordOnlineService {
    protected static WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    public static boolean checkTextInTheWordDocument;

    protected static String getValue(WebElement element) {
        try {
            String value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);
            return value;
        } catch (Exception e) {
            return "can't get text";
        }
    }

    public static boolean checkTextInWordEditor() {
        driver = DriverService.getDriver();
        driver.navigate().refresh();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jsReadyStateCompleted());
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jsReadyStateCompleted());

        String editorFieldId = "WACViewPanel_EditingElement";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.id(editorFieldId)));

        String textFromEditor = getValue(driver.findElement(By.id(editorFieldId)));
        if (textFromEditor.contains("’")) {
            textFromEditor = (textFromEditor.substring(1, textFromEditor.length() - 1)).replace('’', '\'');
        } else textFromEditor = (textFromEditor.substring(1, textFromEditor.length() - 1));
        System.out.println("!!!");
        System.out.println(WordEditorPage.TEXT_SENDING_TO_WORD_EDITOR);
        System.out.println(textFromEditor);
        System.out.println("!!!");
        checkTextInTheWordDocument = WordEditorPage.TEXT_SENDING_TO_WORD_EDITOR.equals(textFromEditor);
        System.out.println("Sended text and text from word are equals: " + checkTextInTheWordDocument);
        return checkTextInTheWordDocument;
    }
}