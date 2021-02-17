package Controller;

import Services.*;
import UI.*;

import java.util.Scanner;

public class AccountantController {
    Scanner sc = new Scanner(System.in);
    ICustomerService cs = new CustomerService();
    IAccountService as = new AccountService();
    IUI ui = new UI();
    int choice = 0;

    public void runAccountantMenu() {
        while (choice != 9) {
            ui.showAccountantMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    cs.addCustomer();
                    break;
                case 2:
                    cs.showAllCustomers();
                    break;
                default:
                    choice = 9;
                    break;
            }
        }
    }
}
