package Services;

import Domain.Transaction;

import java.util.ArrayList;

public interface ITransactionService {

    public void confirmTransaction(ArrayList<Transaction> transactions);

}
