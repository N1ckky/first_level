package Nick_Maven.webdriver.HurtMePlenty.POModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CloudGooglePlatformPricingCalculatorPage {
    private WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    private boolean checkFlag = false;
    private static final String JS_CLICK = "arguments[0].click();";

    private static final String EXPECTED_VM_CLASS = "regular";
    private static final String EXPECTED_INSTANCE = "n1-standard-8";
    private static final String EXPECTED_REGION = "Frankfurt";
    private static final String EXPECTED_LOCAL_SSD = "2x375 GB";
    private static final String EXPECTED_COMMITMENT_TERM = "1 Year";
    private static final String EXPECTED_TOTAL_PRICE = "1,082.77";

    @FindBy(xpath = "//*[contains(@class,'presets-buttons')]")
    private List<WebElement> computeEngineSection;

    @FindBy(xpath = "//input[@name='quantity' and @ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//*[@class='md-select-value' and @id='select_value_label_47']")
    private WebElement chooseOSAndSoftwareField;

    @FindBy(xpath = "//div[@id='select_container_67']//child::md-option")
    private List<WebElement> listOfOSAndSoftware;

    @FindBy(xpath = "//*[@class='md-select-value' and @id='select_value_label_48']")
    private WebElement chooseMachineClassField;

    @FindBy(xpath = "//div[@id='select_container_71']//child::md-option")
    private List<WebElement> listOfMachineClass;

    @FindBy(xpath = "//*[@class='md-select-value' and @id='select_value_label_51']")
    private WebElement chooseMachineTypeField;

    @FindBy(xpath = "//md-optgroup[@label='standard']//child::md-option")
    private List<WebElement> listOfMachineType;

    @FindBy(xpath = "//*[@class='md-container md-ink-ripple']")
    private List<WebElement> checkBoxesComputeEngineSection;

    @FindBy(xpath = "//*[@class='md-select-value' and @id='select_value_label_350']")
    private WebElement selectNumberOfGPUsField;

    @FindBy(xpath = "//div[@id='select_container_353']//child::md-option")
    private List<WebElement> listNumbeOfGPUs;

    @FindBy(xpath = "//*[@class='md-select-value' and @id='select_value_label_351']")
    private WebElement selectGPUTypeField;

    @FindBy(xpath = "//div[@id='select_container_355']//child::md-option")
    private List<WebElement> listGPUType;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_172']")
    private WebElement selectLocalSSDField;

    @FindBy(xpath = "//div[@id='select_container_174']//child::md-option")
    private List<WebElement> listOfLocalSSD;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_52']//child::div[@class='md-text ng-binding']")
    private WebElement selectDatacenterlocationField;

    @FindBy(xpath = "//div[@id='select_container_82']//child::md-option")
    private List<WebElement> listOfDatacenterlocation;

    @FindBy(xpath = "//*[@class='md-select-value' and @id='select_value_label_53']")
    private WebElement selectCommitedUsageField;

    @FindBy(xpath = "//div[@id='select_container_89']//child::md-option")
    private List<WebElement> listOfCommitedUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//child::md-list-item")
    private List<WebElement> listOfEstimate;

    CloudGooglePlatformPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.switchTo().frame("myFrame");
    }

    public CloudGooglePlatformPricingCalculatorPage selectComputeEngineSection() {
        computeEngineSection.get(0).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage setNumberOfInstances() {
        numberOfInstancesField.sendKeys("4");
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectOSAndSoftware() {
        chooseOSAndSoftwareField.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(listOfOSAndSoftware.get(0)));
        listOfOSAndSoftware.get(0).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectMachineClass() {
        chooseMachineClassField.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(listOfMachineClass.get(0)));
        listOfMachineClass.get(0).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectMachineType() {
        chooseMachineTypeField.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(listOfMachineType.get(3)));
        listOfMachineType.get(3).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage addGPUs() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(checkBoxesComputeEngineSection.get(0)));
        checkBoxesComputeEngineSection.get(0).click();
        selectNumberOfGPUsField.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(listNumbeOfGPUs.get(1)));
        listNumbeOfGPUs.get(1).click();
        selectGPUTypeField.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(listGPUType.get(3)));
        listGPUType.get(3).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectLocalSSD() {
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, selectLocalSSDField);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(listOfLocalSSD.get(2)));
        listOfLocalSSD.get(2).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectDataCenterLocation() {
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, selectDatacenterlocationField);
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, listOfDatacenterlocation.get(7));
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectCommitedUsage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(selectCommitedUsageField));
        selectCommitedUsageField.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(listOfCommitedUsage.get(1)));
        listOfCommitedUsage.get(1).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage clickButtonAddToEstimate() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(buttonAddToEstimate));
        buttonAddToEstimate.click();
        return this;
    }

    public boolean listEstimateCheck() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfAllElements(listOfEstimate));
        String myPrice = listOfEstimate.get(6).getText()
                .substring(listOfEstimate.get(6).getText().indexOf("USD") + 4, listOfEstimate.get(6).getText().indexOf("per") - 1);

        String myInstance = listOfEstimate.get(2).getText().substring(listOfEstimate.get(2).getText().indexOf(":") + 2);
        String myVmClass = listOfEstimate.get(1).getText().substring(listOfEstimate.get(1).getText().indexOf(":") + 2);
        String myRegion = listOfEstimate.get(3).getText().substring(listOfEstimate.get(3).getText().indexOf(":") + 2);
        String mySSD = listOfEstimate.get(4).getText().substring(listOfEstimate.get(4).getText().indexOf("space") + 6);
        String myCommitmentTerm = listOfEstimate.get(5).getText().substring(listOfEstimate.get(5).getText().indexOf(":") + 2);

        if (myVmClass.equals(EXPECTED_VM_CLASS)
                && myInstance.equals(EXPECTED_INSTANCE)
                && myRegion.equals(EXPECTED_REGION)
                && mySSD.equals(EXPECTED_LOCAL_SSD)
                && myCommitmentTerm.equals(EXPECTED_COMMITMENT_TERM)
                && myPrice.equals(EXPECTED_TOTAL_PRICE)) {
            this.checkFlag = true;
        }
        System.out.println("DEBUG check condition " + checkFlag);
        return checkFlag;
    }
}

