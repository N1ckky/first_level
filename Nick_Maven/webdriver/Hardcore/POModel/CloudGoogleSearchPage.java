package Nick_Maven.webdriver.Hardcore.POModel;

import Nick_Maven.webdriver.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleSearchPage {
    private WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;

    public CloudGoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='gs-title' and @href='https://cloud.google.com/products/calculator/']")
    private WebElement chooseSearchLink;

    public CloudGooglePlatformPricingCalculatorPage chooseSearchResult() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        chooseSearchLink.click();
        return new CloudGooglePlatformPricingCalculatorPage(driver);
    }

}
