package YS_SeleniumCreatePlayerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Евгений on 15.09.2015.
 */
public class YS_LoginTests {
    @Test
    public void LoginPositiveTest() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();


        driver.get("http://193.138.245.222:81/auth/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("logIn")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='723a925886__login']")).isDisplayed();

        driver.close();


    }


    @Test
    public void LoginNegativeTest() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();


        driver.get("http://193.138.245.222:81/auth/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("logIn")).click();
        Thread.sleep(3000);

        String ErrorLabel = driver.findElement(By.cssSelector(".errors>li")).getText();


        Assert.assertEquals(ErrorLabel, "Invalid username or password");
        driver.close();


    }

}
