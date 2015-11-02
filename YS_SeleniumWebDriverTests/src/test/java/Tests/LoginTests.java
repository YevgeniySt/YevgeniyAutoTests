package tests;


import pages.LoginPage;
import utils.AssertCheck;
import businesslogic.Base;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Created by Евгений on 15.09.2015.
 */
public class LoginTests extends Base{

    @Test(groups = { "g1" })
    public void LoginPositiveTest() throws InterruptedException {

        playersListPage.isUserNameDisplayed();
    }
    @Override
    @BeforeMethod
    public void openSiteAndLogin() {
        assertCheck = new AssertCheck();
        assertCheck.clearListOfAsserts();
        driver = new FirefoxDriver();
        driver.get("http://193.138.245.222:81/auth/login");
        loginPage = new LoginPage(driver);
        loginPage.setUserNameField("admin");
        loginPage.setPasswordField("124");
        playersListPage = loginPage.clickOnLogin();
    }
    @Test(groups = { "g2" })
    public void LoginNegativeTest() throws InterruptedException {

        String expectedErrorLabel = loginPage.getErrorLoginText();

        assertCheck.assertEquals(expectedErrorLabel, "Invalid username or passord");
        assertCheck.printErrors();
    }


}
