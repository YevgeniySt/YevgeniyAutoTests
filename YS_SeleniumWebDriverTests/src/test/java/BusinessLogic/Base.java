package BusinessLogic;

import Pages.LoginPage;
import Pages.PlayersListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

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

    public double convertStringWithDollarBeforeToInt(String actualValue) throws ParseException {
        String currentRealMoneySubstring = actualValue.substring(1, actualValue.length() - 1);
        currentRealMoneySubstring = currentRealMoneySubstring.replace(",", "");
        return new Double(currentRealMoneySubstring);
    }

    public double convertStringToInt(String actualValue) throws ParseException {
        String currentRealMoneySubstring = actualValue;
        currentRealMoneySubstring = currentRealMoneySubstring.replace(",", "");
        return new Double(currentRealMoneySubstring);
    }
}

