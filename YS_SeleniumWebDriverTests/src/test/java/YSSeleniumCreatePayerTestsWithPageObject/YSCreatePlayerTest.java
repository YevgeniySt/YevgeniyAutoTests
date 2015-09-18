package YSSeleniumCreatePayerTestsWithPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Евгений on 17.09.2015.
 */
public class YSCreatePlayerTest {
    WebDriver driver;

    @BeforeTest
    public void openSite(){
        driver =  new FirefoxDriver();
        driver.get("http://193.138.245.222:81/auth/login");
    }



    @Test
    public void createPlayerTest() throws InterruptedException {

        //create expected values
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        String userNameExpected = "UN" + String.valueOf(dateFormat.format(date));
        String passwordExpected = "Password1";
        String emailExpected = userNameExpected + "@mail.ru";
        String phoneExpected = "123456";
        String genderExpected = "Male";


        //create instance of the login page
        YSLoginPage loginPage = new YSLoginPage(driver);

        //Fill data and login
        loginPage.setUserNameField("admin");
        loginPage.setPasswordField("123");
        loginPage.clickOnLogin();

        //create instance of players list page and wait for players list page
        YSPlayersListPage playersListPage = new YSPlayersListPage(driver);
        playersListPage.waitForInsertElement();

        //click Insert
        playersListPage.clickInsert();

        //create instance of Insert Page and wait for Insert page
        YSInsertPage insertPage = new YSInsertPage(driver);
        insertPage.waitForUserNameField();

        //fill fields on Insert page and click Save
        insertPage.setUsernameField(userNameExpected);
        insertPage.setEmailField(emailExpected);
        insertPage.setPasswordField(passwordExpected);
        insertPage.setPasswordConfirmField(passwordExpected);
        insertPage.setPhoneField(phoneExpected);
        insertPage.clickOnSaveButton();

        //wait for players list page
        playersListPage.waitForUserNameElement();

        //set username for search anc click search
        playersListPage.setUserNameField(userNameExpected);
        playersListPage.clickSearchButton();

        //wait and click Edit
        Thread.sleep(2000);
        playersListPage.clickEditButton();


        //get players values
        String userNameActualValue = insertPage.getUserNameActualValue();
        String emailActualValue = insertPage.getEmailActualValue();
        String phoneActualValue = insertPage.getPhoneActualValue();
        String genderActualValue = insertPage.getGenderActualValue();

        //check values
        Assert.assertEquals(userNameActualValue, userNameExpected);
        Assert.assertEquals(emailActualValue, emailExpected);
        Assert.assertEquals(phoneActualValue, phoneExpected);
        Assert.assertEquals(genderActualValue, genderExpected);

    }
    @AfterTest
    public void closeSite(){
        driver.close();
    }


}
