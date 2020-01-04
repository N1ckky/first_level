package Nick_Maven.webdriver.BringItOn.POModel;

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
    private static final String SYNTAX_HIGHLIGHTING_BASH = "Bash";
    private boolean checkFlag = false;

    @FindBy(xpath = "//textarea[@id ='paste_code' and @class='paste_code']")
    private WebElement pasteTextField;

    @FindBy(xpath = "//div[@class='paste_box_line1']")
    private WebElement pasteTitleField;

    @FindBy(xpath = "//a[@class='buttonsm' and text()='Bash']")
    private WebElement checkSyntaxHighlightingChosenAsBashField;

    PastebinCreatedPastePage(WebDriver driver, String pasteText, String pasteTitle) {
        this.driver = driver;
        textForPaste = pasteText;
        this.pasteTitle = pasteTitle;
        PageFactory.initElements(driver, this);
    }

    public boolean createdPasteCheck() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        if (pasteTextField.getText().equals(textForPaste) && pasteTitleField.getText().equals(pasteTitle) && checkSyntaxHighlightingChosenAsBashField.getText().equals(SYNTAX_HIGHLIGHTING_BASH)) {
            this.checkFlag = true;
        }
        System.out.println("DEBUG check condition " + checkFlag);
        return checkFlag;
    }
}
