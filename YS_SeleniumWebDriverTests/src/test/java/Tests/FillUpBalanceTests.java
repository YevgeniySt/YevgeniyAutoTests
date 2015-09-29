package Tests;

import BusinessLogic.Base;
import BusinessLogic.PlayersListPageActions;
import BusinessLogic.TransactionsInsertPageActions;
import Pages.PlayersEditPage;
import Pages.TransactionsInsertPage;
import Utils.ConvertStringToDouble;
import Utils.WindowsHandler;
import org.testng.annotations.Test;
import java.text.ParseException;

/**
 * Created by Евгений on 19.09.2015.
 */
public class FillUpBalanceTests extends Base{

    @Test
    public void fillUpRealMoneyTest() throws ParseException, InterruptedException {

        //create values
        String expectedUserName = "UN";
        String mainWindow = WindowsHandler.getCurrentWindow(driver);
        String expectedAccount = "Real Money";
        String expectedRealMoney = "598";
        String expectedNotes = "HElloWorld!";

        //search for player
        PlayersListPageActions.searchForPlayer(playersListPage, expectedUserName);
        //click edit
        PlayersEditPage playersEditPage = playersListPage.clickEditButton();
        //read current Real Money balance into double
        double currentRealMoneyBalance = ConvertStringToDouble.convertStringToDouble(playersEditPage.getRealMoneyActualValue());

        //click add transaction button
        TransactionsInsertPage transactionsInsertPage= playersEditPage.clickOnAddTransactionButton();

        //fill mandatory fields

        TransactionsInsertPageActions.setValuesForTransaction(transactionsInsertPage, expectedAccount, expectedRealMoney, expectedNotes);
        //click save
        playersEditPage =transactionsInsertPage.clickSave();

        Thread.sleep(2000);

        //read RealMoneyBalance into double
        double actualRealMoneyBalance = ConvertStringToDouble.convertStringToDouble(playersEditPage.getRealMoneyActualValue());

        //checks
        assertCheck.assertEquals(actualRealMoneyBalance, currentRealMoneyBalance+Double.parseDouble(expectedRealMoney));
        assertCheck.printErrors();

    }

    @Test
    public void fillUpFunMoneyTest() throws ParseException, InterruptedException {

        //create values
        String expectedUserName = "UN";
        String expectedAccount = "Fun Money";
        String expectedFunMoney = "597";
        String expectedNotes = "HElloWorld!";

        //search for player
        PlayersListPageActions.searchForPlayer(playersListPage, expectedUserName);
        //click edit
        PlayersEditPage playersEditPage = playersListPage.clickEditButton();

        //read current Fun Money balance into double

        double currentFunMoneyBalance = ConvertStringToDouble.convertStringToDouble(playersEditPage.getFunMoneyActualValue());

        //click add transaction button
        TransactionsInsertPage transactionsInsertPage= playersEditPage.clickOnAddTransactionButton();

        //fill mandatory fields
        TransactionsInsertPageActions.setValuesForTransaction(transactionsInsertPage, expectedAccount, expectedFunMoney, expectedNotes);
        //click save
        playersEditPage =transactionsInsertPage.clickSave();
        Thread.sleep(2000);

        //switch to main window

        //read actual fun money into double
        double actualFunMoney = ConvertStringToDouble.convertStringToDouble(playersEditPage.getFunMoneyActualValue());

        //checks
        assertCheck.assertEquals(actualFunMoney, currentFunMoneyBalance + Double.parseDouble(expectedFunMoney));
        assertCheck.printErrors();


    }

    @Test
    public void fillUpBonusDollarsTest() throws ParseException, InterruptedException {

        //create values
        String expectedUserName = "UN";
        String mainWindow = WindowsHandler.getCurrentWindow(driver);
        String expectedAccount = "Bonus Dollars";
        String expectedBonusDollars = "597";
        String expectedNotes = "HElloWorld!";

        //search for player
        PlayersListPageActions.searchForPlayer(playersListPage, expectedUserName);
        //click edit
        PlayersEditPage playersEditPage = playersListPage.clickEditButton();

        //read current Fun Money balance into double
        double currentBonusDollarsBalance = ConvertStringToDouble.convertStringToDouble(playersEditPage.getBonusDollarsActualValue());

        //click add transaction button
        TransactionsInsertPage transactionsInsertPage= playersEditPage.clickOnAddTransactionButton();

        //fill mandatory fields
        TransactionsInsertPageActions.setValuesForTransaction(transactionsInsertPage, expectedAccount,expectedBonusDollars, expectedNotes);

        //click save
        playersEditPage =transactionsInsertPage.clickSave();
        Thread.sleep(2000);

        //read actual value
        double actualBonusDollarsBalance = ConvertStringToDouble.convertStringToDouble(playersEditPage.getBonusDollarsActualValue());

        //checks
        assertCheck.assertEquals(actualBonusDollarsBalance, currentBonusDollarsBalance+Double.parseDouble(expectedBonusDollars));
        assertCheck.printErrors();

    }
}
