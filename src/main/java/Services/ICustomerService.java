package Services;

import Domain.Customer;

import java.util.List;

public interface ICustomerService {

    public void addCustomer();

    public List<Customer> getAllCustomers();

    public void showAllCustomers();

    public String setCustomerName();

}
