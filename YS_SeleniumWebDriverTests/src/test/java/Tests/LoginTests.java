package Tests;


import BusinessLogic.AssertCheck;
import BusinessLogic.Base;
import org.testng.annotations.*;

/**
 * Created by Евгений on 15.09.2015.
 */
public class LoginTests extends Base{


    @Test
    public void LoginPositiveTest() throws InterruptedException {


        loginAs("admin","123");
        playersListPage.isUserNameDisplayed();
    }

    @Test
    public void LoginNegativeTest() throws InterruptedException {

        loginAs("admin","1234");

        String expectedErrorLabel = loginPage.getErrorLoginText();

        AssertCheck assertCheck = new AssertCheck(driver);
        assertCheck.assertEquals(expectedErrorLabel, "Invalid username or passord");
        assertCheck.printErrors();
    }


}
