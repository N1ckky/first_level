package Nick_Maven.webdriver.Hardcore.Test;

import Nick_Maven.webdriver.Hardcore.POModel.BrowserParams;
import Nick_Maven.webdriver.Hardcore.POModel.CloudGoogleHomePage;
import Nick_Maven.webdriver.Hardcore.POModel.CloudGooglePlatformPricingCalculatorPage;
import Nick_Maven.webdriver.Hardcore.POModel.TenMinuteMailHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Hardcore {
    private WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Google cloud calculator and email estimate test")
    public void createEmailReceptionTotalAmountTest() {
        ArrayList<String> tempList = new ArrayList<>();
        BrowserParams browser = new BrowserParams(driver);

        CloudGooglePlatformPricingCalculatorPage cloudGooglePricingCalculatorTest = new CloudGoogleHomePage(driver)
                .openPage()
                .makeSearch("Google Cloud Platform Pricing Calculator")
                .chooseSearchResult()
                .selectComputeEngineSection()
                .setNumberOfInstances()
                .selectOSAndSoftware()
                .selectMachineClass()
                .selectMachineType()
                .addGPUs()
                .selectLocalSSD()
                .selectDataCenterLocation()
                .selectCommittedUsage()
                .clickButtonAddToEstimate()
                .addToListTotalAmountPrice(tempList)
                .clickButtonEmailEstimate();

        browser.openNewTab().switchNextTab();

        TenMinuteMailHomePage tenMinuteMail = new TenMinuteMailHomePage(driver);
        String generatedEmail = tenMinuteMail
                .openPage().copyGeneratedEmail();
        System.out.println("DEBUG: check generated Email " + generatedEmail);
        browser.switchPrevTab();
        cloudGooglePricingCalculatorTest.insertEmailEstimate(generatedEmail)
                .sendEmail();
        browser.switchNextTab();

        tenMinuteMail.checkReceivedEmail().addToListTotalAmountPrice(tempList);

        for (String s : tempList) {
            System.out.println("DEBUG: check received total price " + s);
        }

        Assert.assertEquals(tempList.get(0), tempList.get(1));
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
