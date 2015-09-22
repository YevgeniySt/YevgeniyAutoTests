package BusinessLogic;

import Pages.LoginPage;
import Pages.PlayersListPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.text.ParseException;


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

    public void loginAs(String admin, String password) {
        loginPage.setUserNameField(admin);
        loginPage.setPasswordField(password);
        playersListPage = loginPage.clickOnLogin();
    }

    public double convertStringTodouble(String actualValue) throws ParseException {
        String currentRealMoneySubstring = actualValue;
        currentRealMoneySubstring = currentRealMoneySubstring.replaceAll("[$,]+", "");
        return new Double(currentRealMoneySubstring);
    }

    /*public void waitForAjax() throws InterruptedException {
        while (true) // Handle timeout somewhere
        {
            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) driver).executeScript("return $.active == 0");
            if (ajaxIsComplete)
                break;
            Thread.sleep(1000);
        }
    }*/
}

