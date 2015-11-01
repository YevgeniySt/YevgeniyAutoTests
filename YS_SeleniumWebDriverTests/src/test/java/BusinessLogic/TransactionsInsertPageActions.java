package businesslogic;

import test_models.Transaction;
import pages.TransactionsInsertPage;

/**
 * Created by ������� on 27.09.2015.
 */
public class TransactionsInsertPageActions {

    public static void setValuesForTransaction(TransactionsInsertPage transactionsInsertPage, Transaction transaction) {
        transactionsInsertPage.setAccountCombobox(transaction.account);
        transactionsInsertPage.setAmount(transaction.amount);
        transactionsInsertPage.setNotes(transaction.notes);

    }


}
