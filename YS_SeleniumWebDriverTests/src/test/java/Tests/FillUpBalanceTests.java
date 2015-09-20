package Tests;

import BusinessLogic.AssertCheck;
import BusinessLogic.Base;
import Pages.InsertPage;
import Pages.TransactionsInsertPage;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Евгений on 19.09.2015.
 */
public class FillUpBalanceTests extends Base{

    @Test
    public void fillUpRealMoneyTest() throws ParseException{

        //create values
        String expectedUserName = "UN914222528";
        String mainWindow= driver.getWindowHandle();
        List<String> listOfWindows = new LinkedList<String>();
        String expectedAccount = "Real Money";
        String expectedRealMoney = "598";
        String expectedNotes = "HElloWorld!";


        //login and open user for editing
        loginAs("admin","123");

        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        playersListPage.clickEditButton();

        //click on add Transaction
        InsertPage insertPage = new InsertPage(driver);
        //read current Real Money balance into int
        double currentRealMoneyBalance = convertStringWithDollarBeforeToInt(insertPage.getRealMoneyActualValue());

        //click add transaction button
        TransactionsInsertPage transactionsInsertPage= insertPage.clickOnAddTransactionButton();

        //add mainwindow into list
        listOfWindows.add(mainWindow);

        for(String winHandle :driver.getWindowHandles()) {
             driver.switchTo().window(winHandle);
            listOfWindows.add(driver.switchTo().window(winHandle).getWindowHandle());

            if (driver.getTitle().equals("Transactions - Insert")) {
                break;
            }
        }

        //fill mandatory fields

        transactionsInsertPage.setAccountCombobox(expectedAccount);
        transactionsInsertPage.setAmount(expectedRealMoney);
        transactionsInsertPage.setNotes(expectedNotes);
        transactionsInsertPage.clickSave();

        //driver.close();
        driver.switchTo().window(mainWindow);
        double actualRealMoneyBalance = convertStringWithDollarBeforeToInt(insertPage.getRealMoneyActualValue());


        AssertCheck assertCheck = new AssertCheck(driver);

        assertCheck.assertEquals(actualRealMoneyBalance, currentRealMoneyBalance+Double.parseDouble(expectedRealMoney));
        assertCheck.printErrors();

    }

    @Test
    public void fillUpFunMoneyTest() throws ParseException{

        //create values
        String expectedUserName = "UN914222528";
        String mainWindow= driver.getWindowHandle();
        List<String> listOfWindows = new LinkedList<String>();
        String expectedAccount = "Fun Money";
        String expectedFunMoney = "597";
        String expectedNotes = "HElloWorld!";


        //login and open user for editing
        loginAs("admin","123");

        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        playersListPage.clickEditButton();



        //click on add Transaction
        InsertPage insertPage = new InsertPage(driver);
        //read current Fun Money balance into int

        double currentFunMoneyBalance = convertStringToInt(insertPage.getFunMoneyActualValue());

        //click add transaction button
        TransactionsInsertPage transactionsInsertPage= insertPage.clickOnAddTransactionButton();

        //add mainwindow into list
        listOfWindows.add(mainWindow);

        for(String winHandle :driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            listOfWindows.add(driver.switchTo().window(winHandle).getWindowHandle());

            if (driver.getTitle().equals("Transactions - Insert")) {
                break;
            }
        }

        //fill mandatory fields

        transactionsInsertPage.setAccountCombobox(expectedAccount);
        transactionsInsertPage.setAmount(expectedFunMoney);
        transactionsInsertPage.setNotes(expectedNotes);
        transactionsInsertPage.clickSave();

        //driver.close();
        driver.switchTo().window(mainWindow);

        double actualFunMoney = convertStringToInt(insertPage.getFunMoneyActualValue());

        AssertCheck assertCheck = new AssertCheck(driver);
        assertCheck.assertEquals(actualFunMoney, currentFunMoneyBalance + Double.parseDouble(expectedFunMoney));
        assertCheck.printErrors();


    }

    @Test
    public void fillUpBonusDollarsTest() throws ParseException{

        //create values
        String expectedUserName = "UN914222528";
        String mainWindow= driver.getWindowHandle();
        List<String> listOfWindows = new LinkedList<String>();
        String expectedAccount = "Bonus Dollars";
        String expectedBonusDollars = "597";
        String expectedNotes = "HElloWorld!";


        //login and open user for editing
        loginAs("admin","123");

        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        playersListPage.clickEditButton();



        //click on add Transaction
        InsertPage insertPage = new InsertPage(driver);
        //read current Fun Money balance into int
        double currentBonusDollarsBalance = convertStringWithDollarBeforeToInt(insertPage.getBonusDollarsActualValue());


        //click add transaction button
        TransactionsInsertPage transactionsInsertPage= insertPage.clickOnAddTransactionButton();

        //add mainwindow into list
        listOfWindows.add(mainWindow);

        for(String winHandle :driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            listOfWindows.add(driver.switchTo().window(winHandle).getWindowHandle());

            if (driver.getTitle().equals("Transactions - Insert")) {
                break;
            }
        }

        //fill mandatory fields

        transactionsInsertPage.setAccountCombobox(expectedAccount);
        transactionsInsertPage.setAmount(expectedBonusDollars);
        transactionsInsertPage.setNotes(expectedNotes);
        transactionsInsertPage.clickSave();

        //driver.close();
        driver.switchTo().window(mainWindow);
        //read actual value
        double actualBonusDollarsBalance = convertStringWithDollarBeforeToInt(insertPage.getBonusDollarsActualValue());

        //checks
        AssertCheck assertCheck = new AssertCheck(driver);
        assertCheck.assertEquals(actualBonusDollarsBalance, currentBonusDollarsBalance+Double.parseDouble(expectedBonusDollars));
        assertCheck.printErrors();

    }
}
