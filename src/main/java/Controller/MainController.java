package Controller;

import UI.*;

import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    IUI ui = new UI();
    CustomerController cc = new CustomerController();
    AccountantController ac = new AccountantController();
    int choice = 0;

    public void runProgram() {
        while (choice != 9) {
            ui.showUserMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    cc.runCustomerMenu();
                    break;
                case 2:
                    ac.runAccountantMenu();
                    break;
                default:
                    ui.showExitMessage();
                    choice = 9;
                    break;
            }
        }
    }
}
