package Nick_Maven.WebdriverAdv.Yandex.pages;

import Nick_Maven.WebdriverAdv.Yandex.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexDiskLoginPage extends AbstractPage{

    public YandexDiskLoginPage() {
        super();
    }

    public NavigationBlockPage userLogin(User user) {
        String buttonLogin = "//*[contains(@class,'button_login')]";
        String loginField = "passp-field-login";
        String buttonForPassword = "//*[(contains(@class,'passp-button passp-sign-in-button'))]";
        String passwordField = "passp-field-passwd";
        String buttonSubmit = "//*[(contains(@class,'button2_type_submit'))]";

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(buttonLogin)));
        driver.findElement(By.xpath(buttonLogin)).click();
        driver.findElement(By.id(loginField)).sendKeys(user.getUserLogin());
        driver.findElement(By.xpath(buttonForPassword)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.id(passwordField)));
        driver.findElement(By.id(passwordField)).sendKeys(user.getUserPassword());
        driver.findElement(By.xpath(buttonSubmit)).click();
        System.out.println("Successful log in");

        return new NavigationBlockPage();
    }
}