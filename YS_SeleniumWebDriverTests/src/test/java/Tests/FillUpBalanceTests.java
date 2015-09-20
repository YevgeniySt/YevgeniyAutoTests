package Tests;

import BusinessLogic.AssertCheck;
import BusinessLogic.Base;
import Pages.InsertPage;
import Pages.TransactionsInsertPage;
import org.testng.annotations.Test;

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
        NumberFormat ukFormat = NumberFormat.getNumberInstance(Locale.UK);

        //login and open user for editing
        loginAs("admin","123");

        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        playersListPage.clickEditButton();

        //click on add Transaction
        InsertPage insertPage = new InsertPage(driver);
        //read current Real Money balance into int

        String currentRealMoney = insertPage.getRealMoneyActualValue();
        String currentRealMoneySubstring = currentRealMoney.substring(1,currentRealMoney.length()-1);
        int currentRealMoneyBalance = ukFormat.parse(currentRealMoneySubstring).intValue();

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

        String actualRealMoney = insertPage.getRealMoneyActualValue();
        String actualRealMoneySubstring = actualRealMoney.substring(1,actualRealMoney.length()-1);
        int actualRealMoneyBalance = ukFormat.parse(actualRealMoneySubstring).intValue();


        AssertCheck assertCheck = new AssertCheck(driver);

        assertCheck.assertEquals(actualRealMoneyBalance, currentRealMoneyBalance+Integer.parseInt(expectedRealMoney));
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
        NumberFormat ukFormat = NumberFormat.getNumberInstance(Locale.UK);

        //login and open user for editing
        loginAs("admin","123");

        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        playersListPage.clickEditButton();



        //click on add Transaction
        InsertPage insertPage = new InsertPage(driver);
        //read current Fun Money balance into int
        int currentFunMoneyBalance = ukFormat.parse(insertPage.getFunMoneyActualValue()).intValue();

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

        String actualFunMoney = insertPage.getFunMoneyActualValue();


        AssertCheck assertCheck = new AssertCheck(driver);

        assertCheck.assertEquals(ukFormat.parse(actualFunMoney).intValue(), currentFunMoneyBalance+Integer.parseInt(expectedFunMoney));
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
        NumberFormat ukFormat = NumberFormat.getNumberInstance(Locale.UK);

        //login and open user for editing
        loginAs("admin","123");

        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        playersListPage.clickEditButton();



        //click on add Transaction
        InsertPage insertPage = new InsertPage(driver);
        //read current Fun Money balance into int
        String currentBonusDollars = insertPage.getBonusDollarsActualValue();
        String currentBonusDollarsSubstring = currentBonusDollars.substring(1, currentBonusDollars.length()-1);
        int currentBonusDollarsBalance = ukFormat.parse(currentBonusDollarsSubstring).intValue();


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

        String actualBonusDollars = insertPage.getBonusDollarsActualValue();
        String actualBonusDollarsSubstring = actualBonusDollars.substring(1, actualBonusDollars.length() - 1);
        int actualBonusDollarsBalance = ukFormat.parse(actualBonusDollarsSubstring).intValue();




        AssertCheck assertCheck = new AssertCheck(driver);

        assertCheck.assertEquals(actualBonusDollarsBalance, currentBonusDollarsBalance+Integer.parseInt(expectedBonusDollars));
        assertCheck.printErrors();

    }
}
