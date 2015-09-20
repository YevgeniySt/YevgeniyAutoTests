package Tests;

import BusinessLogic.AssertCheck;
import BusinessLogic.Base;
import Pages.InsertPage;
import Pages.PlayersListPage;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Евгений on 17.09.2015.
 */
public class CreatePlayerTest extends Base{

    @Test
    public void createPlayerTest() throws InterruptedException {

        //create expected values
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        String expectedUserName = "UN" + String.valueOf(dateFormat.format(date));
        String expectedPassword = "Password1";
        String expectedEmail = expectedUserName + "@mail.ru";
        String expectedPhone = "123456";
        String expectedGender = "Male";
        boolean expectedPayment = Boolean.parseBoolean("true");
        String expectedRealMoney = "$0.00";
        String expectedFunMoney = "1,00.00";
        String expectedBonusDollars = "$0.005";
        String expectedLoyaltyPoints = "0.00 LP";

        //Fill data and login
        loginAs("admin", "123");

        //create instance of Insert Page and click Insert
        InsertPage insertPage = playersListPage.clickInsert();

        //fill fields on Insert page and click Save
        insertPage.setUsernameField(expectedUserName);
        insertPage.setEmailField(expectedEmail);
        insertPage.setPasswordField(expectedPassword);
        insertPage.setPasswordConfirmField(expectedPassword);
        insertPage.setPhoneField(expectedPhone);
        insertPage.clickOnSaveButton();


        //set username for search and click search
        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        //click Edit
        playersListPage.clickEditButton();


        //get players values
        String userNameActualValue = insertPage.getUserNameActualValue();
        String actualEmail = insertPage.getEmailActualValue();
        String actualPhone = insertPage.getPhoneActualValue();
        String actualGender = insertPage.getGenderActualValue();
        boolean actualPaymentCheckboxState = insertPage.getPaymentActualValue();
        String actualRealMoney = insertPage.getRealMoneyActualValue();
        String actualFunMoney = insertPage.getFunMoneyActualValue();
        String actualBonusDollars = insertPage.getBonusDollarsActualValue();
        String actualLoyaltyPoints = insertPage.getLoyaltyPointsActualValue();


        //check values
        AssertCheck assertCheck = new AssertCheck(driver);

        assertCheck.assertEquals(userNameActualValue, expectedUserName);
        assertCheck.assertEquals(actualEmail, expectedEmail);
        assertCheck.assertEquals(actualPhone, expectedPhone);
        assertCheck.assertEquals(actualGender, expectedGender);
        assertCheck.assertEquals(actualPaymentCheckboxState, expectedPayment);
        assertCheck.assertEquals(actualRealMoney, expectedRealMoney);
        assertCheck.assertEquals(actualFunMoney, expectedFunMoney);
        assertCheck.assertEquals(actualBonusDollars, expectedBonusDollars);
        assertCheck.assertEquals(actualLoyaltyPoints, expectedLoyaltyPoints);
        //print errors
        assertCheck.printErrors();

    }
}
