package Nick_Maven.webdriver.Hardcore.POModel;

import Nick_Maven.webdriver.CustomConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TenMinuteMailHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://10minutemail.com/";
    public static final int WAIT_TIMEOUT_SECONDS = 60;
    private static String GENERATED_EMAIL;

    @FindBy(xpath = "//input[@id='mailAddress']")
    private WebElement generatedEmailField;

    @FindBy(xpath = "//*[@id='ui-id-1']")
    private WebElement receivedEmailField;

    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement priceCheckField;


    public TenMinuteMailHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TenMinuteMailHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        return this;
    }

    public String copyGeneratedEmail() {
        this.scrollToElement(generatedEmailField);
        GENERATED_EMAIL = generatedEmailField.getAttribute("value");
        return GENERATED_EMAIL;
    }

    private void scrollToElement(WebElement whereToScroll) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whereToScroll);
    }

    public TenMinuteMailHomePage checkReceivedEmail() {

        driver.navigate().refresh();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElements(receivedEmailField));
        this.scrollToElement(receivedEmailField);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", receivedEmailField);
        return this;
    }

    public TenMinuteMailHomePage addToListTotalAmountPrice(List tempList) {
        String receivedEmailTotalAmount = priceCheckField.getAttribute("innerText");
        tempList.add(receivedEmailTotalAmount.substring(receivedEmailTotalAmount.indexOf("USD")+4));
        return this;
    }

}
