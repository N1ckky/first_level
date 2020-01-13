package Nick_Maven.webdriver.ICanWin.POModel;

import Nick_Maven.webdriver.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com ";
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    private static String textForPaste;
    private static String pasteTitle;

    @FindBy(id = "paste_code")
    private WebElement pasteTextField;

    @FindBy(xpath = "//span[@class='select2-selection__rendered' and contains(@id, 'select2-paste_expire_date')]")
    private WebElement pasteExpirationSwitch;

    @FindBy(xpath = "//*[@class='select2-results__option' and text()='10 Minutes']")
    private WebElement pasteExpirationForTenMin;

    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement setPasteTitle;

    @FindBy(xpath = "//input[@type='submit' and @value='Create New Paste']")
    private WebElement createNewPasteBtn;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        return this;
    }

    public PastebinHomePage writingPasteText(String newPasteText) {
        textForPaste = newPasteText;
        pasteTextField.sendKeys(newPasteText);
        return this;
    }

    public PastebinHomePage setPasteExpirationForTenMin() {
        pasteExpirationSwitch.click();
        pasteExpirationForTenMin.click();
        return this;
    }

    public PastebinHomePage setPasteTitle(String pasteTitle) {
        this.pasteTitle=pasteTitle;
        setPasteTitle.sendKeys(pasteTitle);
        return this;
    }

    public PastebinCreatedPastePage createNewPaste() {
        createNewPasteBtn.click();
        return new PastebinCreatedPastePage(driver, textForPaste,pasteTitle);
    }
}
