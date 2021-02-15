package Domain;

import java.util.Date;

public class Transaction {
    private int id;
    private int amount;
    private Date date;

    public Transaction(int amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction made: " + amount + " " + "on: " + date;
    }
}
