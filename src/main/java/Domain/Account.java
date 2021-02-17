package Domain;

import Exceptions.*;

import java.util.ArrayList;
import java.util.Date;


public class Account {
    private ArrayList<Transaction> transactions;
    private Customer customer;
    private int accountID;

    public Account(Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
    }

    public Account() {

    }

    public int getBalance() {
        int sum = 0;
        for (Transaction t : transactions) {
            sum += t.getAmount();
        }
        return sum;
    }

    public int withdrawAmount(int amount, Customer customer) throws BankException {
        if (amount <= 0) {
            throw new BankException("You cannot withdraw a negative value");
        } else {
            transactions.add(new Transaction(-amount, customer, new Date()));
        }
        return getBalance();
    }


    /*
        public int withdrawAmount(int amount, Customer customer) {
            transactions.add(new Transaction(-amount, customer, new Date()));
            return getBalance();
        }
    */
    public int depositAmount(int amount, Customer customer) throws BankException {
        if (amount <= 0) {
            throw new BankException("You cannot deposit a negative value");
        }
        transactions.add(new Transaction(amount, customer, new Date()));
        return getBalance();
    }

    public void showAllTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public int getAccountID() {
        return accountID;
    }
}
