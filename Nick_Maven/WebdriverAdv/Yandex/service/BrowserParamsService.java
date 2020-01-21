package Nick_Maven.WebdriverAdv.Yandex.service;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BrowserParamsService {
    private static WebDriver driver;
    private static ArrayList<String> tabs;

    public BrowserParamsService() {
        driver = DriverService.getDriver();
    }

    public BrowserParamsService switchTab(int tabNumber) {
        driver.switchTo().window(tabs.get(tabNumber));
        return this;
    }

    public BrowserParamsService getAllOppenedTabs() {
        tabs = new ArrayList<String>(driver.getWindowHandles());
        return this;
    }
}