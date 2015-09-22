package Tests;

import BusinessLogic.AssertCheck;
import BusinessLogic.Base;
import Pages.InsertPage;
import Pages.TransactionsInsertPage;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Евгений on 19.09.2015.
 */
public class FillUpBalanceTests extends Base{

    @Test
    public void fillUpRealMoneyTest() throws ParseException, InterruptedException {

        //create values
        String expectedUserName = "UN914222528";
        String mainWindow= driver.getWindowHandle();
        List<String> listOfWindows = new LinkedList<String>();
        String expectedAccount = "Real Money";
        String expectedRealMoney = "598";
        String expectedNotes = "HElloWorld!";


        //login and open user for editing
        loginAs("admin", "123");

        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        playersListPage.clickEditButton();

        //click on add Transaction
        InsertPage insertPage = new InsertPage(driver);
        //read current Real Money balance into int
        double currentRealMoneyBalance = convertStringTodouble(insertPage.getRealMoneyActualValue());

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

        Thread.sleep(2000);
        //waitForAjax();

        driver.switchTo().window(mainWindow);
        double actualRealMoneyBalance = convertStringTodouble(insertPage.getRealMoneyActualValue());


        AssertCheck assertCheck = new AssertCheck(driver);

        assertCheck.assertEquals(actualRealMoneyBalance, currentRealMoneyBalance+Double.parseDouble(expectedRealMoney));
        assertCheck.printErrors();

    }

    @Test
    public void fillUpFunMoneyTest() throws ParseException, InterruptedException {

        //create values
        String expectedUserName = "UN914222528";
        String mainWindow= driver.getWindowHandle();
        List<String> listOfWindows = new LinkedList<String>();
        String expectedAccount = "Fun Money";
        String expectedFunMoney = "597";
        String expectedNotes = "HElloWorld!";


        //login and open user for editing
        loginAs("admin", "123");

        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        playersListPage.clickEditButton();



        //click on add Transaction
        InsertPage insertPage = new InsertPage(driver);
        //read current Fun Money balance into int

        double currentFunMoneyBalance = convertStringTodouble(insertPage.getFunMoneyActualValue());

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
        Thread.sleep(2000);
        //waitForAjax();

        driver.switchTo().window(mainWindow);

        double actualFunMoney = convertStringTodouble(insertPage.getFunMoneyActualValue());

        AssertCheck assertCheck = new AssertCheck(driver);
        assertCheck.assertEquals(actualFunMoney, currentFunMoneyBalance + Double.parseDouble(expectedFunMoney));
        assertCheck.printErrors();


    }

    @Test
    public void fillUpBonusDollarsTest() throws ParseException, InterruptedException {

        //create values
        String expectedUserName = "UN914222528";
        String mainWindow= driver.getWindowHandle();
        List<String> listOfWindows = new LinkedList<String>();
        String expectedAccount = "Bonus Dollars";
        String expectedBonusDollars = "597";
        String expectedNotes = "HElloWorld!";


        //login and open user for editing
        loginAs("admin", "123");

        playersListPage.setUserNameField(expectedUserName);
        playersListPage.clickSearchButton();
        playersListPage.clickEditButton();



        //click on add Transaction
        InsertPage insertPage = new InsertPage(driver);
        //read current Fun Money balance into int
        double currentBonusDollarsBalance = convertStringTodouble(insertPage.getBonusDollarsActualValue());


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
        Thread.sleep(2000);
         //waitForAjax();

        driver.switchTo().window(mainWindow);
        //read actual value
        double actualBonusDollarsBalance = convertStringTodouble(insertPage.getBonusDollarsActualValue());

        //checks
        AssertCheck assertCheck = new AssertCheck(driver);
        assertCheck.assertEquals(actualBonusDollarsBalance, currentBonusDollarsBalance+Double.parseDouble(expectedBonusDollars));
        assertCheck.printErrors();

    }
}
