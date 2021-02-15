package UI;

public class UI implements IUI {

    public void showUserMenu() {
        System.out.println("Proceed as:");
        System.out.println("1) Customer");
        System.out.println("9) Exit");
    }

    public void showCustomerMenu() {
        System.out.println("1) Deposit amount");
        System.out.println("2) Withdraw amount");
        System.out.println("3) Show account funds");
        System.out.println("9) Go back");
    }

    public void showExitMessage() {
        System.out.println("Exiting..");
    }

}
