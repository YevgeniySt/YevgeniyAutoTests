package BusinessLogic;

import Objects.Player;
import Objects.PlayerBuilder;
import Pages.LoginPage;
import Pages.PlayersListPage;
import Utils.AssertCheck;
import Utils.WindowsHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Евгений on 20.09.2015.
 */
public class Base {

    public WebDriver driver;
    public LoginPage loginPage;
    public PlayersListPage playersListPage;
    public AssertCheck assertCheck = new AssertCheck();
    public static String mainWindow;

    @BeforeMethod
    public void openSiteAndLogin() {
        assertCheck.clearListOfAsserts();
        driver = new FirefoxDriver();
        driver.get("http://193.138.245.222:81/auth/login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);





        loginPage.setUserNameField("admin");
        loginPage.setPasswordField("123");
        playersListPage = loginPage.clickOnLogin();
        mainWindow = WindowsHandler.getCurrentWindow(driver);
    }

    @AfterMethod
    public void closeSite() {
        driver.close();
    }
}

