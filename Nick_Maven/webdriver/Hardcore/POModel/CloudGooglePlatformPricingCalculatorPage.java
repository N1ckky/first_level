package Nick_Maven.webdriver.Hardcore.POModel;

import Nick_Maven.webdriver.CustomConditions;
import org.openqa.selenium.By;
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
    private static WebElement IFRAME;

    private static final String JS_CLICK = "arguments[0].click();";
    private static final String TAG_IFRAME = "iframe";
    private static final String NUMBER_OF_INSTANCES = "4";

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

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//label[text()='Email ']")
    private WebElement emailInsertLable;

    @FindBy(xpath = "//*[contains(@ng-model,'.email')]")
    private WebElement emailInsertField;

    @FindBy(xpath = "//button[@type= 'button' and @aria-label='Send Email']")
    private WebElement buttonSendEmail;


    CloudGooglePlatformPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXCallsHaveCompleted());
        IFRAME = driver.findElement(By.tagName(TAG_IFRAME));
        driver.switchTo().frame(IFRAME);
    }

    public CloudGooglePlatformPricingCalculatorPage selectComputeEngineSection() {
        computeEngineSection.get(0).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage setNumberOfInstances() {
        numberOfInstancesField.sendKeys(NUMBER_OF_INSTANCES);
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectOSAndSoftware() {
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, chooseOSAndSoftwareField);
        listOfOSAndSoftware.get(0).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage selectMachineClass() {
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, chooseMachineClassField);
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
        checkBoxesComputeEngineSection.get(0).click();
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, selectNumberOfGPUsField);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(listNumbeOfGPUs.get(1)));
        listNumbeOfGPUs.get(1).click();
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, selectGPUTypeField);
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

    public CloudGooglePlatformPricingCalculatorPage selectCommittedUsage() {
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, selectCommitedUsageField);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(listOfCommitedUsage.get(1)));
        listOfCommitedUsage.get(1).click();
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage clickButtonAddToEstimate() {
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, buttonAddToEstimate);
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage addToListTotalAmountPrice(List tempList) {
        tempList.add(listOfEstimate.get(6).getText()
                .substring(listOfEstimate.get(6).getText().indexOf("USD") + 4, listOfEstimate.get(6).getText().indexOf("per") - 1));
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage clickButtonEmailEstimate() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(buttonEmailEstimate));
        buttonEmailEstimate.click();
        return this;
    }


    public CloudGooglePlatformPricingCalculatorPage insertEmailEstimate(String generatedEmail) {
        driver.switchTo().frame(IFRAME);
        ((JavascriptExecutor) driver).executeScript(JS_CLICK, emailInsertLable);
        emailInsertField.sendKeys(generatedEmail);
        return this;
    }

    public CloudGooglePlatformPricingCalculatorPage sendEmail() {
        if (buttonSendEmail.isEnabled()) {
            buttonSendEmail.click();
        }
        return this;
    }
}

