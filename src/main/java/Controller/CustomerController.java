package Controller;

import Domain.Account;
import Domain.Customer;
import Exceptions.BankException;
import UI.*;

import java.util.Scanner;

public class CustomerController {
    Scanner sc = new Scanner(System.in);
    IUI ui = new UI();
    int choice = 0;
    Customer c1 = new Customer("John");
    Account a1 = new Account(c1);

    public void runCustomerMenu() {
        while (choice != 9) {
            ui.showCustomerMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    try {
                        a1.depositAmount(sc.nextInt());
                    } catch (BankException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    try {
                        a1.withdrawAmount(sc.nextInt());
                    } catch (BankException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println(a1.getBalance());
                    break;
                default:
                    choice = 9;
                    break;
            }
        }
    }
}
