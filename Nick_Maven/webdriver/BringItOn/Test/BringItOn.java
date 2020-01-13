package Nick_Maven.webdriver.BringItOn.Test;

import Nick_Maven.webdriver.BringItOn.POModel.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BringItOn {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "pastebin.com test with optional paste settings")
    public void createNewPasteBringItOnTaskTest() {
        boolean newPasteCreatedTest = new PastebinHomePage(driver)
                .openPage()
                .writingPasteText("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .setSyntaxHighlighting()
                .setPasteExpirationForTenMin()
                .setPasteTitle("how to gain dominance among developers")
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
