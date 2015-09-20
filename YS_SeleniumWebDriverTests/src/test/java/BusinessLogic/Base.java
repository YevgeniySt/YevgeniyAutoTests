package BusinessLogic;

import Pages.LoginPage;
import Pages.PlayersListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Created by Евгений on 20.09.2015.
 */
public class Base {

    public WebDriver driver;
    public LoginPage loginPage;
    public PlayersListPage playersListPage;


    @BeforeMethod
    public void openSite() {
        driver = new FirefoxDriver();
        driver.get("http://193.138.245.222:81/auth/login");
        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void closeSite() {
        driver.close();
    }

    public void loginAs(String admin, String password){
        loginPage.setUserNameField(admin);
        loginPage.setPasswordField(password);
        playersListPage = loginPage.clickOnLogin();
    }
}

