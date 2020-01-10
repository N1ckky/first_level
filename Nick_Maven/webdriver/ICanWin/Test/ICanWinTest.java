package Nick_Maven.webdriver.ICanWin.Test;

import Nick_Maven.webdriver.ICanWin.POModel.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICanWinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "pastebin.com \"Hello from WebDriver\" test")
    public void createNewPasteICanWinTaskTest() {
        boolean newPasteCreatedTest = new PastebinHomePage(driver)
                .openPage()
                .writingPasteText("Hello from WebDriver")
                .setPasteExpirationForTenMin()
                .setPasteTitle("helloweb")
                .createNewPaste()
                .createdPasteCheck();
        Assert.assertTrue(newPasteCreatedTest, "New Paste wasn't created");
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
