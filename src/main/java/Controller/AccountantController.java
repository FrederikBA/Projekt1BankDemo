package Controller;

import Services.CustomerService;
import UI.*;

import java.util.Scanner;

public class AccountantController {
    Scanner sc = new Scanner(System.in);
    CustomerService cs = new CustomerService();
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
                default:
                    choice = 9;
                    break;
            }
        }
    }
}
