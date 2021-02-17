package Controller;

import Domain.Account;
import Domain.Customer;
import Exceptions.BankException;
import Services.*;
import UI.*;

import java.util.Scanner;

public class CustomerController {
    Scanner sc = new Scanner(System.in);
    IUI ui = new UI();
    int choice = 0;
    Customer customer;
    Account a1 = new Account(customer);
    ICustomerService cs = new CustomerService();
    ITransactionService ts = new TransactionService();
    IAccountService as = new AccountService();

    public void runCustomerMenu() {
        System.out.println("Enter your email");
        String email = sc.nextLine();
        customer = cs.getCustomer(email);
        while (choice != 9) {
            System.out.println("\n" + "Logged in as: " + customer.getName());
            System.out.println("Balance changes: " + a1.getBalance());
            System.out.println("Current balance: " + as.getBalanceFromDB(customer));
            ui.showCustomerMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    try {
                        a1.depositAmount(sc.nextInt(), customer);
                    } catch (BankException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    try {
                        a1.withdrawAmount(sc.nextInt(), customer);
                    } catch (BankException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    if (a1.getTransactions().isEmpty()) {
                        System.out.println("No active transactions");
                    } else {
                        a1.showAllTransactions();
                    }
                    break;
                case 4:
                    ts.getPreviousTransactionsByCustomer(customer);
                    break;
                case 5:
                    ts.confirmTransaction(a1.getTransactions());
                    a1.getTransactions().clear();
                    break;
                default:
                    choice = 9;
                    break;
            }
        }
    }
}
