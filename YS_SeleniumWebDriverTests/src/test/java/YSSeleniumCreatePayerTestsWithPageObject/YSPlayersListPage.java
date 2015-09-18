package YSSeleniumCreatePayerTestsWithPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Евгений on 17.09.2015.
 */
public class YSPlayersListPage {



    public WebDriver driver;

    public YSPlayersListPage(WebDriver driver) {
        this.driver=driver;
    }

    public void waitForInsertElement(){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Insert")));
    }

    public void waitForUserNameElement() {
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='723a925886__login']")));
    }



    public void clickInsert() {

        driver.findElement(By.linkText("Insert")).click();
    }

    public void setUserNameField(String userNameField) {
        driver.findElement(By.xpath("//input[@id='723a925886__login']")).sendKeys(userNameField);
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath("//input[@value='Search']")).click();
    }

    public void clickEditButton(){
        driver.findElement(By.cssSelector("img[alt='Edit']")).click();
    }
}
