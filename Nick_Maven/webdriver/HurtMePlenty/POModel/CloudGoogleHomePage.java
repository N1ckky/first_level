package Nick_Maven.webdriver.HurtMePlenty.POModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGoogleHomePage {
    private WebDriver driver;
    public static final String HOMEPAGE_URL = "https://cloud.google.com/";
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    public static String TEXT_FOR_SEARCH;



    @FindBy(xpath = "//*[@class='button button-white devsite-suggest-all-results']")
    private WebElement choseSearchBtn;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchField;

    public CloudGoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CloudGoogleSearchPage makeSearch(String searchText) {
        this.TEXT_FOR_SEARCH = searchText;
        searchField.sendKeys(searchText);
        choseSearchBtn.click();
        return new CloudGoogleSearchPage(driver);
    }
}
