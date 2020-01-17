package Nick_Maven.WebdriverAdv.Yandex.POModel;

import Nick_Maven.WebdriverAdv.CustomConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordEditorPage {
    private WebDriver driver;
    private Actions actions;
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    private static final String textSendingToWordEditor = "Hello Word Editor! It's like in desktop MS Office =)";
    public static boolean checkTextInTheWordDocument;
    private static final String wordFileName = "wordFileName";


    public WordEditorPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public WordEditorPage sendTextToWordEditor() {
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jsReadyStateCompleted());
        String editorFieldId = "//*[@id='WACViewPanel_EditingElement']";
        driver.findElement(By.xpath(editorFieldId)).sendKeys(textSendingToWordEditor);
        System.out.println("Text to word sended");
        return this;
    }

    public WordEditorPage setWordFileName() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jsReadyStateCompleted());
        String fileMenuField = "//*[@type='button' and contains(@class,'root-53')]";
        String fileMainField = "//*[@type='button' and @id='Home']";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(fileMainField)));
        actions.moveToElement(driver.findElement(By.xpath(fileMainField))).click().build().perform();
        actions.moveToElement(driver.findElement(By.xpath(fileMenuField))).click().build().perform();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jsReadyStateCompleted());
        String renameOption = "//*[@id='jbtnRenameDialog-Menu48']";
        actions.moveToElement(driver.findElement(By.xpath(renameOption))).click().build().perform();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jsReadyStateCompleted());
        String fileNameField = "//*[@id='txtDocumentName']";
        driver.findElement(By.xpath(fileNameField)).sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        driver.switchTo().activeElement().sendKeys(wordFileName);
        String okButton = "//*[@id='WACDialogActionButton']";
        driver.findElement(By.xpath(okButton)).click();
        System.out.println("Word file name edited. Name is: " + wordFileName);
        return this;
    }

    protected String getValue(WebElement element) {
        try {
            String value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);
            return value;
        } catch (Exception e) {
            return "can't get text";
        }
    }

    public WordEditorPage checkTextInWordEditor() {
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
        System.out.println(textSendingToWordEditor);
        System.out.println(textFromEditor);
        System.out.println("!!!");
        checkTextInTheWordDocument = textSendingToWordEditor.equals(textFromEditor);
        System.out.println("Sended text and text from word are equals: " + checkTextInTheWordDocument);
        return this;
    }
}
