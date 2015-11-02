package tests;

import businesslogic.Base;
import businesslogic.PlayersListPageActions;
import businesslogic.TransactionsInsertPageActions;
import test_models.Player;
import test_models.PlayerBuilder;
import test_models.Transaction;
import test_models.TransactionBuilder;
import pages.PlayersEditPage;
import pages.TransactionsInsertPage;
import utils.Converter;

import org.testng.annotations.Test;
import java.text.ParseException;


/**
 * Created by Евгений on 19.09.2015.
 */
public class FillUpBalanceTests extends Base{

    @Test(groups = { "g1" })
    public void fillUpRealMoneyTest() throws ParseException, InterruptedException {

        //create values
        Player expectedPlayer = new PlayerBuilder()
                .withUserName("UN")
                .build();

        Transaction transaction = new TransactionBuilder()
                .withAccount("Real Money")
                .withAmount("597")
                .withNotes("HElloWorld!").build();

        //search for player
        PlayersListPageActions.searchForPlayer(playersListPage, expectedPlayer);
        //click edit
        PlayersEditPage playersEditPage = playersListPage.clickEditButton();
        //read current Real Money balance into double
        double currentRealMoneyBalance = Converter.convertStringToDouble(playersEditPage.getRealMoneyActualValue());

        //click add transaction button
        TransactionsInsertPage transactionsInsertPage= playersEditPage.clickOnAddTransactionButton();

        //fill mandatory fields

        TransactionsInsertPageActions.setValuesForTransaction(transactionsInsertPage, transaction);
        //click save
        playersEditPage =transactionsInsertPage.clickSave();

        Thread.sleep(2000);

        //read RealMoneyBalance into double
        double actualRealMoneyBalance = Converter.convertStringToDouble(playersEditPage.getRealMoneyActualValue());

        //checks
        assertCheck.assertEquals(actualRealMoneyBalance, currentRealMoneyBalance+Double.parseDouble(transaction.amount));
        assertCheck.printErrors();

    }

    @Test(groups = { "g2" })
    public void fillUpFunMoneyTest() throws ParseException, InterruptedException {

        //create values
        Player expectedPlayer = new PlayerBuilder()
                .withUserName("UN")
                .build();

        Transaction transaction = new TransactionBuilder()
                .withAccount("Fun Money")
                .withAmount("597")
                .withNotes("HElloWorld!").build();

        //search for player
        PlayersListPageActions.searchForPlayer(playersListPage, expectedPlayer);
        //click edit
        PlayersEditPage playersEditPage = playersListPage.clickEditButton();

        //read current Fun Money balance into double

        double currentFunMoneyBalance = Converter.convertStringToDouble(playersEditPage.getFunMoneyActualValue());

        //click add transaction button
        TransactionsInsertPage transactionsInsertPage= playersEditPage.clickOnAddTransactionButton();

        //fill mandatory fields
        TransactionsInsertPageActions.setValuesForTransaction(transactionsInsertPage, transaction);
        //click save
        playersEditPage =transactionsInsertPage.clickSave();
        Thread.sleep(2000);

        //switch to main window

        //read actual fun money into double
        double actualFunMoney = Converter.convertStringToDouble(playersEditPage.getFunMoneyActualValue());

        //checks
        assertCheck.assertEquals(actualFunMoney, currentFunMoneyBalance + Double.parseDouble(transaction.amount));
        assertCheck.printErrors();


    }

    @Test(groups = { "g1" })
    public void fillUpBonusDollarsTest() throws ParseException, InterruptedException {

        //create values
        Player expectedPlayer = new PlayerBuilder()
                .withUserName("UN")
                .build();

        Transaction transaction = new TransactionBuilder()
                .withAccount("Bonus Dollars")
                .withAmount("597")
                .withNotes("HElloWorld!").build();

        //search for player
        PlayersListPageActions.searchForPlayer(playersListPage, expectedPlayer);
        //click edit
        PlayersEditPage playersEditPage = playersListPage.clickEditButton();

        //read current Fun Money balance into double
        double currentBonusDollarsBalance = Converter.convertStringToDouble(playersEditPage.getBonusDollarsActualValue());

        //click add transaction button
        TransactionsInsertPage transactionsInsertPage= playersEditPage.clickOnAddTransactionButton();

        //fill mandatory fields
        TransactionsInsertPageActions.setValuesForTransaction(transactionsInsertPage, transaction);

        //click save
        playersEditPage =transactionsInsertPage.clickSave();
        Thread.sleep(2000);

        //read actual value
        double actualBonusDollarsBalance = Converter.convertStringToDouble(playersEditPage.getBonusDollarsActualValue());

        //checks
        assertCheck.assertEquals(actualBonusDollarsBalance, currentBonusDollarsBalance+Double.parseDouble(transaction.amount));
        assertCheck.printErrors();

    }
}
