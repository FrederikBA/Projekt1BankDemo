package Controller;

import Domain.*;
import Exceptions.*;
import UI.*;

import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    IUI ui = new UI();
    int choice = 0;

    public void runProgram() {
        while (choice != 9) {
            ui.showUserMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Stuff");
                    break;
                default:
                    ui.showExitMessage();
                    choice = 9;
                    break;
            }
        }
    }
}
