package Controller;

import Domain.*;
import Exceptions.*;
import UI.*;

import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    IUI ui = new UI();
    int choice = 0;
    Customer c1 = new Customer("John");
    Account a1 = new Account(c1);

    public void runProgram() {
        while (choice != 9) {
            ui.showUserMenu();
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
                    ui.showExitMessage();
                    choice = 9;
                    break;
            }
        }
    }
}
