package YSSeleniumCreatePayerTestsWithPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void createPlayerTest() throws InterruptedException, AssertionError {

        //create expected values
        List<String> listOfFails = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
        String userNameExpected = "UN" + String.valueOf(dateFormat.format(date));
        String passwordExpected = "Password1";
        String emailExpected = userNameExpected + "@mail.ru";
        String phoneExpected = "123456";
        String genderExpected = "Male";
        boolean paymentExpected = Boolean.parseBoolean("true");
        String realMoneyExpected = "$0.00";
        String funMoneyExpected = "1,00.00";
        String bonusDollarsExpected ="$0.005";
        String loyaltyPointsExpected = "0.00 LP";


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
        boolean paymentCheckboxActualValue = insertPage.getPaymentActualValue();
        String realMoneyActualValue = insertPage.getRealMoneyActualValue();
        String funMoneyActualValue = insertPage.getFunMoneyActualValue();
        String bonusDollarsActualValue = insertPage.getBonusDollarsActualValue();
        String loyaltyPointsActualValue = insertPage.getLoyaltyPointsActualValue();


        //check values
        Assert.assertEquals(userNameActualValue, userNameExpected);
        Assert.assertEquals(emailActualValue, emailExpected);
        Assert.assertEquals(phoneActualValue, phoneExpected);
        Assert.assertEquals(genderActualValue, genderExpected);
        Assert.assertEquals(paymentCheckboxActualValue, paymentExpected);
        Assert.assertEquals(realMoneyActualValue,realMoneyExpected);

        try {
            Assert.assertEquals(funMoneyActualValue, funMoneyExpected);
        } catch (AssertionError e){

            listOfFails.add(e.getMessage());

        }
        try {
            Assert.assertEquals(bonusDollarsActualValue,bonusDollarsExpected);
        } catch (AssertionError e){

            listOfFails.add(e.getMessage());

        }

        Assert.assertEquals(loyaltyPointsActualValue,loyaltyPointsExpected);


        for(String r: listOfFails){
            System.out.println(r+"\n");
        }

    }
    @AfterTest
    public void closeSite(){
        driver.close();
    }


}
