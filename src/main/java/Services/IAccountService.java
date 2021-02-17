package Services;

import Domain.Account;
import Domain.Customer;

public interface IAccountService {

    public int getBalanceFromDB(Customer customer);

}
