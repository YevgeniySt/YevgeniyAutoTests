package YSSeleniumCreatePayerTestsWithPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Евгений on 17.09.2015.
 */
public class YSLoginPage {

    public WebDriver driver;

    public YSLoginPage(WebDriver driver) {
        this.driver=driver;
    }


    public void setUserNameField(String userNameField) {
        driver.findElement(By.id("username")).sendKeys(userNameField);

    }


    public void setPasswordField(String passwordField) {
        driver.findElement(By.id("password")).sendKeys(passwordField);

    }

    public void clickOnLogin() {
        driver.findElement(By.id("logIn")).click();
    }


}



