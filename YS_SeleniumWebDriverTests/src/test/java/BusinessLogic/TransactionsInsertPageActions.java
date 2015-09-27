package BusinessLogic;

import Pages.TransactionsInsertPage;

/**
 * Created by Евгений on 27.09.2015.
 */
public class TransactionsInsertPageActions {

    public static void setValuesForTransaction(TransactionsInsertPage transactionsInsertPage, String expectedAccount, String expectedFunMoney, String expectedNotes) {
        transactionsInsertPage.setAccountCombobox(expectedAccount);
        transactionsInsertPage.setAmount(expectedFunMoney);
        transactionsInsertPage.setNotes(expectedNotes);

    }


}
