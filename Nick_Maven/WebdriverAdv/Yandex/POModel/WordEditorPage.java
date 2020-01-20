package Nick_Maven.WebdriverAdv.Yandex.POModel;

import Nick_Maven.WebdriverAdv.CustomConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordEditorPage extends AbstractPage{
    private Actions actions;
    public static final String textSendingToWordEditor = "Hello Word Editor! It's like in desktop MS Office =)";
    private static final String wordFileName = "wordFileName";


    public WordEditorPage() {
        super();
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


}
