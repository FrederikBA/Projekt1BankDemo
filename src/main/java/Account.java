import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private List<Transaction> transactions;
    private Customer customer;

    public Account(Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
    }

    public int getBalance() {
        int sum = 0;
        for (Transaction t : transactions) {
            sum += t.getAmount();
        }
        return sum;
    }

    public int withdrawAmount(int amount) throws BankException {
        if (amount <= 0) {
            throw new BankException("You cannot withdraw a negative value");
        } else if (amount > getBalance()) {
            throw new BankException("Insufficient funds on account");
        }
        transactions.add(new Transaction(-amount, new Date()));
        return getBalance();
    }


    public int depositAmount(int amount) throws BankException {
        if (amount <= 0) {
            throw new BankException("You cannot deposit a negative value");
        }
        transactions.add(new Transaction(amount, new Date()));
        return getBalance();
    }

    public void showAllTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

}
