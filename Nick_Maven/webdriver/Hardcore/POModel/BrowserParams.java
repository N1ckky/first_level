package Nick_Maven.webdriver.Hardcore.POModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class BrowserParams {
    private WebDriver driver;
    private ArrayList<String> tabs;

    public BrowserParams(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }
    public BrowserParams switchPrevTab() {
        driver.switchTo().window(tabs.get(0));
        return this;
    }
    public BrowserParams switchNextTab() {
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public BrowserParams openNewTab() {
        ((JavascriptExecutor) driver)
                .executeScript("window.open('about:blank','_blank');");
        this.tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
}
