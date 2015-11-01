package test_models;

/**
 * Created by Евгений on 30.09.2015.
 */
public class TransactionBuilder {
    private String account;
    private String amount;
    private String notes;

    public TransactionBuilder withAccount(String account) {
        this.account = account;
        return this;
    }

    public TransactionBuilder withAmount(String amount) {
        this.amount = amount;
        return this;
    }


    public TransactionBuilder withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Transaction build() {
        return new Transaction(account, amount, notes);
    }


}
