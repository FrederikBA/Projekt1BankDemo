package Services;

import Domain.Customer;
import Domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public interface ITransactionService {

    public void confirmTransaction(ArrayList<Transaction> transactions);

    public List<Transaction> getAllTransactions();

    public void getPreviousTransactionsByCustomer(Customer customer);
}
