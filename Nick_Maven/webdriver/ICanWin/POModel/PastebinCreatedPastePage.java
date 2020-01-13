package Nick_Maven.webdriver.ICanWin.POModel;

import Nick_Maven.webdriver.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinCreatedPastePage {
    private WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    private static String textForPaste;
    private static String pasteTitle;
    private boolean checkFlag = false;

    @FindBy(xpath = "//textarea[@id ='paste_code' and @class='paste_code']")
    private WebElement pasteTextField;

    @FindBy(xpath = "//div[@class='paste_box_line1']")
    private WebElement pasteTitleField;

    PastebinCreatedPastePage(WebDriver driver, String pasteText, String pasteTitle) {
        this.driver = driver;
        textForPaste = pasteText;
        this.pasteTitle = pasteTitle;
        PageFactory.initElements(driver,this);
    }

    public boolean createdPasteCheck() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        if (pasteTextField.getText().equals(textForPaste) && pasteTitleField.getText().equals(pasteTitle)){
            this.checkFlag=true;
        }
        System.out.println("DEBUG check condition "+checkFlag);
        return checkFlag;
    }

}
