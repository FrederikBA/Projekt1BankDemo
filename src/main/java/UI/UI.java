package UI;

public class UI implements IUI {

    public void showUserMenu() {
        System.out.println("Proceed as:");
        System.out.println("1) Customer");
        System.out.println("2) Accountant");
        System.out.println("9) Exit");
    }

    public void showCustomerMenu() {
        System.out.println("1) Deposit amount");
        System.out.println("2) Withdraw amount");
        System.out.println("3) Show active transactions");
        System.out.println("4) Show all transactions");
        System.out.println("5) Confirm transactions");
        System.out.println("9) Go back");
    }

    public void showAccountantMenu() {
        System.out.println("1) Add Customer");
        System.out.println("2) Show all customers");
        System.out.println("9) Go back");
    }

    public void showExitMessage() {
        System.out.println("Exiting..");
    }

}
