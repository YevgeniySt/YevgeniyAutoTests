package test_models;

/**
 * Created by Евгений on 30.09.2015.
 */
public class Transaction {
    public String account;
    public String amount;
    public String notes;
    public Transaction(String account, String amount, String notes) {

        this.account=account;
        this.amount=amount;
        this.notes=notes;
    }
}
