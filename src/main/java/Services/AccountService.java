package Services;

import Domain.Customer;
import Domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AccountService implements IAccountService {
    ITransactionService ts = new TransactionService();


    public int getBalanceFromDB(Customer customer) {
        List<Transaction> customerTransactions = new ArrayList<>();
        int sum = 0;
        for (Transaction t : ts.getAllTransactions()) {
            if (t.getCustomerID() == customer.getCustomerID()) {
                customerTransactions.add(t);
            }
        }
        for (Transaction t : customerTransactions) {
            sum += t.getAmount();
        }
        return sum;
    }
}