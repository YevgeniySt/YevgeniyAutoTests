package Tests;

import BusinessLogic.AssertCheck;
import Pages.LoginPage;
import Pages.PlayersListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Евгений on 15.09.2015.
 */
public class LoginTests {

    private WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void openSite() {
        driver = new FirefoxDriver();
        driver.get("http://193.138.245.222:81/auth/login");
        loginPage = new LoginPage(driver);
    }


    @Test
    public void LoginPositiveTest() throws InterruptedException {

        loginPage.setUserNameField("admin");
        loginPage.setPasswordField("123");
        PlayersListPage playersListPage = loginPage.clickOnLogin();
        playersListPage.isUserNameDisplayed();
    }


    @Test
    public void LoginNegativeTest() throws InterruptedException {

        loginPage.setUserNameField("admin");
        loginPage.setPasswordField("1234");
        PlayersListPage playersListPage = loginPage.clickOnLogin();
        String expectedErrorLabel = loginPage.getErrorLoginText();

        AssertCheck assertCheck = new AssertCheck(driver);
        assertCheck.assertEquals(expectedErrorLabel, "Invalid username or passord");
        assertCheck.printErrors();



    }

    @AfterMethod
    public void closeSite() {
        driver.close();
    }

}
