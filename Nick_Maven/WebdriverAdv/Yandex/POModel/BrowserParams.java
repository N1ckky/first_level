package Nick_Maven.WebdriverAdv.Yandex.POModel;

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
    public BrowserParams switchZeroTab() {
        driver.switchTo().window(tabs.get(0));
        return this;
    }
    public BrowserParams switchFirstTab() {
        driver.switchTo().window(tabs.get(1));
        return this;
    }
    public BrowserParams switchSecondTab() {
        driver.switchTo().window(tabs.get(2));
        return this;
    }

    public BrowserParams getAllOppenedTabs() {
        this.tabs = new ArrayList<String>(driver.getWindowHandles());

        return this;
    }
}
