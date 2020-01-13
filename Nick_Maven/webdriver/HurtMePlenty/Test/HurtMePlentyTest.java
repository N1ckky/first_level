package Nick_Maven.webdriver.HurtMePlenty.Test;

import Nick_Maven.webdriver.HurtMePlenty.POModel.CloudGoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HurtMePlentyTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Google cloud calculator")
    public void cloudGoogleSelectedOptionTest() {
        boolean newCloudGooglePlatformPricingCalculatorTest = new CloudGoogleHomePage(driver)
                .openPage()
                .makeSearch("Google Cloud Platform Pricing Calculator")
                .chooseSearchResult()
                .selectComputeEngineSection()
                .setNumberOfInstances()
                .selectOSAndSoftware()
                .selectMachineClass()
                .selectMachineType()
                .addGPUs()
                .selectDataCenterLocation()
                .selectLocalSSD()
                .selectCommitedUsage()
                .clickButtonAddToEstimate()
                .listEstimateCheck();

        Assert.assertTrue(newCloudGooglePlatformPricingCalculatorTest, "Some strings are not equals");
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        new WebDriverWait(driver, 10);
        driver.quit();
        driver = null;
    }
}
