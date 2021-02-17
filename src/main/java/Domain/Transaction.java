package Domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Transaction {
    private int id;
    private Customer customer;
    private int amount;
    private String timeStamp;
    private Date date;
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Transaction(int amount, Customer customer, Date date) {
        this.amount = amount;
        this.customer = customer;
        this.date = date;
    }

    public Transaction(int id, Customer customer, int amount, String timeStamp) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
        this.timeStamp = timeStamp;
    }

    public String getDateAsString() {
        date = Calendar.getInstance().getTime();
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getCustomerID() {
        return customer.getCustomerID();
    }


    @Override
    public String toString() {
        if (timeStamp == null) {
            return customer.getName() + ": Transaction made: " + amount + ",- " + "on: " + getDateAsString();
        }
        return customer.getName() + ": Transaction made: " + amount + ",- " + "on: " + timeStamp;
    }
}
