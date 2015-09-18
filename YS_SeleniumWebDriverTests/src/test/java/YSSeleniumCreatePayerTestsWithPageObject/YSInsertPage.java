package YSSeleniumCreatePayerTestsWithPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Евгений on 17.09.2015.
 */
public class YSInsertPage {
    public WebDriver driver;

    public YSInsertPage(WebDriver driver) {
        this.driver=driver;
    }


     public void waitForUserNameField(){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#ff14642ac1c__us_login")));
    }

    public void setUsernameField(String usernameField) {
        driver.findElement(By.cssSelector("input#ff14642ac1c__us_login")).sendKeys(usernameField);
    }

    public void setEmailField(String emailField) {
        driver.findElement(By.cssSelector("input#ff14642ac1c__us_email")).sendKeys(emailField);
    }

    public void setPasswordField(String passwordField) {
        driver.findElement(By.cssSelector("input#ff14642ac1c__us_password")).sendKeys(passwordField);
    }

    public void setPasswordConfirmField(String passwordConfirmField) {
        driver.findElement(By.cssSelector("input#ff14642ac1c__confirm_password")).sendKeys(passwordConfirmField);
    }

    public void setPhoneField(String phoneField) {
        driver.findElement(By.cssSelector("input#ff14642ac1c__us_phone")).sendKeys(phoneField);
    }

    public void clickOnSaveButton() {
        driver.findElement(By.xpath("//input[@value='Save']")).click();
    }

    public String getUserNameActualValue() {
        return driver.findElement(By.cssSelector("input#ff14642ac1c__us_login")).getAttribute("value");
    }

    public String getEmailActualValue() {
        return driver.findElement(By.cssSelector("input#ff14642ac1c__us_email")).getAttribute("value");
    }

    public String getPhoneActualValue() {
        return driver.findElement(By.cssSelector("input#ff14642ac1c__us_phone")).getAttribute("value");
    }

    public String getGenderActualValue() {
        return new Select(driver.findElement(By.cssSelector("select#ff14642ac1c__us_gender"))).getFirstSelectedOption().getText();
    }



}
