package YS_SeleniumCreatePlayerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Евгений on 12.09.2015.
 */
public class YS_CreatePlayerTests {
    @Test
    public  static void CreatePlayer() throws InterruptedException {

       final WebDriver driver = new FirefoxDriver();


       /* Login*/


        driver.get("http://193.138.245.222:81/auth/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("logIn")).click();


        Thread.sleep(1000);
        /* Login*/

        /* CreatePlayerTests*/
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        String UserName = "UN"+String.valueOf(dateFormat.format(date));
        String Password = "Password1";
        String Email = UserName + "@mail.ru";
        String Phone = "123456";

      /*  System.out.println(s);*/



        driver.findElement(By.linkText("Insert")).click();
        driver.findElement(By.cssSelector("input#ff14642ac1c__us_login")).sendKeys(UserName);
        driver.findElement(By.cssSelector("input#ff14642ac1c__us_email")).sendKeys(Email);
        driver.findElement(By.cssSelector("input#ff14642ac1c__us_password")).sendKeys(Password);
        driver.findElement(By.cssSelector("input#ff14642ac1c__confirm_password")).sendKeys(Password);
        driver.findElement(By.cssSelector("input#ff14642ac1c__us_phone")).sendKeys(Phone);
        driver.findElement(By.xpath("//input[@value='Save']")).click();

        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@id='723a925886__login']")).sendKeys(UserName);
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        driver.findElement(By.cssSelector("img[alt='Edit']")).click();


        String UserNameField = driver.findElement(By.cssSelector("input#ff14642ac1c__us_login")).getAttribute("value");
        String EmailField = driver.findElement(By.cssSelector("input#ff14642ac1c__us_email")).getAttribute("value");
        String PhoneField = driver.findElement(By.cssSelector("input#ff14642ac1c__us_phone")).getAttribute("value");

        String selectedOption = new Select(driver.findElement(By.cssSelector("select#ff14642ac1c__us_gender"))).getFirstSelectedOption().getText();



        Assert.assertEquals(UserNameField, UserName);
        Assert.assertEquals(EmailField, Email);
        Assert.assertEquals(PhoneField, Phone);
        Assert.assertEquals(selectedOption, "Male");




        /* CreatePlayerTests*/




        driver.close();

    }
}
