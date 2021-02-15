package Services;

import Domain.*;

import java.util.Scanner;

public class CustomerService implements ICustomerService {
    Scanner sc = new Scanner(System.in);
    String name;


    public void addCustomer() {
        Customer customer = new Customer();
        name = setCustomerName();

    }

    public String setCustomerName() {
        String name = "";
        System.out.print("Enter customer name: ");
        name = sc.nextLine();
        return name;
    }
}
